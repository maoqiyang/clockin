package com.habittracker.app.notification

import android.content.Context
import android.util.Log
import com.habittracker.app.data.database.HabitDatabase
import com.habittracker.app.data.repository.HabitRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Helper class for testing notification functionality
 */
class NotificationTestHelper(private val context: Context) {
    
    companion object {
        private const val TAG = "NotificationTestHelper"
    }
    
    private val notificationManager = NotificationManager(context)
    
    /**
     * Test immediate notification
     */
    fun testImmediateNotification() {
        Log.d(TAG, "Testing immediate notification")
        notificationManager.showReminderNotification()
    }
    
    /**
     * Test notification scheduling (1 minute from now)
     */
    fun testNotificationScheduling() {
        Log.d(TAG, "Testing notification scheduling")
        val currentTime = System.currentTimeMillis()
        val calendar = java.util.Calendar.getInstance()
        calendar.timeInMillis = currentTime + 60000 // 1 minute from now
        
        val hour = calendar.get(java.util.Calendar.HOUR_OF_DAY)
        val minute = calendar.get(java.util.Calendar.MINUTE)
        
        notificationManager.scheduleReminder(hour, minute)
        Log.d(TAG, "Notification scheduled for $hour:$minute")
    }
    
    /**
     * Test notification permissions
     */
    fun testNotificationPermissions(): String {
        val hasNotifications = notificationManager.areNotificationsEnabled()
        val hasExactAlarms = notificationManager.canScheduleExactAlarms()
        
        val result = """
            Notification Permissions Test:
            - Notifications enabled: $hasNotifications
            - Exact alarms enabled: $hasExactAlarms
        """.trimIndent()
        
        Log.d(TAG, result)
        return result
    }
    
    /**
     * Test database settings integration
     */
    fun testDatabaseIntegration() {
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
                Log.d(TAG, "Database settings: $settings")
                
                if (settings != null) {
                    Log.d(TAG, "Reminder enabled: ${settings.isReminderEnabled}")
                    Log.d(TAG, "Reminder time: ${settings.reminderTime}")
                    
                    if (settings.isReminderEnabled) {
                        val timeParts = settings.reminderTime.split(":")
                        if (timeParts.size == 2) {
                            val hour = timeParts[0].toIntOrNull() ?: 20
                            val minute = timeParts[1].toIntOrNull() ?: 0
                            Log.d(TAG, "Would schedule notification for $hour:$minute")
                        }
                    }
                } else {
                    Log.w(TAG, "No settings found in database")
                }
            } catch (e: Exception) {
                Log.e(TAG, "Error testing database integration", e)
            }
        }
    }
    
    /**
     * Cancel all notifications
     */
    fun cancelNotifications() {
        Log.d(TAG, "Cancelling all notifications")
        notificationManager.cancelReminder()
    }
}
