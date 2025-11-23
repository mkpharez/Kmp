# Kotlin Multiplatform (KMP) App with Compose UI

![Build Status](https://github.com/mkpharez/Kmp/workflows/Build%20Kotlin%20Multiplatform%20App/badge.svg)

A Kotlin Multiplatform project using Jetpack Compose UI that runs on multiple platforms:
- ✅ **Desktop** (Windows, macOS, Linux via JVM)
- ✅ **Web** (via Kotlin/Wasm)
- ✅ **iOS** (iOS 14.1+, requires macOS with Xcode to build)
- ⚠️ **Android** (configured but requires access to Google Maven Repository)

> **Note**: This project requires internet access to Google's Maven repository (`maven.google.com`) to download AndroidX dependencies. See [SETUP_NOTES.md](SETUP_NOTES.md) for details and workarounds if you encounter network restrictions.

## Project Structure

```
Kmp/
├── shared/                          # Shared Kotlin code
│   ├── src/
│   │   ├── commonMain/              # Platform-independent code
│   │   │   └── kotlin/com/mkpharez/kmp/shared/
│   │   │       ├── App.kt           # Main Compose UI
│   │   │       └── Platform.kt      # Platform interface
│   │   ├── desktopMain/             # Desktop-specific code
│   │   ├── iosMain/                 # iOS-specific code
│   │   └── wasmJsMain/              # Web-specific code
│   └── build.gradle.kts
├── composeApp/                      # Application entry points
│   ├── src/
│   │   ├── commonMain/              # Shared app code
│   │   ├── desktopMain/             # Desktop entry point
│   │   └── wasmJsMain/              # Web entry point
│   └── build.gradle.kts
├── gradle/                          # Gradle configuration
│   ├── wrapper/
│   └── libs.versions.toml           # Dependency versions
├── build.gradle.kts                 # Root build file
├── settings.gradle.kts              # Project settings
└── gradle.properties                # Gradle properties

```

## Features

- **Shared UI Code**: Write your UI once with Compose Multiplatform and run it everywhere
- **Material 3 Design**: Modern Material Design components
- **Reactive State Management**: Built-in Compose state management
- **Platform Detection**: Automatically detects and displays the running platform
- **Modular Architecture**: Clean separation between shared logic and platform-specific code

## Prerequisites

- **JDK 11 or higher** - Required for all platforms
- **Gradle 8.7+** - Included via Gradle wrapper
- **For iOS builds**: macOS with Xcode installed
- **For Web builds**: No additional requirements
- **For Android builds**: Access to Google Maven Repository (dl.google.com)

## Building the Project

### Desktop Application

Build and run the desktop application:

```bash
./gradlew :composeApp:run
```

Create a distributable package:

```bash
./gradlew :composeApp:packageDistributionForCurrentOS
```

The package will be in `composeApp/build/compose/binaries/main/`

### Web Application (Wasm)

Build the web application:

```bash
./gradlew :composeApp:wasmJsBrowserDistribution
```

The output will be in `composeApp/build/dist/wasmJs/productionExecutable/`

To run a development server:

```bash
./gradlew :composeApp:wasmJsBrowserDevelopmentRun
```

### iOS Application

**Note**: iOS builds require a Mac with Xcode installed.

Build iOS frameworks:

```bash
./gradlew :composeApp:linkReleaseFrameworkIosArm64
./gradlew :composeApp:linkReleaseFrameworkIosSimulatorArm64
```

The frameworks will be in `composeApp/build/bin/iosArm64/releaseFramework/`

To integrate with Xcode, you'll need to create an iOS app project in Xcode that uses the generated framework.

### Android Application

**Note**: Android builds are configured but currently require network access to Google Maven (dl.google.com).

If you have access to Google Maven, you can:

1. Uncomment Android plugin references in `build.gradle.kts`
2. Add back Android source sets
3. Run:

```bash
./gradlew :composeApp:assembleDebug
```

## Development

### Adding New Features

1. **Shared UI**: Add composables in `shared/src/commonMain/kotlin/`
2. **Platform-specific code**: Use `expect/actual` pattern in respective source sets
3. **Dependencies**: Update `gradle/libs.versions.toml`

### Testing

Run tests across all platforms:

```bash
./gradlew allTests
```

Run desktop tests only:

```bash
./gradlew :shared:desktopTest
```

## Continuous Integration

GitHub Actions workflows are provided for automated builds and artifact generation:
- Build workflow: Compiles code for all platforms
- Creates downloadable artifacts for Desktop, Web, and iOS frameworks

## Troubleshooting

### iOS targets disabled

If you see warnings about iOS targets being disabled, this is normal on non-Mac systems. iOS compilation requires macOS with Xcode.

### Network issues

The project requires internet access to download Kotlin and Compose dependencies from Maven Central and Gradle Plugin Portal. If you encounter network issues with Google Maven, Android builds may fail.

### Memory issues

If you encounter out-of-memory errors, increase the heap size in `gradle.properties`:

```properties
org.gradle.jvmargs=-Xmx4096M
```

## Learn More

- [Kotlin Multiplatform](https://kotlinlang.org/docs/multiplatform.html)
- [Compose Multiplatform](https://www.jetbrains.com/lp/compose-multiplatform/)
- [Compose for Desktop](https://github.com/JetBrains/compose-multiplatform#compose-multiplatform)
- [Compose for Web/Wasm](https://kotl.in/wasm-compose-example)

## License

This project is provided as-is for learning and demonstration purposes.

