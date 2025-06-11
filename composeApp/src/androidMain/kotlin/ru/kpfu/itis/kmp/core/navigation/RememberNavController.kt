package ru.kpfu.itis.kmp.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.createGraph

@Composable
actual fun rememberNavController(startDestination: Route): NavController =
    rememberNavController(startDestination = startDestination).apply {
        graph = createGraph(startDestination) {
        }
    }
