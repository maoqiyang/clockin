package com.habittracker.app.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_settings")
data class UserSettings(
    @PrimaryKey
    val id: Long = 1, // Single row for settings
    val reminderTime: String = "20:00", // Format: HH:mm
    val isReminderEnabled: Boolean = true,
    val lastSyncTime: Long = 0,
    val updatedAt: Long = System.currentTimeMillis()
)
