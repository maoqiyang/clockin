package com.habittracker.app.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.habittracker.app.data.model.UserSettings

@Dao
interface UserSettingsDao {
    
    @Query("SELECT * FROM user_settings WHERE id = 1")
    fun getSettings(): LiveData<UserSettings?>
    
    @Query("SELECT * FROM user_settings WHERE id = 1")
    suspend fun getSettingsSync(): UserSettings?
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSettings(settings: UserSettings)
    
    @Update
    suspend fun updateSettings(settings: UserSettings)
    
    @Query("UPDATE user_settings SET reminderTime = :time WHERE id = 1")
    suspend fun updateReminderTime(time: String)
    
    @Query("UPDATE user_settings SET isReminderEnabled = :enabled WHERE id = 1")
    suspend fun updateReminderEnabled(enabled: Boolean)
}
