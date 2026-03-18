# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

An Android personal learning app written in Kotlin, originally developed in MVP pattern and migrated to MVVM with ViewModel + Flow. Uses Composing Build for dependency management via a custom Gradle plugin.

## Build Commands

```bash
# Build debug APK
./gradlew assembleDebug

# Build release APK
./gradlew assembleRelease

# Clean build
./gradlew clean

# Build with specific variant
./gradlew assembleDebug --stacktrace
```

The project uses Gradle 7.5 with AGP 7.4.2. Note that test tasks are disabled in build.gradle to speed up compilation.

## Architecture

### MVVM Pattern
- **View**: Activities/Fragments extending `BaseKoinActivity` or `BaseKoinFragment`
- **ViewModel**: Extending `BaseViewModel` with Flow-based data handling
- **Repository**: Data layer handling API calls

### Dependency Injection
Koin is used for DI. Modules are defined in `com.blues.di.inject.kt`:
- `wanAndroidVmModule` - WanAndroid banner and articles
- `kaiyanModule` - OpenEye video features
- `gankioModule` - Gank.io data
- `loginModule` / `registerModule` - Authentication
- `meiriyiwenModule` - Daily article

### Key Framework Classes
- `com.blues.framework.base.BaseKoinActivity` - Base activity with Koin integration
- `com.blues.framework.base.BaseKoinFragment` - Base fragment with Koin integration
- `com.blues.framework.base.BaseViewModel` - Base VM with Flow-based request handling
- `com.blues.framework.http.RetrofitClient` - Network client setup
- `com.blues.framework.http.OkHttpClientManager` - OkHttp singleton

### Dependency Management
Custom Gradle plugin in `VersionPlugin/` manages all dependencies. Edit `VersionPlugin/src/main/java/com/blues/plugin/Depts.kt` to add/update dependencies.

## Project Structure

```
app/src/main/java/com/blues/
├── application/       # BluesApplication, app initialization
├── framework/         # Base classes, HTTP, widgets, utilities
│   ├── base/          # BaseViewModel, BaseKoinActivity/Fragment
│   ├── http/          # Retrofit, OkHttp, Response handlers
│   ├── utils/         # Extensions, utilities
│   ├── widget/        # Custom views (BannerView, CountDownView, etc.)
│   ├── dialog/        # LoadingDialog, WebViewDialog
│   └── network/       # Network callbacks
├── di/                # Koin modules
├── constant/         # App constants, API URLs
├── article/           # Daily article feature
├── gankio/            # Gank.io API (v1, v2)
├── home/              # Main page with banners
├── kaiyan/            # OpenEye video player
├── login/             # Login feature
├── register/          # Registration feature
├── wanandroid/        # WanAndroid articles
└── nicevideoplayer/   # Video player implementation
```

## Key Conventions

- API interfaces follow pattern: `XxxApi.kt` in `api/` package
- Repositories named `XxxRepository.kt` in `service/` package
- ViewModels named `XxxViewModel.kt` in `vm/` package
- Models use `.kt` files, often with `Bean`, `Entity`, or `Response` suffixes
- Layouts match activity/fragment names (e.g., `MainActivity` -> `activity_main.xml`)

## API Endpoints

- WanAndroid: `https://www.wanandroid.com/`
- Gank.io: `http://gank.io`
- OpenEye: `http://baobab.kaiyanapp.com/`

## Known Issues

Some external APIs (干货, 有道云笔记) are no longer accessible as noted in README.md.
