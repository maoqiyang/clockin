package com.habittracker.app.notification;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\f\u001a\u00020\rJ\b\u0010\u000e\u001a\u00020\rH\u0002J\u0016\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0013\u001a\u00020\rR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/habittracker/app/notification/NotificationManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "alarmManager", "Landroid/app/AlarmManager;", "notificationManager", "Landroidx/core/app/NotificationManagerCompat;", "areNotificationsEnabled", "", "canScheduleExactAlarms", "cancelReminder", "", "createNotificationChannel", "scheduleReminder", "hour", "", "minute", "showReminderNotification", "Companion", "app_debug"})
public final class NotificationManager {
    @org.jetbrains.annotations.NotNull
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String CHANNEL_ID = "habit_reminder_channel";
    public static final int NOTIFICATION_ID = 1001;
    public static final int REQUEST_CODE_REMINDER = 1002;
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String CHANNEL_NAME = "\u4e60\u60ef\u63d0\u9192";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String CHANNEL_DESCRIPTION = "\u6bcf\u65e5\u4e60\u60ef\u6253\u5361\u63d0\u9192\u901a\u77e5";
    @org.jetbrains.annotations.NotNull
    private final androidx.core.app.NotificationManagerCompat notificationManager = null;
    @org.jetbrains.annotations.NotNull
    private final android.app.AlarmManager alarmManager = null;
    @org.jetbrains.annotations.NotNull
    public static final com.habittracker.app.notification.NotificationManager.Companion Companion = null;
    
    public NotificationManager(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    /**
     * Create notification channel for Android O and above
     */
    private final void createNotificationChannel() {
    }
    
    /**
     * Schedule daily reminder notification
     */
    public final void scheduleReminder(int hour, int minute) {
    }
    
    /**
     * Cancel scheduled reminder
     */
    public final void cancelReminder() {
    }
    
    /**
     * Show habit reminder notification
     */
    public final void showReminderNotification() {
    }
    
    /**
     * Check if notifications are enabled
     */
    public final boolean areNotificationsEnabled() {
        return false;
    }
    
    /**
     * Check if exact alarm permission is granted (Android 12+)
     */
    public final boolean canScheduleExactAlarms() {
        return false;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/habittracker/app/notification/NotificationManager$Companion;", "", "()V", "CHANNEL_DESCRIPTION", "", "CHANNEL_ID", "CHANNEL_NAME", "NOTIFICATION_ID", "", "REQUEST_CODE_REMINDER", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}