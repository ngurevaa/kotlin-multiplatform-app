package ru.kpfu.itis.kmp.feature.auth.presentation.login

sealed class LoginAction {
    data object ShowError : LoginAction()
    data object NavigateToRegistration : LoginAction()
}
