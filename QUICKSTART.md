# Quick Start Guide

Get up and running with this Kotlin Multiplatform Compose project in minutes!

## Prerequisites

Before you start, ensure you have:

- ✅ **JDK 11 or higher** installed
- ✅ **Internet access** (including access to maven.google.com)
- ✅ **Git** for cloning the repository

### Optional (for specific platforms):
- **macOS with Xcode**: For iOS development
- **Modern web browser**: For testing Web/Wasm build

## Quick Start (5 minutes)

### 1. Clone the Repository

```bash
git clone https://github.com/mkpharez/Kmp.git
cd Kmp
```

### 2. Run on Desktop (Fastest way to see it work!)

```bash
./gradlew :composeApp:run
```

This will:
1. Download all dependencies
2. Compile the code
3. Launch the desktop application

You should see a window with "Kotlin Multiplatform" title and the demo UI!

### 3. Build for Other Platforms

#### Web (Wasm) with Dev Server
```bash
./gradlew :composeApp:wasmJsBrowserDevelopmentRun
```
Opens browser at `http://localhost:8080`

#### Desktop JAR
```bash
./gradlew :composeApp:desktopJar
```
Output: `composeApp/build/libs/composeApp-desktop.jar`

#### iOS Framework (macOS only)
```bash
./gradlew :composeApp:linkReleaseFrameworkIosArm64
```

## Project Structure at a Glance

```
Kmp/
├── shared/                  # Shared Kotlin code
│   └── src/commonMain/      # UI code that runs everywhere
│       └── App.kt           # Your main UI - edit this!
│
├── composeApp/              # Platform entry points
│   ├── src/desktopMain/     # Desktop launcher
│   ├── src/wasmJsMain/      # Web launcher
│   └── src/iosMain/         # iOS framework
│
└── gradle/                  # Build configuration
```

## Making Your First Change

### 1. Edit the UI

Open `shared/src/commonMain/kotlin/com/mkpharez/kmp/shared/App.kt`

Try changing the title:
```kotlin
Text(
    text = "My Awesome KMP App",  // Changed this line!
    fontSize = 32.sp,
    fontWeight = FontWeight.Bold,
    modifier = Modifier.padding(top = 32.dp)
)
```

### 2. See Your Changes

#### Desktop (Hot Reload)
Stop the app (Ctrl+C) and run again:
```bash
./gradlew :composeApp:run
```

#### Web (Auto Reload)
If dev server is running, just save the file and refresh browser!

### 3. Add New Features

Add a new composable in `App.kt`:

```kotlin
@Composable
fun MyNewFeature() {
    Card(
        modifier = Modifier.fillMaxWidth().padding(16.dp)
    ) {
        Text(
            text = "My New Feature!",
            modifier = Modifier.padding(16.dp)
        )
    }
}
```

Then use it in your `App()`:
```kotlin
@Composable
fun App() {
    MaterialTheme {
        Column {
            MyNewFeature()  // Add your new composable
            // ... rest of the UI
        }
    }
}
```

## Common Tasks

### Build Everything
```bash
./gradlew build
```

### Clean Build
```bash
./gradlew clean build
```

### Run Tests
```bash
./gradlew test
```

### Create Distribution Package
```bash
./gradlew :composeApp:packageDistributionForCurrentOS
```

Output location: `composeApp/build/compose/binaries/main/`

## IDE Setup

### IntelliJ IDEA (Recommended)

1. Open IntelliJ IDEA
2. Select "Open" and choose the Kmp folder
3. Wait for Gradle sync to complete
4. Run configurations will be automatically created

### Android Studio

1. Open Android Studio
2. Select "Open an Existing Project"
3. Choose the Kmp folder
4. Wait for Gradle sync

## Troubleshooting

### "Could not resolve androidx.arch.core"

**Problem**: Can't download dependencies from Google Maven.

**Solution**: Ensure you have internet access and can reach maven.google.com

Try:
```bash
ping maven.google.com
```

### "iOS targets cannot be built"

**Problem**: iOS compilation requires macOS.

**Solution**: This is normal on Windows/Linux. iOS builds require a Mac with Xcode.

### Out of Memory

**Problem**: Gradle runs out of memory.

**Solution**: Increase heap size in `gradle.properties`:
```properties
org.gradle.jvmargs=-Xmx4096M
```

### Slow Build

**Problem**: First build takes a long time.

**Solution**: This is normal. Gradle downloads dependencies. Subsequent builds are faster.

**Tip**: Use Gradle daemon:
```bash
./gradlew :composeApp:run  # Without --no-daemon flag
```

## Next Steps

### Learn More

1. **Read the Architecture**: See [ARCHITECTURE.md](ARCHITECTURE.md)
2. **Check UI Design**: See [UI_PREVIEW.md](UI_PREVIEW.md)
3. **Setup Notes**: See [SETUP_NOTES.md](SETUP_NOTES.md)

### Explore Compose

- [Compose Multiplatform Docs](https://github.com/JetBrains/compose-multiplatform)
- [Compose UI Components](https://developer.android.com/jetpack/compose)
- [Material 3 Design](https://m3.material.io/)

### Add Features

Common additions:
- **Navigation**: Add screens with navigation
- **Networking**: Fetch data from APIs (use Ktor)
- **Database**: Local storage with SQLDelight
- **Dependency Injection**: Use Koin for DI
- **Testing**: Add unit and UI tests

### Share Your Work

1. Push changes to GitHub
2. GitHub Actions will build for all platforms
3. Download artifacts from Actions tab
4. Share with testers!

## Development Tips

### Fast Iteration

For fastest development:
1. Use Desktop target (`./gradlew :composeApp:run`)
2. Make changes to `shared/src/commonMain/`
3. Stop and restart app to see changes
4. Test on other platforms before releasing

### Debugging

#### Desktop
Use IntelliJ's debugger - set breakpoints and run in debug mode

#### Web
Use browser DevTools - open Console for Kotlin stack traces

#### iOS
Build framework, then debug in Xcode

### Performance

- Compose is fast but watch for:
  - Excessive recomposition (use `remember`)
  - Large lists (use `LazyColumn`, not `Column`)
  - Heavy calculations in composables (use coroutines)

## Getting Help

- **Issues**: Check existing issues or open new ones on GitHub
- **Kotlin Slack**: Join #compose-multiplatform channel
- **Stack Overflow**: Tag questions with `kotlin-multiplatform` and `compose-multiplatform`

## Useful Commands Cheat Sheet

```bash
# Run desktop app
./gradlew :composeApp:run

# Run web app with dev server
./gradlew :composeApp:wasmJsBrowserDevelopmentRun

# Build all modules
./gradlew build

# Build desktop JAR
./gradlew :composeApp:desktopJar

# Package desktop distribution
./gradlew :composeApp:packageDistributionForCurrentOS

# Build web production
./gradlew :composeApp:wasmJsBrowserDistribution

# Build iOS framework
./gradlew :composeApp:linkReleaseFrameworkIosArm64

# Run tests
./gradlew test

# Clean build
./gradlew clean

# Show dependencies
./gradlew :shared:dependencies
```

## Success Indicators

You know everything is working when:

✅ Desktop app launches and shows the UI
✅ "Show Features" button toggles the feature list
✅ Platform name is displayed correctly
✅ Material 3 theme colors look good
✅ Web version works in browser
✅ GitHub Actions builds successfully (check Actions tab)

## Have Fun!

You now have a working Kotlin Multiplatform app with Compose UI. Start building your own amazing cross-platform applications! 🚀
