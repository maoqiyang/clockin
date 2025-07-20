package com.habittracker.app.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.habittracker.app.data.model.Habit

@Dao
interface HabitDao {
    
    @Query("SELECT * FROM habits WHERE isActive = 1 ORDER BY sortOrder ASC")
    fun getAllActiveHabits(): LiveData<List<Habit>>
    
    @Query("SELECT * FROM habits WHERE isActive = 1 ORDER BY sortOrder ASC")
    suspend fun getAllActiveHabitsSync(): List<Habit>
    
    @Query("SELECT * FROM habits WHERE id = :id")
    suspend fun getHabitById(id: Long): Habit?
    
    @Insert
    suspend fun insertHabit(habit: Habit): Long
    
    @Update
    suspend fun updateHabit(habit: Habit)
    
    @Delete
    suspend fun deleteHabit(habit: Habit)
    
    @Query("UPDATE habits SET isActive = 0 WHERE id = :id")
    suspend fun deactivateHabit(id: Long)
    
    @Query("SELECT COUNT(*) FROM habits WHERE isActive = 1")
    suspend fun getActiveHabitsCount(): Int
    
    @Query("UPDATE habits SET sortOrder = :newOrder WHERE id = :id")
    suspend fun updateHabitOrder(id: Long, newOrder: Int)
}
