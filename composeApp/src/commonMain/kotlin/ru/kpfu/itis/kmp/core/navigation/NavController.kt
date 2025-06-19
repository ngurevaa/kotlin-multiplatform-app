package ru.kpfu.itis.kmp.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State

expect class NavController {
    @Composable
    fun getCurrentRoute(): State<Route>

    fun navigate(route: Route, navOptions: NavOptions = NavOptions())
}
