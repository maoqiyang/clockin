# 快速开始指南

## 🚀 5分钟快速运行

### 前提条件
- 已安装 Android Studio (推荐最新版本)
- 已配置 Android SDK
- 有可用的Android设备或模拟器

### 步骤1: 打开项目
1. 启动 Android Studio
2. 选择 "Open an existing Android Studio project"
3. 选择项目根目录 (包含 `build.gradle` 的文件夹)

### 步骤2: 同步项目
1. Android Studio 会自动提示同步 Gradle
2. 点击 "Sync Now" 按钮
3. 等待同步完成 (首次可能需要几分钟下载依赖)

### 步骤3: 运行应用
1. 连接 Android 设备或启动模拟器
2. 点击工具栏的绿色 "Run" 按钮 (▶️)
3. 选择目标设备
4. 等待应用安装和启动

## 📱 应用功能预览

### 启动后你将看到:
1. **启动页面** - 显示应用图标和名称
2. **主打卡页面** - 默认的4个习惯项目
3. **侧边栏菜单** - 点击左上角菜单图标或滑动打开

### 快速体验:
1. **打卡**: 在主页面勾选习惯项目
2. **查看记录**: 点击侧边栏的"日历记录"
3. **自定义习惯**: 点击侧边栏的"自定义设置"
4. **获取激励**: 点击侧边栏的"激励页面"

## 🔧 生成APK文件

### 方法1: 使用脚本 (Windows)
双击运行 `build-apk.bat` 文件

### 方法2: 使用命令行
```bash
# 生成Debug版本
./gradlew assembleDebug

# 生成Release版本
./gradlew assembleRelease
```

### 方法3: 使用Android Studio
1. 菜单栏选择 Build → Build Bundle(s) / APK(s) → Build APK(s)
2. 等待构建完成
3. 点击通知中的 "locate" 链接找到APK文件

## 📍 APK文件位置
- Debug版本: `app/build/outputs/apk/debug/app-debug.apk`
- Release版本: `app/build/outputs/apk/release/app-release.apk`

## 🐛 常见问题

### 问题1: Gradle同步失败
**解决方案:**
- 检查网络连接
- 在Android Studio中选择 File → Invalidate Caches and Restart
- 确保使用的是推荐的Gradle版本

### 问题2: 编译错误
**解决方案:**
- 确保Android SDK已正确安装
- 检查 `local.properties` 文件中的SDK路径
- 清理项目: Build → Clean Project

### 问题3: 应用无法安装
**解决方案:**
- 确保设备已开启"未知来源"安装权限
- 检查设备存储空间是否充足
- 尝试卸载旧版本后重新安装

### 问题4: 数据库相关错误
**解决方案:**
- 清除应用数据后重新启动
- 检查Room数据库配置
- 查看Logcat中的详细错误信息

## 📞 获取帮助

如果遇到问题:
1. 查看完整的 [README.md](README.md) 文档
2. 检查 Android Studio 的 Logcat 输出
3. 确保所有依赖都已正确下载

## 🎉 成功运行后

恭喜！你已经成功运行了习惯打卡应用。现在你可以:
- 开始使用应用追踪你的习惯
- 查看源代码了解实现细节
- 根据需要修改和扩展功能
- 分享APK文件给朋友使用

享受养成好习惯的过程！ 🌟
