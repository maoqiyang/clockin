# 习惯打卡 - Android应用

一个功能完整的Android习惯追踪应用，帮助用户建立和维持良好的日常习惯。

## 📱 应用特性

### 核心功能
- **今日打卡**: 简洁的打卡界面，支持多个习惯项目的勾选
- **日历记录**: 月历视图显示打卡历史，不同颜色标识完成度
- **自定义设置**: 灵活的习惯管理，支持添加、编辑、删除和排序
- **激励页面**: 每日随机显示激励图片和正能量语录

### 技术特性
- **现代架构**: 使用MVVM架构模式，LiveData和ViewModel
- **本地存储**: SQLite数据库配合Room框架
- **网络功能**: 集成图片API，支持离线缓存
- **Material Design**: 遵循Material Design设计规范
- **侧边栏导航**: Navigation Drawer实现页面切换

## 🛠️ 技术栈

- **开发语言**: Kotlin
- **最低支持**: Android 5.0 (API 21)
- **目标版本**: Android 14 (API 34)
- **架构模式**: MVVM
- **数据库**: Room (SQLite)
- **网络请求**: Retrofit + OkHttp
- **图片加载**: Glide
- **UI框架**: Material Design Components

## 📦 项目结构

```
app/
├── src/main/java/com/habittracker/app/
│   ├── data/                    # 数据层
│   │   ├── dao/                # 数据访问对象
│   │   ├── database/           # 数据库配置
│   │   ├── model/              # 数据模型
│   │   └── repository/         # 数据仓库
│   ├── network/                # 网络层
│   ├── ui/                     # UI层
│   │   ├── calendar/           # 日历页面
│   │   ├── home/               # 主页面
│   │   ├── motivation/         # 激励页面
│   │   └── settings/           # 设置页面
│   ├── MainActivity.kt         # 主Activity
│   └── SplashActivity.kt       # 启动页面
└── src/main/res/               # 资源文件
    ├── drawable/               # 图标资源
    ├── layout/                 # 布局文件
    ├── menu/                   # 菜单资源
    ├── values/                 # 值资源
    └── mipmap/                 # 应用图标
```

## 🚀 快速开始

### 环境要求
- Android Studio Arctic Fox (2020.3.1) 或更高版本
- JDK 8 或更高版本
- Android SDK API 21-34

### 安装步骤

1. **克隆项目**
   ```bash
   git clone <repository-url>
   cd HabitTracker
   ```

2. **打开项目**
   - 启动Android Studio
   - 选择 "Open an existing Android Studio project"
   - 选择项目根目录

3. **同步项目**
   - Android Studio会自动提示同步Gradle
   - 点击 "Sync Now" 等待同步完成

4. **运行应用**
   - 连接Android设备或启动模拟器
   - 点击 "Run" 按钮或按 Shift+F10

### 生成APK

1. **Debug版本**
   ```bash
   ./gradlew assembleDebug
   ```
   生成的APK位置: `app/build/outputs/apk/debug/app-debug.apk`

2. **Release版本**
   ```bash
   ./gradlew assembleRelease
   ```
   生成的APK位置: `app/build/outputs/apk/release/app-release.apk`

## 📖 使用说明

### 主要页面介绍

#### 1. 今日打卡页面
- 显示当前日期
- 列出所有活跃的习惯项目
- 点击复选框完成打卡
- 实时保存到本地数据库

#### 2. 日历记录页面
- 月历视图显示打卡历史
- 颜色标识：绿色(全部完成)、黄色(部分完成)、灰色(未完成)
- 点击日期查看详细记录
- 显示月度统计数据

#### 3. 自定义设置页面
- 管理习惯项目：添加、编辑、删除
- 拖拽调整习惯顺序
- 设置每日提醒时间
- 最多支持8个习惯项目

#### 4. 激励页面
- 每日随机显示激励图片
- 配备正能量语录
- 支持收藏功能
- 离线缓存支持

### 数据管理

#### 本地存储
- 所有数据存储在本地SQLite数据库
- 支持数据导出和备份
- 自动清理过期缓存数据

#### 网络功能
- 自动获取激励图片
- 支持离线模式
- 智能缓存管理

## 🔧 开发指南

### 添加新功能

1. **创建数据模型**
   ```kotlin
   @Entity(tableName = "your_table")
   data class YourModel(
       @PrimaryKey(autoGenerate = true)
       val id: Long = 0,
       // 其他字段
   )
   ```

2. **创建DAO接口**
   ```kotlin
   @Dao
   interface YourDao {
       @Query("SELECT * FROM your_table")
       fun getAll(): LiveData<List<YourModel>>
       
       @Insert
       suspend fun insert(model: YourModel)
   }
   ```

3. **更新数据库**
   - 在HabitDatabase中添加新的Entity和DAO
   - 增加数据库版本号
   - 添加Migration策略

### 自定义主题

修改 `res/values/colors.xml` 和 `res/values/themes.xml` 文件来自定义应用主题。

### 添加新的激励内容

在 `MotivationViewModel` 中的 `defaultQuotes` 列表添加新的语录。

## 🧪 测试

### 运行单元测试
```bash
./gradlew test
```

### 运行UI测试
```bash
./gradlew connectedAndroidTest
```

### 测试覆盖率
```bash
./gradlew jacocoTestReport
```

## 📝 版本历史

### v1.0.0 (当前版本)
- ✅ 基础打卡功能
- ✅ 日历记录显示
- ✅ 习惯自定义管理
- ✅ 激励内容展示
- ✅ 本地数据存储
- ✅ Material Design UI

### 计划功能
- 📊 数据统计图表
- 🔔 智能提醒系统
- 📤 数据导出功能
- 🌙 夜间模式支持
- 🔄 云端同步功能

## 🤝 贡献指南

1. Fork 项目
2. 创建功能分支 (`git checkout -b feature/AmazingFeature`)
3. 提交更改 (`git commit -m 'Add some AmazingFeature'`)
4. 推送到分支 (`git push origin feature/AmazingFeature`)
5. 打开 Pull Request

## 📄 许可证

本项目采用 MIT 许可证 - 查看 [LICENSE](LICENSE) 文件了解详情。

## 📞 联系方式

如有问题或建议，请通过以下方式联系：

- 项目Issues: [GitHub Issues](https://github.com/your-repo/issues)
- 邮箱: your-email@example.com

## 🙏 致谢

- [Material Design](https://material.io/) - UI设计规范
- [Room](https://developer.android.com/training/data-storage/room) - 数据库框架
- [Glide](https://github.com/bumptech/glide) - 图片加载库
- [Retrofit](https://square.github.io/retrofit/) - 网络请求库

---

**享受养成好习惯的过程！** 🌟
