package ru.kpfu.itis.kmp.core.navigation

import androidx.compose.runtime.Composable
import ru.kpfu.itis.kmp.core.navigation.NavController

@Composable
expect fun rememberNavController(startDestination: Route): NavController
