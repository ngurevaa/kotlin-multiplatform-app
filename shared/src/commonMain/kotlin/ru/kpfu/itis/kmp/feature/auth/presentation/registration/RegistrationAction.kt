package ru.kpfu.itis.kmp.feature.auth.presentation.registration

import ru.kpfu.itis.kmp.feature.auth.presentation.login.LoginAction

sealed class RegistrationAction {
    data object ShowRegistrationError : RegistrationAction()
    data object ShowEmailError : RegistrationAction()
    data object ShowPasswordError : RegistrationAction()
    data object NavigateToLogin : RegistrationAction()
    data object NavigateToHome : RegistrationAction()
}
