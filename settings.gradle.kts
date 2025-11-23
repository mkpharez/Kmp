rootProject.name = "Kmp"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        maven("https://maven.google.com")
        gradlePluginPortal()
        mavenCentral()
    }
    
    resolutionStrategy {
        eachPlugin {
            if (requested.id.namespace == "com.android") {
                useModule("com.android.tools.build:gradle:${requested.version}")
            }
        }
    }
}

dependencyResolutionManagement {
    repositories {
        maven("https://maven.google.com")
        mavenCentral()
    }
}

include(":composeApp")
include(":shared")
