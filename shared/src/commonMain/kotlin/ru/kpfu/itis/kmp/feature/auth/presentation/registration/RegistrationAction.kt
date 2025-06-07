package ru.kpfu.itis.kmp.feature.auth.presentation.registration

import ru.kpfu.itis.kmp.feature.auth.presentation.login.LoginAction

sealed class RegistrationAction {
    data object ShowError : RegistrationAction()
    data object NavigateToLogin : RegistrationAction()
}
