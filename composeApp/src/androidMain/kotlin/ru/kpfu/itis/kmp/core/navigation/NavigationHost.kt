package ru.kpfu.itis.kmp.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.kpfu.itis.kmp.feature.auth.LoginScreen
import ru.kpfu.itis.kmp.feature.auth.RegistrationScreen
import ru.kpfu.itis.kmp.feature.home.HomeScreen

@Composable
actual fun NavigationHost(
    startDestination: Route,
    navController: NavController
) {
    NavHost(
        startDestination = startDestination,
        navController = navController.navHostController
    ) {
        composable<Route.Registration> {
            RegistrationScreen(
                navigateToLogin = { navController.navigate(Route.Login) },
                navigateToHome = { navController.navigate(Route.Home) }
            )
        }
        composable<Route.Login> {
            LoginScreen(
                navigateToRegistration = { navController.navigate(Route.Registration) },
                navigateToHome = { navController.navigate(Route.Home) }
            )
        }
        composable<Route.Home> {
            HomeScreen()
        }
    }
}
