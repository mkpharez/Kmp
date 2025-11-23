# UI Preview and Description

This document describes the user interface of the Kotlin Multiplatform Compose application.

## Application UI Layout

When the application runs, it displays the following interface:

```
┌─────────────────────────────────────────────────────┐
│                                                      │
│                                                      │
│              Kotlin Multiplatform                   │
│                                                      │
│               Compose UI Demo                       │
│                                                      │
│  ┌────────────────────────────────────────────┐    │
│  │                                             │    │
│  │  Running on: Java 11.0.x                   │    │
│  │  (or iOS 17.x, Web with Kotlin/Wasm)      │    │
│  │                                             │    │
│  └────────────────────────────────────────────┘    │
│                                                      │
│              ┌──────────────────┐                   │
│              │  Show Features   │                   │
│              └──────────────────┘                   │
│                                                      │
│  [When button is clicked, features appear below]    │
│                                                      │
│                                                      │
│                                                      │
│                                                      │
│           Built with Jetpack Compose                │
│                                                      │
└─────────────────────────────────────────────────────┘
```

## After Clicking "Show Features"

```
┌─────────────────────────────────────────────────────┐
│                                                      │
│              Kotlin Multiplatform                   │
│               Compose UI Demo                       │
│                                                      │
│  ┌────────────────────────────────────────────┐    │
│  │  Running on: [Platform Name]               │    │
│  └────────────────────────────────────────────┘    │
│                                                      │
│              ┌──────────────────┐                   │
│              │  Hide Features   │                   │
│              └──────────────────┘                   │
│                                                      │
│  ┌────────────────────────────────────────────┐    │
│  │                                             │    │
│  │  ✓ Cross-platform UI with Compose         │    │
│  │  ✓ Android Support                         │    │
│  │  ✓ iOS Support                             │    │
│  │  ✓ Desktop Support (JVM)                   │    │
│  │  ✓ Web Support (Wasm)                      │    │
│  │  ✓ Shared Business Logic                   │    │
│  │  ✓ Material 3 Design                       │    │
│  │  ✓ Reactive State Management               │    │
│  │                                             │    │
│  └────────────────────────────────────────────┘    │
│                                                      │
│           Built with Jetpack Compose                │
└─────────────────────────────────────────────────────┘
```

## UI Components Description

### 1. Header Section
- **Title**: "Kotlin Multiplatform" (32sp, Bold)
- **Subtitle**: "Compose UI Demo" (24sp, Primary color)
- Centered horizontally with padding

### 2. Platform Information Card
- Material 3 Card with primary container color
- Displays current platform (e.g., "Java 11.0.22", "iOS 17.5", "Web with Kotlin/Wasm")
- 18sp Medium weight text
- Full width with padding

### 3. Toggle Button
- Material 3 Button
- Text alternates between "Show Features" and "Hide Features"
- Centered in the layout

### 4. Features List (Animated)
- Appears/disappears smoothly with AnimatedVisibility
- Material 3 Card with secondary container color
- LazyColumn containing feature items
- Each feature has a checkmark (✓) and description

### 5. Footer
- Small text (14sp)
- Secondary text color
- "Built with Jetpack Compose"
- Positioned at bottom

## Color Scheme

The application uses Material 3 dynamic color scheme which adapts based on:
- System theme (Light/Dark mode)
- Platform defaults

**Light Mode Colors**:
- Primary: Material blue
- Primary Container: Light blue
- Secondary Container: Light teal
- Background: White
- Surface: Light gray

**Dark Mode Colors**:
- Primary: Light blue
- Primary Container: Dark blue
- Secondary Container: Dark teal
- Background: Dark gray
- Surface: Dark gray

## Interactions

### Button Click
1. User clicks "Show Features" button
2. Features card animates in from top with fade effect
3. Button text changes to "Hide Features"
4. LazyColumn displays all 8 features with checkmarks

### Button Click Again
1. User clicks "Hide Features" button
2. Features card animates out with fade effect
3. Button text changes back to "Show Features"

## Responsive Design

The UI adapts to different screen sizes:

**Mobile (Small Screens)**:
- Full width cards
- Compact padding (16dp)
- Scrollable content in LazyColumn

**Desktop (Large Screens)**:
- Full width cards within the window
- Comfortable padding (16dp)
- More vertical space

**Web**:
- Canvas fills entire browser viewport
- Scales with window resizing
- Maintains aspect ratio and layout

## Platform-Specific Display

### Desktop (JVM)
```
Running on: Java 11.0.22
```

### iOS
```
Running on: iOS 17.5
```

### Web (Wasm)
```
Running on: Web with Kotlin/Wasm
```

## Animation Details

**AnimatedVisibility** properties:
- Enter: Fade in + Slide down
- Exit: Fade out + Slide up
- Duration: Default Material duration (300ms)
- Easing: Material standard curve

## Accessibility

The UI follows Material Design accessibility guidelines:
- Sufficient contrast ratios
- Touch target sizes (48dp minimum)
- Readable font sizes
- Semantic structure

## State Management

The app uses Compose's built-in state management:

```kotlin
var showContent by remember { mutableStateOf(false) }
```

When `showContent` changes:
- Compose automatically recomposes affected UI
- AnimatedVisibility handles the transition
- Button text updates reactively

## Material 3 Components Used

1. **MaterialTheme**: Provides theming
2. **Text**: Typography with various styles
3. **Button**: Interactive element
4. **Card**: Containers with elevation
5. **Column**: Vertical layout
6. **LazyColumn**: Efficient scrollable list
7. **Row**: Horizontal layout for feature items
8. **Spacer**: Flexible spacing

## Typography Scale

- **Display**: 32sp (Title)
- **Headline**: 24sp (Subtitle)
- **Title**: 18sp (Platform info)
- **Body**: 16sp (Feature text)
- **Label**: 14sp (Footer)

## Spacing System

- **Small**: 4dp (Feature item vertical padding)
- **Medium**: 8dp (Between feature items)
- **Large**: 16dp (Container padding)
- **XLarge**: 32dp (Top padding for title)

## Testing the UI

To see this UI in action:

1. **Desktop**: Run `./gradlew :composeApp:run`
2. **Web**: Run `./gradlew :composeApp:wasmJsBrowserDevelopmentRun`
3. **iOS**: Build framework and open in Xcode simulator

## Customization Ideas

You can customize the app by:
1. Changing colors in MaterialTheme
2. Adding more cards with different information
3. Implementing navigation between screens
4. Adding images or icons
5. Creating more interactive elements
6. Adding data from network or database
7. Implementing dark/light mode toggle
8. Adding animations and transitions

## Code Location

The UI is implemented in:
```
shared/src/commonMain/kotlin/com/mkpharez/kmp/shared/App.kt
```

All the UI code is shared across platforms, demonstrating the power of Compose Multiplatform!
