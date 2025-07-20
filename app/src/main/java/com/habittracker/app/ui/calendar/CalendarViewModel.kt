package com.habittracker.app.ui.calendar

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.habittracker.app.data.database.HabitDatabase
import com.habittracker.app.data.model.Habit
import com.habittracker.app.data.model.HabitRecord
import com.habittracker.app.data.repository.HabitRepository

import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class CalendarViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: HabitRepository
    
    private val _monthlyStats = MutableLiveData<MonthlyStats>()
    val monthlyStats: LiveData<MonthlyStats> = _monthlyStats
    
    private val _calendarDecorators = MutableLiveData<List<CalendarDecorator>>()
    val calendarDecorators: LiveData<List<CalendarDecorator>> = _calendarDecorators
    
    private val _selectedDate = MutableLiveData<CalendarDay>()
    val selectedDate: LiveData<CalendarDay> = _selectedDate
    
    private val _selectedDayDetails = MutableLiveData<List<DayDetailItem>>()
    val selectedDayDetails: LiveData<List<DayDetailItem>> = _selectedDayDetails

    init {
        val database = HabitDatabase.getDatabase(application)
        repository = HabitRepository(
            database.habitDao(),
            database.habitRecordDao(),
            database.motivationContentDao(),
            database.userSettingsDao()
        )
    }

    fun loadMonthData(date: CalendarDay) {
        viewModelScope.launch {
            val calendar = Calendar.getInstance()
            calendar.set(date.year, date.month - 1, 1)
            
            // Get first and last day of month
            val firstDay = calendar.time
            calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH))
            val lastDay = calendar.time
            
            val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            val startDate = dateFormat.format(firstDay)
            val endDate = dateFormat.format(lastDay)
            
            // Load records for the month
            val records = repository.getRecordsBetweenDates(startDate, endDate)
            val habits = repository.getAllActiveHabitsSync()
            
            // Calculate stats and decorators
            val stats = calculateMonthlyStats(records, habits, firstDay, lastDay)
            val decorators = createCalendarDecorators(records, habits)
            
            _monthlyStats.value = stats
            _calendarDecorators.value = decorators
        }
    }

    fun selectDate(date: CalendarDay) {
        _selectedDate.value = date
        viewModelScope.launch {
            val dateString = String.format("%04d-%02d-%02d", date.year, date.month, date.day)
            val records = repository.getRecordsByDateSync(dateString)
            val habits = repository.getAllActiveHabitsSync()
            
            val details = habits.map { habit ->
                val record = records.find { it.habitId == habit.id }
                DayDetailItem(
                    habitName = habit.name,
                    isCompleted = record?.isCompleted ?: false,
                    description = habit.description
                )
            }
            
            _selectedDayDetails.value = details
        }
    }

    private fun calculateMonthlyStats(
        records: List<HabitRecord>,
        habits: List<Habit>,
        firstDay: Date,
        lastDay: Date
    ): MonthlyStats {
        val calendar = Calendar.getInstance()
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val today = Calendar.getInstance()
        
        var totalDays = 0
        var completedDays = 0
        
        calendar.time = firstDay
        while (!calendar.time.after(lastDay) && !calendar.time.after(today.time)) {
            val dateString = dateFormat.format(calendar.time)
            val dayRecords = records.filter { it.date == dateString }
            val completedCount = dayRecords.count { it.isCompleted }
            
            if (dayRecords.isNotEmpty()) {
                totalDays++
                if (completedCount == habits.size && habits.isNotEmpty()) {
                    completedDays++
                }
            }
            
            calendar.add(Calendar.DAY_OF_MONTH, 1)
        }
        
        val completionRate = if (totalDays > 0) (completedDays * 100) / totalDays else 0
        
        return MonthlyStats(
            totalDays = totalDays,
            completedDays = completedDays,
            completionRate = completionRate
        )
    }

    private fun createCalendarDecorators(
        records: List<HabitRecord>,
        habits: List<Habit>
    ): List<CalendarDecorator> {
        val decorators = mutableListOf<CalendarDecorator>()
        
        // Group records by date
        val recordsByDate = records.groupBy { it.date }
        
        val completeDays = mutableListOf<CalendarDay>()
        val partialDays = mutableListOf<CalendarDay>()
        val incompleteDays = mutableListOf<CalendarDay>()
        
        recordsByDate.forEach { (dateString, dayRecords) ->
            val parts = dateString.split("-")
            if (parts.size == 3) {
                val calendarDay = CalendarDay(
                    parts[0].toInt(),
                    parts[1].toInt(),
                    parts[2].toInt(),
                    isCurrentMonth = true
                )
                
                val completedCount = dayRecords.count { it.isCompleted }
                val totalCount = habits.size
                
                when {
                    completedCount == totalCount && totalCount > 0 -> completeDays.add(calendarDay)
                    completedCount > 0 -> partialDays.add(calendarDay)
                    else -> incompleteDays.add(calendarDay)
                }
            }
        }
        
        if (completeDays.isNotEmpty()) {
            decorators.add(CompleteDayDecorator(completeDays))
        }
        if (partialDays.isNotEmpty()) {
            decorators.add(PartialDayDecorator(partialDays))
        }
        if (incompleteDays.isNotEmpty()) {
            decorators.add(IncompleteDayDecorator(incompleteDays))
        }
        
        return decorators
    }

    data class MonthlyStats(
        val totalDays: Int,
        val completedDays: Int,
        val completionRate: Int
    )
    
    data class DayDetailItem(
        val habitName: String,
        val isCompleted: Boolean,
        val description: String
    )
}
