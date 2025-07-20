@echo off
echo ========================================
echo 习惯打卡应用 - APK构建脚本
echo ========================================
echo.

echo 正在清理项目...
call gradlew clean

echo.
echo 正在构建Debug APK...
call gradlew assembleDebug

if %ERRORLEVEL% EQU 0 (
    echo.
    echo ========================================
    echo 构建成功！
    echo ========================================
    echo Debug APK位置: app\build\outputs\apk\debug\app-debug.apk
    echo.
    echo 您可以将此APK文件安装到Android设备上进行测试。
    echo.
) else (
    echo.
    echo ========================================
    echo 构建失败！
    echo ========================================
    echo 请检查错误信息并修复后重试。
    echo.
)

pause
