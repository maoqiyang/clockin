package com.habittracker.app.notification;

/**
 * Helper class for testing notification functionality
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\n\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/habittracker/app/notification/NotificationTestHelper;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "notificationManager", "Lcom/habittracker/app/notification/NotificationManager;", "cancelNotifications", "", "testDatabaseIntegration", "testImmediateNotification", "testNotificationPermissions", "", "testNotificationScheduling", "Companion", "app_debug"})
public final class NotificationTestHelper {
    @org.jetbrains.annotations.NotNull
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String TAG = "NotificationTestHelper";
    @org.jetbrains.annotations.NotNull
    private final com.habittracker.app.notification.NotificationManager notificationManager = null;
    @org.jetbrains.annotations.NotNull
    public static final com.habittracker.app.notification.NotificationTestHelper.Companion Companion = null;
    
    public NotificationTestHelper(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    /**
     * Test immediate notification
     */
    public final void testImmediateNotification() {
    }
    
    /**
     * Test notification scheduling (1 minute from now)
     */
    public final void testNotificationScheduling() {
    }
    
    /**
     * Test notification permissions
     */
    @org.jetbrains.annotations.NotNull
    public final java.lang.String testNotificationPermissions() {
        return null;
    }
    
    /**
     * Test database settings integration
     */
    public final void testDatabaseIntegration() {
    }
    
    /**
     * Cancel all notifications
     */
    public final void cancelNotifications() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/habittracker/app/notification/NotificationTestHelper$Companion;", "", "()V", "TAG", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}