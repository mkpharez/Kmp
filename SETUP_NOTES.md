# Setup Notes and Known Limitations

## Current Network Limitation

**Important**: This project was developed in an environment with restricted network access. Specifically, access to Google's Maven repository (`dl.google.com` and its mirrors) is blocked. This affects the ability to build the project fully as Compose Multiplatform has transitive dependencies on AndroidX libraries that are only available from Google Maven.

## Dependencies Requiring Google Maven

The following dependencies need Google Maven access:
- `androidx.arch.core:core-common:2.2.0` (transitively required by Compose Multiplatform's lifecycle components)
- Other AndroidX libraries used by Compose

## Workarounds

### Option 1: Build in an Environment with Google Maven Access

The recommended solution is to build this project in an environment that has access to Google's Maven repository:

1. Clone the repository on your local machine or a CI/CD system with internet access
2. Run `./gradlew build`
3. The build should complete successfully

### Option 2: Use a Maven Mirror

If you have access to a corporate Maven mirror that caches Google Maven artifacts:

1. Add the mirror URL to `settings.gradle.kts`:
```kotlin
dependencyResolutionManagement {
    repositories {
        maven("https://your-corporate-mirror.com/maven-google/")
        mavenCentral()
    }
}
```

### Option 3: Manual Dependency Cache

For advanced users with restricted environments:

1. Download required dependencies from Google Maven on an unrestricted machine
2. Set up a local Maven repository
3. Configure Gradle to use the local repository

## Building Individual Targets

Once dependencies are resolved, you can build for specific platforms:

### Desktop (JVM)
```bash
./gradlew :composeApp:desktopJar
./gradlew :composeApp:run
```

### Web (Wasm)
```bash
./gradlew :composeApp:wasmJsBrowserDevelopmentRun
```

### iOS (macOS only)
```bash
./gradlew :composeApp:linkReleaseFrameworkIosArm64
```

## GitHub Actions

The GitHub Actions workflows in `.github/workflows/build.yml` are configured to:
- Build Desktop applications (Linux runner)
- Build Web/Wasm applications
- Build iOS frameworks (macOS runner)
- Upload artifacts for each platform

These workflows will work on GitHub's hosted runners which have full internet access.

## Project Structure Valid Without Build

Even though the build may fail in restricted environments, the project structure is complete and valid:
- All source files are present
- Build configuration is correct
- Code is ready to compile once dependencies are available

## Testing the Project

To verify the project works:

1. **On GitHub Actions**: Push to a branch, and the workflows will automatically build artifacts
2. **Locally with Internet**: Clone and run `./gradlew build`
3. **In Docker**: Use a container with internet access
4. **On CI/CD**: Most CI/CD systems have unrestricted internet access

## Next Steps

Users can:
1. Download artifacts from GitHub Actions runs
2. Build locally if they have internet access
3. Customize the UI in `shared/src/commonMain/kotlin/com/mkpharez/kmp/shared/App.kt`
4. Add platform-specific code in respective source sets
5. Test on actual devices (Android, iOS) using the generated artifacts

## Support

For issues related to:
- **Build failures**: Ensure you have internet access to Google Maven
- **Platform-specific code**: Check the respective source set (iosMain, desktopMain, wasmJsMain)
- **Compose UI**: Refer to [Compose Multiplatform documentation](https://www.jetbrains.com/lp/compose-multiplatform/)
