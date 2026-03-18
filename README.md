# BluesApp

> 个人学习练手 App，使用了多个第三方数据源和开源框架。

## 项目简介

BluesApp 是一个 Android 个人学习应用，最初使用 Java-MVP 模式开发，后续在工作过程中逐渐迁移到 Kotlin-MVVM 模式，采用 ViewModel + Flow 的方式。

## 技术栈

### 核心框架
- **语言**: Kotlin / Java
- **Min SDK**: 21 (Android 5.0)
- **Target SDK**: 33 (Android 13)
- **Build Tools**: Gradle 7.5
- **Android Gradle Plugin**: 7.4.2

### 架构模式
- **MVVM**: ViewModel + Flow 数据流
- **DI**: Koin 依赖注入

### 主要依赖
| 类别 | 框架 |
|------|------|
| 网络 | OkHttp3 + Retrofit + Coroutines |
| 图片加载 | Coil |
| 视频播放 | NiceVideoPlayer |
| UI | EasyRecyclerView + SmartRefreshLayout |
| 数据库 | Room |
| 生命周期 | ViewModel + LiveData/Flow |

### 依赖管理
采用 Composing Build 方式管理依赖，通过自定义 Gradle 插件集中管理所有依赖版本。

## 项目结构

```
app/src/main/java/com/blues/
├── application/          # 应用入口，App 初始化
├── framework/           # 基础框架
│   ├── base/            # BaseViewModel, BaseKoinActivity/Fragment
│   ├── http/           # Retrofit, OkHttp 网络层
│   ├── utils/          # 工具类扩展
│   ├── widget/         # 自定义视图
│   ├── dialog/         # 对话框
│   └── network/        # 网络状态监听
├── di/                 # Koin 依赖注入模块
├── constant/           # 常量定义
├── article/            # 每日一文
├── gankio/             # 干货集中营 (v1/v2)
├── home/               # 首页模块
├── kaiyan/             # 开眼视频
├── login/              # 登录模块
├── register/           # 注册模块
├── wanandroid/         # 玩 Android
└── nicevideoplayer/    # 视频播放器实现
```

## 主要功能

- **开眼视频**: 热门视频播放、搜索、历史排行
- **每日一文**: 每日推荐优质文章
- **玩 Android**: 优质技术文章浏览
- **干货集中营**: 妹纸图、技术文章
- **用户系统**: 手机/账号登录注册

## API 数据源

| 平台 | 地址 | 状态 |
|------|------|------|
| 开眼 | http://baobab.kaiyanapp.com/ | 正常 |
| 玩 Android | https://www.wanandroid.com/ | 正常 |
| 干货集中营 | http://gank.io | 已不可用 |
| 有道云笔记 | - | 已不可用 |
| 每日一文 | https://meiriyiwen.com/ | 正常 |

## 构建命令

```bash
# 构建 Debug APK
./gradlew assembleDebug

# 构建 Release APK
./gradlew assembleRelease

# 清理构建
./gradlew clean

# 带详细日志构建
./gradlew assembleDebug --stacktrace
```

## 相关文档

- [CLAUDE.md](./CLAUDE.md) - Claude Code 开发指南
- [开发笔记](./VersionPlugin) - 版本插件记录

## 鸣谢

- [开眼视频](https://www.kaiyanapp.com/)
- [玩 Android](https://www.wanandroid.com/)
- [干货集中营](http://gank.io)
- [每日一文](https://meiriyiwen.com/)
