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

class BootReceiver : BroadcastReceiver() {
    
    companion object {
        private const val TAG = "BootReceiver"
    }
    
    override fun onReceive(context: Context, intent: Intent) {
        Log.d(TAG, "Received broadcast: ${intent.action}")
        
        when (intent.action) {
            Intent.ACTION_BOOT_COMPLETED,
            Intent.ACTION_MY_PACKAGE_REPLACED,
            Intent.ACTION_PACKAGE_REPLACED -> {
                rescheduleNotifications(context)
            }
        }
    }
    
    private fun rescheduleNotifications(context: Context) {
        Log.d(TAG, "Rescheduling notifications after boot/update")
        
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
                    val timeParts = settings.reminderTime.split(":")
                    if (timeParts.size == 2) {
                        val hour = timeParts[0].toIntOrNull() ?: 20
                        val minute = timeParts[1].toIntOrNull() ?: 0
                        
                        val notificationManager = NotificationManager(context)
                        notificationManager.scheduleReminder(hour, minute)
                        
                        Log.d(TAG, "Notifications rescheduled for ${settings.reminderTime}")
                    }
                } else {
                    Log.d(TAG, "Reminders are disabled, not rescheduling")
                }
            } catch (e: Exception) {
                Log.e(TAG, "Error rescheduling notifications", e)
            }
        }
    }
}
