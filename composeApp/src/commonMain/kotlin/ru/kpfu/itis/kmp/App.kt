package ru.kpfu.itis.kmp

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.navigation.compose.currentBackStackEntryAsState
import org.koin.compose.koinInject
import ru.kpfu.itis.kmp.core.designsystem.component.BottomBar
import ru.kpfu.itis.kmp.core.designsystem.theme.AppTheme
import ru.kpfu.itis.kmp.core.navigation.NavigationHost
import ru.kpfu.itis.kmp.core.navigation.Route
import ru.kpfu.itis.kmp.core.navigation.rememberNavController
import ru.kpfu.itis.kmp.core.firebase.AuthService
import androidx.compose.runtime.getValue
import androidx.compose.runtime.staticCompositionLocalOf
import coil3.Image
import coil3.ImageLoader
import coil3.compose.LocalPlatformContext
import coil3.request.CachePolicy
import coil3.request.ImageRequest
import coil3.request.crossfade
import exampleapp.composeapp.generated.resources.Res
import exampleapp.composeapp.generated.resources.cat_with_book
import org.jetbrains.compose.resources.painterResource
import ru.kpfu.itis.kmp.core.ui.LocalImageLoader


@Composable
fun App() {
    val context = LocalPlatformContext.current
    val imageLoader = remember {
        ImageLoader.Builder(context)
            .crossfade(true)
            .memoryCachePolicy(CachePolicy.ENABLED)
            .diskCachePolicy(CachePolicy.ENABLED)
            .build()
    }

    CompositionLocalProvider(
        LocalImageLoader provides imageLoader
    ) {
        AppTheme {
            val authService: AuthService = koinInject<AuthService>()

            var startDestination = if (authService.isUserLoggedIn()) Route.Home else Route.Registration
            val navController = rememberNavController(startDestination)

            val currentRoute by navController.getCurrentRoute()

            Scaffold(
                bottomBar = {
                    if (currentRoute in listOf(Route.Home)) BottomBar(navController)
                }
            ) { innerPadding ->
                NavigationHost(startDestination = startDestination, navController = navController)
            }
        }
    }
}
