package ru.kpfu.itis.kmp.core.navigation

import androidx.compose.runtime.Composable

@Composable
expect fun NavigationHost(startDestination: Route = Route.Registration)
