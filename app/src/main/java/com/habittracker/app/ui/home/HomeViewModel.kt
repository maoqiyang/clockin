package com.habittracker.app.ui.home

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

class HomeViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: HabitRepository
    
    val habits: LiveData<List<Habit>>
    val todayRecords: LiveData<List<HabitRecord>>
    
    private val _saveResult = MutableLiveData<Boolean>()
    val saveResult: LiveData<Boolean> = _saveResult

    init {
        val database = HabitDatabase.getDatabase(application)
        repository = HabitRepository(
            database.habitDao(),
            database.habitRecordDao(),
            database.motivationContentDao(),
            database.userSettingsDao()
        )
        
        habits = repository.getAllActiveHabits()
        todayRecords = repository.getRecordsByDate(repository.getTodayDateString())
    }

    fun updateHabitRecord(habitId: Long, isCompleted: Boolean) {
        viewModelScope.launch {
            try {
                val today = repository.getTodayDateString()
                repository.insertOrUpdateRecord(habitId, today, isCompleted)
                _saveResult.value = true
            } catch (e: Exception) {
                _saveResult.value = false
            }
        }
    }
}
