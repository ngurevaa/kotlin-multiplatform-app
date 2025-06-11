package ru.kpfu.itis.kmp.core.navigation

import androidx.compose.runtime.Composable

@Composable
expect fun rememberNavController(startDestination: Route): NavController
