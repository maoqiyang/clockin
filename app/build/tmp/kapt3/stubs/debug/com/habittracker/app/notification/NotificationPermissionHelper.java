package com.habittracker.app.notification;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\u0006JG\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u000e\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\u0012\u00a2\u0006\u0002\u0010\u0014J\u0006\u0010\u0015\u001a\u00020\tJ\b\u0010\u0016\u001a\u00020\tH\u0002J\u0006\u0010\u0017\u001a\u00020\tJ\u0006\u0010\u0018\u001a\u00020\tJ\b\u0010\u0019\u001a\u00020\tH\u0002J\b\u0010\u001a\u001a\u00020\tH\u0002J\b\u0010\u001b\u001a\u00020\tH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/habittracker/app/notification/NotificationPermissionHelper;", "", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "hasExactAlarmPermission", "", "hasNotificationPermission", "onRequestPermissionsResult", "", "requestCode", "", "permissions", "", "", "grantResults", "", "onPermissionGranted", "Lkotlin/Function0;", "onPermissionDenied", "(I[Ljava/lang/String;[ILkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "openAppSettings", "openExactAlarmSettings", "requestExactAlarmPermission", "requestNotificationPermission", "showExactAlarmPermissionDialog", "showPermissionDeniedDialog", "showPermissionExplanationDialog", "Companion", "app_debug"})
public final class NotificationPermissionHelper {
    @org.jetbrains.annotations.NotNull
    private final android.app.Activity activity = null;
    public static final int REQUEST_CODE_NOTIFICATION_PERMISSION = 1001;
    public static final int REQUEST_CODE_EXACT_ALARM_PERMISSION = 1002;
    @org.jetbrains.annotations.NotNull
    public static final com.habittracker.app.notification.NotificationPermissionHelper.Companion Companion = null;
    
    public NotificationPermissionHelper(@org.jetbrains.annotations.NotNull
    android.app.Activity activity) {
        super();
    }
    
    /**
     * Check if notification permission is granted
     */
    public final boolean hasNotificationPermission() {
        return false;
    }
    
    /**
     * Request notification permission
     */
    public final void requestNotificationPermission() {
    }
    
    /**
     * Check if exact alarm permission is granted (Android 12+)
     */
    public final boolean hasExactAlarmPermission() {
        return false;
    }
    
    /**
     * Request exact alarm permission (Android 12+)
     */
    public final void requestExactAlarmPermission() {
    }
    
    /**
     * Show explanation dialog for notification permission
     */
    private final void showPermissionExplanationDialog() {
    }
    
    /**
     * Show dialog for exact alarm permission
     */
    private final void showExactAlarmPermissionDialog() {
    }
    
    /**
     * Open exact alarm settings page
     */
    private final void openExactAlarmSettings() {
    }
    
    /**
     * Open app settings page
     */
    public final void openAppSettings() {
    }
    
    /**
     * Handle permission request result
     */
    public final void onRequestPermissionsResult(int requestCode, @org.jetbrains.annotations.NotNull
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull
    int[] grantResults, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onPermissionGranted, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onPermissionDenied) {
    }
    
    /**
     * Show dialog when permission is denied
     */
    private final void showPermissionDeniedDialog() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/habittracker/app/notification/NotificationPermissionHelper$Companion;", "", "()V", "REQUEST_CODE_EXACT_ALARM_PERMISSION", "", "REQUEST_CODE_NOTIFICATION_PERMISSION", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}