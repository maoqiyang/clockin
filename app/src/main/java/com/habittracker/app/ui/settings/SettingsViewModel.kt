package com.habittracker.app.ui.settings

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.habittracker.app.data.database.HabitDatabase
import com.habittracker.app.data.model.Habit
import com.habittracker.app.data.model.UserSettings
import com.habittracker.app.data.repository.HabitRepository
import kotlinx.coroutines.launch

class SettingsViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: HabitRepository
    
    val habits: LiveData<List<Habit>>
    val userSettings: LiveData<UserSettings?>
    
    private val _operationResult = MutableLiveData<OperationResult>()
    val operationResult: LiveData<OperationResult> = _operationResult

    init {
        val database = HabitDatabase.getDatabase(application)
        repository = HabitRepository(
            database.habitDao(),
            database.habitRecordDao(),
            database.motivationContentDao(),
            database.userSettingsDao()
        )
        
        habits = repository.getAllActiveHabits()
        userSettings = repository.getUserSettings()
    }

    fun addHabit(name: String, description: String) {
        viewModelScope.launch {
            try {
                val currentCount = repository.getActiveHabitsCount()
                if (currentCount >= 8) {
                    _operationResult.value = OperationResult.MAX_HABITS_REACHED
                    return@launch
                }
                
                val habit = Habit(
                    name = name,
                    description = description,
                    sortOrder = currentCount
                )
                repository.insertHabit(habit)
                _operationResult.value = OperationResult.SUCCESS
            } catch (e: Exception) {
                _operationResult.value = OperationResult.ERROR
            }
        }
    }

    fun updateHabit(habit: Habit) {
        viewModelScope.launch {
            try {
                repository.updateHabit(habit.copy(updatedAt = System.currentTimeMillis()))
                _operationResult.value = OperationResult.SUCCESS
            } catch (e: Exception) {
                _operationResult.value = OperationResult.ERROR
            }
        }
    }

    fun deleteHabit(habit: Habit) {
        viewModelScope.launch {
            try {
                repository.deleteHabit(habit)
                _operationResult.value = OperationResult.SUCCESS
            } catch (e: Exception) {
                _operationResult.value = OperationResult.ERROR
            }
        }
    }

    fun updateHabitOrder(habits: List<Habit>) {
        viewModelScope.launch {
            try {
                habits.forEachIndexed { index, habit ->
                    if (habit.sortOrder != index) {
                        repository.updateHabit(habit.copy(sortOrder = index))
                    }
                }
            } catch (e: Exception) {
                // Handle error silently for drag and drop
            }
        }
    }

    fun updateReminderTime(time: String) {
        viewModelScope.launch {
            try {
                repository.updateReminderTime(time)
                _operationResult.value = OperationResult.SUCCESS
            } catch (e: Exception) {
                _operationResult.value = OperationResult.ERROR
            }
        }
    }

    fun updateReminderEnabled(enabled: Boolean) {
        viewModelScope.launch {
            try {
                repository.updateReminderEnabled(enabled)
            } catch (e: Exception) {
                // Handle error silently for switch
            }
        }
    }

    enum class OperationResult {
        SUCCESS,
        ERROR,
        MAX_HABITS_REACHED
    }
}
