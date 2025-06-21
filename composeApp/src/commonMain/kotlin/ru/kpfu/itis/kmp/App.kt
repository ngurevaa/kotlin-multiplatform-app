package ru.kpfu.itis.kmp

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import coil3.ImageLoader
import coil3.compose.LocalPlatformContext
import coil3.request.CachePolicy
import coil3.request.crossfade
import org.koin.compose.koinInject
import org.koin.compose.viewmodel.koinViewModel
import ru.kpfu.itis.kmp.core.designsystem.ThemeEvent
import ru.kpfu.itis.kmp.core.designsystem.ThemeViewModel
import ru.kpfu.itis.kmp.core.designsystem.component.BottomBar
import ru.kpfu.itis.kmp.core.designsystem.theme.AppTheme
import ru.kpfu.itis.kmp.core.firebase.AuthService
import ru.kpfu.itis.kmp.core.navigation.NavigationHost
import ru.kpfu.itis.kmp.core.navigation.Route
import ru.kpfu.itis.kmp.core.navigation.rememberNavController
import ru.kpfu.itis.kmp.core.ui.LocalImageLoader
import ru.kpfu.itis.kmp.feature.home.presentation.HomeEvent
import ru.kpfu.itis.kmp.feature.home.presentation.HomeViewModel

val LocalThemeViewModel = staticCompositionLocalOf<ThemeViewModel> { error("No ViewModel!") }

@Composable
fun App(viewModel: ThemeViewModel = koinViewModel<ThemeViewModel>()) {
    val context = LocalPlatformContext.current
    val imageLoader = remember {
        ImageLoader.Builder(context)
            .crossfade(true)
            .memoryCachePolicy(CachePolicy.ENABLED)
            .diskCachePolicy(CachePolicy.ENABLED)
            .build()
    }

    val state by viewModel.getViewStates().collectAsState()
    val obtainEvent = viewModel::obtainEvent

    CompositionLocalProvider(
        LocalImageLoader provides imageLoader,
        LocalThemeViewModel provides viewModel
    ) {
        val isSystemDarkTheme = isSystemInDarkTheme()
        LaunchedEffect(Unit) {
            obtainEvent(ThemeEvent.ChangeTheme(isSystemDarkTheme))
        }

        AppTheme(
            darkTheme = state.isDarkTheme
        ) {
            Navigation()
        }
    }
}

@Composable
internal fun Navigation() {
    val authService: AuthService = koinInject<AuthService>()

    var startDestination = if (authService.isUserLoggedIn()) Route.Home else Route.Registration
    val navController = rememberNavController(startDestination)

    val currentRoute by navController.getCurrentRoute()

    Scaffold(
        bottomBar = {
            if (currentRoute in listOf(Route.Home, Route.Bookmarks)) BottomBar(navController)
        }
    ) { innerPadding ->
        NavigationHost(startDestination = startDestination, navController = navController)
    }
}
