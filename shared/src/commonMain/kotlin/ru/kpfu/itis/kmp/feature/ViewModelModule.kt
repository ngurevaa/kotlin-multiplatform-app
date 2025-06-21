package ru.kpfu.itis.kmp.feature

import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import ru.kpfu.itis.kmp.core.designsystem.ThemeViewModel
import ru.kpfu.itis.kmp.feature.auth.presentation.login.LoginViewModel
import ru.kpfu.itis.kmp.feature.auth.presentation.registration.RegistrationViewModel
import ru.kpfu.itis.kmp.feature.bookdetails.presentation.BookDetailsViewModel
import ru.kpfu.itis.kmp.feature.bookmarks.presentation.BookmarksViewModel
import ru.kpfu.itis.kmp.feature.home.presentation.HomeViewModel

val viewModelModule = module {
    viewModel { RegistrationViewModel() }
    viewModel { LoginViewModel() }
    viewModel { HomeViewModel() }
    viewModel { BookDetailsViewModel() }
    viewModel { ThemeViewModel() }
    viewModel { BookmarksViewModel() }
}
