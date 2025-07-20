package com.habittracker.app.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.habittracker.app.data.model.HabitRecord

@Dao
interface HabitRecordDao {
    
    @Query("SELECT * FROM habit_records WHERE date = :date ORDER BY habitId ASC")
    fun getRecordsByDate(date: String): LiveData<List<HabitRecord>>
    
    @Query("SELECT * FROM habit_records WHERE date = :date ORDER BY habitId ASC")
    suspend fun getRecordsByDateSync(date: String): List<HabitRecord>
    
    @Query("SELECT * FROM habit_records WHERE habitId = :habitId AND date = :date")
    suspend fun getRecord(habitId: Long, date: String): HabitRecord?
    
    @Query("SELECT * FROM habit_records WHERE date BETWEEN :startDate AND :endDate ORDER BY date ASC")
    suspend fun getRecordsBetweenDates(startDate: String, endDate: String): List<HabitRecord>
    
    @Query("SELECT DISTINCT date FROM habit_records WHERE date BETWEEN :startDate AND :endDate ORDER BY date ASC")
    suspend fun getRecordDates(startDate: String, endDate: String): List<String>
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecord(record: HabitRecord)
    
    @Update
    suspend fun updateRecord(record: HabitRecord)
    
    @Delete
    suspend fun deleteRecord(record: HabitRecord)
    
    @Query("DELETE FROM habit_records WHERE habitId = :habitId")
    suspend fun deleteRecordsByHabitId(habitId: Long)
    
    @Query("SELECT COUNT(*) FROM habit_records WHERE date = :date AND isCompleted = 1")
    suspend fun getCompletedCountByDate(date: String): Int
    
    @Query("SELECT COUNT(DISTINCT habitId) FROM habit_records WHERE date = :date")
    suspend fun getTotalHabitsCountByDate(date: String): Int
}
