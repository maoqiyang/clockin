package com.habittracker.app.notification;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/habittracker/app/notification/NotificationReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "handleHabitReminder", "", "context", "Landroid/content/Context;", "onReceive", "intent", "Landroid/content/Intent;", "Companion", "app_debug"})
public final class NotificationReceiver extends android.content.BroadcastReceiver {
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String TAG = "NotificationReceiver";
    @org.jetbrains.annotations.NotNull
    public static final com.habittracker.app.notification.NotificationReceiver.Companion Companion = null;
    
    public NotificationReceiver() {
        super();
    }
    
    @java.lang.Override
    public void onReceive(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    android.content.Intent intent) {
    }
    
    private final void handleHabitReminder(android.content.Context context) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/habittracker/app/notification/NotificationReceiver$Companion;", "", "()V", "TAG", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}