package ru.kpfu.itis.kmp.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController as androidRememberNavController

@Composable
actual fun rememberNavController(startDestination: Route): NavController {
    val androidNavController = androidRememberNavController()
    return NavController(androidNavController)
}


