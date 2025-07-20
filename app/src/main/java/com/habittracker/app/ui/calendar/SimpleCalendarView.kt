package com.habittracker.app.ui.calendar

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.habittracker.app.databinding.ViewSimpleCalendarBinding
import java.text.SimpleDateFormat
import java.util.*

class SimpleCalendarView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val binding: ViewSimpleCalendarBinding
    private lateinit var calendarAdapter: CalendarAdapter
    private var onDateSelectedListener: ((CalendarDay) -> Unit)? = null
    private var selectedDate: CalendarDay? = null
    private var currentMonth: Calendar = Calendar.getInstance()

    init {
        binding = ViewSimpleCalendarBinding.inflate(LayoutInflater.from(context), this, true)

        calendarAdapter = CalendarAdapter { day ->
            if (day.isCurrentMonth) {
                selectedDate = day
                onDateSelectedListener?.invoke(day)
                calendarAdapter.setSelectedDate(day)
            }
        }

        binding.recyclerViewCalendar.apply {
            layoutManager = GridLayoutManager(context, 7)
            adapter = calendarAdapter
            // 确保RecyclerView有固定大小以提高性能
            setHasFixedSize(true)
        }

        setupNavigation()
        updateCalendar()
    }

    private fun setupNavigation() {
        binding.buttonPrevMonth.setOnClickListener {
            currentMonth.add(Calendar.MONTH, -1)
            updateCalendar()
        }
        
        binding.buttonNextMonth.setOnClickListener {
            currentMonth.add(Calendar.MONTH, 1)
            updateCalendar()
        }
    }

    private fun updateCalendar() {
        val monthFormat = SimpleDateFormat("yyyy年MM月", Locale.CHINESE)
        binding.textCurrentMonth.text = monthFormat.format(currentMonth.time)

        val days = generateCalendarDays()
        // 使用新的列表实例确保DiffUtil能正确检测变化
        calendarAdapter.submitList(days.toList()) {
            // 提交完成后刷新视图
            binding.recyclerViewCalendar.post {
                calendarAdapter.notifyDataSetChanged()
            }
        }
    }

    private fun generateCalendarDays(): List<CalendarDay> {
        val days = mutableListOf<CalendarDay>()

        val calendar = Calendar.getInstance()
        calendar.time = currentMonth.time
        calendar.set(Calendar.DAY_OF_MONTH, 1)

        // Set the first day of the week to Sunday for consistent calculation
        calendar.firstDayOfWeek = Calendar.SUNDAY
        val firstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1
        val daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH) + 1

        // Add empty days for previous month
        repeat(firstDayOfWeek) {
            days.add(CalendarDay(0, 0, 0, false))
        }

        // Add days of current month
        for (day in 1..daysInMonth) {
            days.add(CalendarDay(year, month, day, true))
        }

        // Add empty days to complete the grid (6 rows * 7 days = 42 total)
        val totalCells = 42
        val remainingCells = totalCells - days.size
        repeat(remainingCells) {
            days.add(CalendarDay(0, 0, 0, false))
        }

        return days
    }

    fun setOnDateSelectedListener(listener: (CalendarDay) -> Unit) {
        onDateSelectedListener = listener
    }

    fun setSelectedDate(date: CalendarDay) {
        selectedDate = date
        calendarAdapter.setSelectedDate(date)
    }

    fun addDecorator(decorator: CalendarDecorator) {
        calendarAdapter.addDecorator(decorator)
    }

    fun removeDecorators() {
        calendarAdapter.clearDecorators()
    }

    fun invalidateCalendar() {
        calendarAdapter.notifyDataSetChanged()
    }

    // 调试方法：获取当前日历数据
    fun getCurrentCalendarDays(): List<CalendarDay> {
        return generateCalendarDays()
    }
}

data class CalendarDay(
    val year: Int,
    val month: Int,
    val day: Int,
    val isCurrentMonth: Boolean
) {
    companion object {
        fun today(): CalendarDay {
            val calendar = Calendar.getInstance()
            return CalendarDay(
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH) + 1,
                calendar.get(Calendar.DAY_OF_MONTH),
                true
            )
        }
    }
}

interface CalendarDecorator {
    fun shouldDecorate(day: CalendarDay): Boolean
    fun getBackgroundColor(): Int
}
