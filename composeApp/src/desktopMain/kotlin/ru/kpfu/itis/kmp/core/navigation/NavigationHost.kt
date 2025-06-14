package ru.kpfu.itis.kmp.core.navigation

import androidx.compose.runtime.Composable
import ru.kpfu.itis.kmp.feature.auth.LoginScreen
import ru.kpfu.itis.kmp.feature.auth.RegistrationScreen
import ru.kpfu.itis.kmp.feature.home.HomeScreen

@Composable
actual fun NavigationHost(
    startDestination: Route,
    navController: NavController
) {
    NavHost(navController) {
        composable(Route.Registration) {
            RegistrationScreen(
                navigateToLogin = { navController.navigate(Route.Login) },
                navigateToHome = { navController.navigate(Route.Home) }
            )
        }

        composable(Route.Login) {
            LoginScreen(
                navigateToRegistration = { navController.navigate(Route.Registration) },
                navigateToHome = { navController.navigate(Route.Home) }
            )
        }

        composable(Route.Home) {
            HomeScreen()
        }

    }.build()
}

class NavHost(
    val navController: NavController,
    val contents: @Composable NavigationGraphBuilder.() -> Unit
) {

    @Composable
    fun build() {
        NavigationGraphBuilder().renderContents()
    }

    inner class NavigationGraphBuilder(
        val navController: NavController = this@NavHost.navController
    ) {
        @Composable
        fun renderContents() {
            this@NavHost.contents(this)
        }
    }
}

@Composable
fun NavHost.NavigationGraphBuilder.composable(
    route: Route,
    content: @Composable () -> Unit
) {
    if (navController.getCurrentRoute().value == route) {
        content()
    }
}
