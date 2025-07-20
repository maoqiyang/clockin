package com.habittracker.app.notification

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.provider.Settings
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.habittracker.app.R

class NotificationPermissionHelper(private val activity: Activity) {
    
    companion object {
        const val REQUEST_CODE_NOTIFICATION_PERMISSION = 1001
        const val REQUEST_CODE_EXACT_ALARM_PERMISSION = 1002
    }
    
    /**
     * Check if notification permission is granted
     */
    fun hasNotificationPermission(): Boolean {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            ContextCompat.checkSelfPermission(
                activity,
                Manifest.permission.POST_NOTIFICATIONS
            ) == PackageManager.PERMISSION_GRANTED
        } else {
            // For Android 12 and below, notifications are enabled by default
            true
        }
    }
    
    /**
     * Request notification permission
     */
    fun requestNotificationPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (!hasNotificationPermission()) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(
                        activity,
                        Manifest.permission.POST_NOTIFICATIONS
                    )) {
                    // Show explanation dialog
                    showPermissionExplanationDialog()
                } else {
                    // Request permission directly
                    ActivityCompat.requestPermissions(
                        activity,
                        arrayOf(Manifest.permission.POST_NOTIFICATIONS),
                        REQUEST_CODE_NOTIFICATION_PERMISSION
                    )
                }
            }
        }
    }
    
    /**
     * Check if exact alarm permission is granted (Android 12+)
     */
    fun hasExactAlarmPermission(): Boolean {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            val notificationManager = NotificationManager(activity)
            notificationManager.canScheduleExactAlarms()
        } else {
            true
        }
    }
    
    /**
     * Request exact alarm permission (Android 12+)
     */
    fun requestExactAlarmPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            if (!hasExactAlarmPermission()) {
                showExactAlarmPermissionDialog()
            }
        }
    }
    
    /**
     * Show explanation dialog for notification permission
     */
    private fun showPermissionExplanationDialog() {
        AlertDialog.Builder(activity)
            .setTitle("需要通知权限")
            .setMessage("为了向您发送习惯提醒，应用需要通知权限。请在下一个对话框中点击,允许。")
            .setPositiveButton("确定") { _, _ ->
                ActivityCompat.requestPermissions(
                    activity,
                    arrayOf(Manifest.permission.POST_NOTIFICATIONS),
                    REQUEST_CODE_NOTIFICATION_PERMISSION
                )
            }
            .setNegativeButton("取消", null)
            .show()
    }
    
    /**
     * Show dialog for exact alarm permission
     */
    private fun showExactAlarmPermissionDialog() {
        AlertDialog.Builder(activity)
            .setTitle("需要精确闹钟权限")
            .setMessage("为了准时发送提醒，应用需要精确闹钟权限。点击设置前往系统设置页面开启权限。")
            .setPositiveButton("设置") { _, _ ->
                openExactAlarmSettings()
            }
            .setNegativeButton("取消", null)
            .show()
    }
    
    /**
     * Open exact alarm settings page
     */
    private fun openExactAlarmSettings() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            try {
                val intent = Intent(Settings.ACTION_REQUEST_SCHEDULE_EXACT_ALARM).apply {
                    data = Uri.parse("package:${activity.packageName}")
                }
                activity.startActivityForResult(intent, REQUEST_CODE_EXACT_ALARM_PERMISSION)
            } catch (e: Exception) {
                // Fallback to general app settings
                openAppSettings()
            }
        }
    }
    
    /**
     * Open app settings page
     */
    fun openAppSettings() {
        val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
            data = Uri.parse("package:${activity.packageName}")
        }
        activity.startActivity(intent)
    }
    
    /**
     * Handle permission request result
     */
    fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray,
        onPermissionGranted: () -> Unit,
        onPermissionDenied: () -> Unit
    ) {
        when (requestCode) {
            REQUEST_CODE_NOTIFICATION_PERMISSION -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    onPermissionGranted()
                } else {
                    onPermissionDenied()
                    showPermissionDeniedDialog()
                }
            }
        }
    }
    
    /**
     * Show dialog when permission is denied
     */
    private fun showPermissionDeniedDialog() {
        AlertDialog.Builder(activity)
            .setTitle("权限被拒绝")
            .setMessage("没有通知权限，无法发送习惯提醒。您可以在应用设置中手动开启通知权限。")
            .setPositiveButton("前往设置") { _, _ ->
                openAppSettings()
            }
            .setNegativeButton("取消", null)
            .show()
    }
}
