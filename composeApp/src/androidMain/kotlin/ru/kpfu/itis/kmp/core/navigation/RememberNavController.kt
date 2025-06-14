package ru.kpfu.itis.kmp.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.createGraph
import ru.kpfu.itis.kmp.feature.home.HomeScreen
import androidx.navigation.compose.rememberNavController as androidRememberNavController

@Composable
actual fun rememberNavController(startDestination: Route): NavController {
    val androidNavController = androidRememberNavController()
    return NavController(androidNavController)
}


