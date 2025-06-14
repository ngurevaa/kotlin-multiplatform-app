package ru.kpfu.itis.kmp.feature.auth.presentation.login

sealed class LoginAction {
    data object ShowLoginError : LoginAction()
    data object NavigateToRegistration : LoginAction()
    data object NavigateToHome : LoginAction()
}
