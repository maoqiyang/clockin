package com.habittracker.app.data.repository

import androidx.lifecycle.LiveData
import com.habittracker.app.data.dao.*
import com.habittracker.app.data.model.*
import java.text.SimpleDateFormat
import java.util.*

class HabitRepository(
    private val habitDao: HabitDao,
    private val habitRecordDao: HabitRecordDao,
    private val motivationContentDao: MotivationContentDao,
    private val userSettingsDao: UserSettingsDao
) {
    
    // Habit operations
    fun getAllActiveHabits(): LiveData<List<Habit>> = habitDao.getAllActiveHabits()
    
    suspend fun getAllActiveHabitsSync(): List<Habit> = habitDao.getAllActiveHabitsSync()
    
    suspend fun insertHabit(habit: Habit): Long = habitDao.insertHabit(habit)
    
    suspend fun updateHabit(habit: Habit) = habitDao.updateHabit(habit)
    
    suspend fun deleteHabit(habit: Habit) = habitDao.deleteHabit(habit)
    
    suspend fun getActiveHabitsCount(): Int = habitDao.getActiveHabitsCount()
    
    // Habit Record operations
    fun getRecordsByDate(date: String): LiveData<List<HabitRecord>> = 
        habitRecordDao.getRecordsByDate(date)
    
    suspend fun getRecordsByDateSync(date: String): List<HabitRecord> = 
        habitRecordDao.getRecordsByDateSync(date)
    
    suspend fun getRecord(habitId: Long, date: String): HabitRecord? = 
        habitRecordDao.getRecord(habitId, date)
    
    suspend fun insertOrUpdateRecord(habitId: Long, date: String, isCompleted: Boolean) {
        val existingRecord = habitRecordDao.getRecord(habitId, date)
        if (existingRecord != null) {
            habitRecordDao.updateRecord(
                existingRecord.copy(
                    isCompleted = isCompleted,
                    updatedAt = System.currentTimeMillis()
                )
            )
        } else {
            habitRecordDao.insertRecord(
                HabitRecord(
                    habitId = habitId,
                    date = date,
                    isCompleted = isCompleted
                )
            )
        }
    }
    
    suspend fun getRecordsBetweenDates(startDate: String, endDate: String): List<HabitRecord> = 
        habitRecordDao.getRecordsBetweenDates(startDate, endDate)
    
    suspend fun getCompletionStats(date: String): Pair<Int, Int> {
        val completed = habitRecordDao.getCompletedCountByDate(date)
        val total = habitDao.getActiveHabitsCount()
        return Pair(completed, total)
    }
    
    // Motivation Content operations
    fun getAllMotivationContent(): LiveData<List<MotivationContent>> = 
        motivationContentDao.getAllContent()
    
    fun getFavoriteMotivationContent(): LiveData<List<MotivationContent>> = 
        motivationContentDao.getFavoriteContent()
    
    suspend fun getRandomMotivationContent(): MotivationContent? = 
        motivationContentDao.getRandomContent()
    
    suspend fun insertMotivationContent(content: MotivationContent): Long = 
        motivationContentDao.insertContent(content)
    
    suspend fun updateFavoriteStatus(id: Long, isFavorite: Boolean) = 
        motivationContentDao.updateFavoriteStatus(id, isFavorite)
    
    // User Settings operations
    fun getUserSettings(): LiveData<UserSettings?> = userSettingsDao.getSettings()
    
    suspend fun getUserSettingsSync(): UserSettings? = userSettingsDao.getSettingsSync()
    
    suspend fun updateReminderTime(time: String) = userSettingsDao.updateReminderTime(time)
    
    suspend fun updateReminderEnabled(enabled: Boolean) = 
        userSettingsDao.updateReminderEnabled(enabled)
    
    // Utility functions
    fun getTodayDateString(): String {
        val formatter = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        return formatter.format(Date())
    }
    
    fun formatDate(date: Date): String {
        val formatter = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        return formatter.format(date)
    }
}
