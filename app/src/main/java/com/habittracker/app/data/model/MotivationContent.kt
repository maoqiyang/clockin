package com.habittracker.app.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "motivation_content")
data class MotivationContent(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val imageUrl: String,
    val localImagePath: String? = null,
    val quote: String,
    val author: String? = null,
    val isFavorite: Boolean = false,
    val isFromNetwork: Boolean = true,
    val createdAt: Long = System.currentTimeMillis()
)
