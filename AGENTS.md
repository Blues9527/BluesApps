# Repository Guidelines

## Project Structure & Module Organization
`app/` is the Android application module. Main code lives under `app/src/main/java/com/blues/`, grouped by feature and layer: `home/`, `kaiyan/`, `wanandroid/`, `login/`, plus shared infrastructure in `framework/`, DI wiring in `di/`, and app startup in `application/`. Resources are in `app/src/main/res/`; bundled files are in `app/src/main/assets/`. Dependency versions and coordinates are managed in `gradle/libs.versions.toml`. `apk/` stores generated artifacts checked into the repo for reference.

## Build, Test, and Development Commands
Use the Gradle wrapper from the repository root:

```bash
./gradlew assembleDebug
./gradlew assembleRelease
./gradlew clean
./gradlew assembleDebug --stacktrace
```

`assembleDebug` builds a local debug APK. `assembleRelease` produces the release package named like `BluesApp_YYYYMMDDHHmm.apk`. `clean` removes build outputs. Use `--stacktrace` when dependency or AGP issues need full logs.

## Coding Style & Naming Conventions
This repo mixes Kotlin and Java, with current development centered on Kotlin + MVVM + Flow. Follow existing package splits such as `api/`, `service/`, `vm/`, `view/`, and `model/`. Name classes by role: `XxxApi`, `XxxRepository`, `XxxViewModel`, `XxxFragment`, `XxxActivity`. Keep XML names aligned to screens, for example `fragment_mainpage.xml`. Match the surrounding file style: 4-space indentation, concise methods, and feature-first packaging. Dependency changes belong in `gradle/libs.versions.toml`.

## Testing Guidelines
There are currently no committed `app/src/test` or `app/src/androidTest` sources. Also note: the root `build.gradle` disables tasks whose names contain `Test`, so new tests will not run until that logic is adjusted. When adding coverage, place JVM tests in `app/src/test` and instrumentation tests in `app/src/androidTest`, and name files after the target class, such as `WanAndroidBannerViewModelTest`.

## Commit & Pull Request Guidelines
Recent history uses short prefixes such as `fix.`, `feature.`, `update.`, `[upgrade]`, and `[compact]`. Keep commits focused and use the same style, for example `fix.修正首页 banner 空指针`. PRs should state changed modules, user-visible behavior, config or dependency updates, and include screenshots for UI changes. If a change touches unstable third-party APIs, call that out explicitly in the PR description.

## Architecture & Repo Notes
The app is migrating from MVP toward MVVM. Koin provides DI, and shared base classes live in `framework/base/`. Before adding libraries or version bumps, update `gradle/libs.versions.toml` instead of scattering versions through module build files.
