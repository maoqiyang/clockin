package com.habittracker.app.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "habit_records")
data class HabitRecord(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val date: String, // Format: yyyy-MM-dd
    val habitId: Long,
    val isCompleted: Boolean,
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis()
)
