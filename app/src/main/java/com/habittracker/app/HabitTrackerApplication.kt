package com.habittracker.app

import android.app.Application
import com.habittracker.app.data.database.HabitDatabase

class HabitTrackerApplication : Application() {
    
    val database by lazy { HabitDatabase.getDatabase(this) }
    
    override fun onCreate() {
        super.onCreate()
    }
}
