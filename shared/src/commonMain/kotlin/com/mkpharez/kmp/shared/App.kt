package com.mkpharez.kmp.shared

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun App() {
    MaterialTheme {
        var showContent by remember { mutableStateOf(false) }
        
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Header
            Text(
                text = "Kotlin Multiplatform",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 32.dp)
            )
            
            Text(
                text = "Compose UI Demo",
                fontSize = 24.sp,
                color = MaterialTheme.colorScheme.primary
            )
            
            // Platform Info
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "Running on: ${getPlatform().name}",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
            
            // Toggle Button
            Button(
                onClick = { showContent = !showContent }
            ) {
                Text(if (showContent) "Hide Features" else "Show Features")
            }
            
            // Animated Content
            AnimatedVisibility(showContent) {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.secondaryContainer
                    )
                ) {
                    LazyColumn(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        items(getFeatures()) { feature ->
                            FeatureItem(feature)
                        }
                    }
                }
            }
            
            Spacer(modifier = Modifier.weight(1f))
            
            // Footer
            Text(
                text = "Built with Jetpack Compose",
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }
    }
}

@Composable
fun FeatureItem(feature: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "✓",
            fontSize = 20.sp,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(end = 8.dp)
        )
        Text(
            text = feature,
            fontSize = 16.sp
        )
    }
}

fun getFeatures(): List<String> {
    return listOf(
        "Cross-platform UI with Compose",
        "Android Support",
        "iOS Support",
        "Desktop Support (JVM)",
        "Web Support (Wasm)",
        "Shared Business Logic",
        "Material 3 Design",
        "Reactive State Management"
    )
}
