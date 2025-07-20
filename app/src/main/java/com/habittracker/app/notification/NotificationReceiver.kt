package com.habittracker.app.notification

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.habittracker.app.data.database.HabitDatabase
import com.habittracker.app.data.repository.HabitRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotificationReceiver : BroadcastReceiver() {
    
    companion object {
        private const val TAG = "NotificationReceiver"
    }
    
    override fun onReceive(context: Context, intent: Intent) {
        Log.d(TAG, "Received broadcast: ${intent.action}")
        
        when (intent.action) {
            "com.habittracker.app.HABIT_REMINDER" -> {
                handleHabitReminder(context)
            }
        }
    }
    
    private fun handleHabitReminder(context: Context) {
        Log.d(TAG, "Handling habit reminder")
        
        // Check if reminders are enabled before showing notification
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val database = HabitDatabase.getDatabase(context)
                val repository = HabitRepository(
                    database.habitDao(),
                    database.habitRecordDao(),
                    database.motivationContentDao(),
                    database.userSettingsDao()
                )
                
                val settings = repository.getUserSettingsSync()
                
                if (settings?.isReminderEnabled == true) {
                    // Show the notification
                    val notificationManager = NotificationManager(context)
                    notificationManager.showReminderNotification()
                    
                    // Reschedule for next day
                    val timeParts = settings.reminderTime.split(":")
                    if (timeParts.size == 2) {
                        val hour = timeParts[0].toIntOrNull() ?: 20
                        val minute = timeParts[1].toIntOrNull() ?: 0
                        notificationManager.scheduleReminder(hour, minute)
                    }
                    
                    Log.d(TAG, "Notification shown and rescheduled")
                } else {
                    Log.d(TAG, "Reminders are disabled, skipping notification")
                }
            } catch (e: Exception) {
                Log.e(TAG, "Error handling habit reminder", e)
            }
        }
    }
}
