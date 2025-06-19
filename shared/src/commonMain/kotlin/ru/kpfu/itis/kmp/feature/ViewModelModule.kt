package ru.kpfu.itis.kmp.feature

import org.koin.dsl.module
import org.koin.core.module.dsl.viewModel
import ru.kpfu.itis.kmp.core.viewmodel.MainViewModelDispatcher
import ru.kpfu.itis.kmp.feature.auth.presentation.login.LoginViewModel
import ru.kpfu.itis.kmp.feature.auth.presentation.registration.RegistrationViewModel
import ru.kpfu.itis.kmp.feature.bookdetails.presentation.BookDetailsViewModel
import ru.kpfu.itis.kmp.feature.home.presentation.HomeViewModel

val viewModelModule = module {
    viewModel { RegistrationViewModel() }
    viewModel { LoginViewModel() }
    viewModel { HomeViewModel() }
    viewModel { (id: String) -> BookDetailsViewModel(id) }
}
