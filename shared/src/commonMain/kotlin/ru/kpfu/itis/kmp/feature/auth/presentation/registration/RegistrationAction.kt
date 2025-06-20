package ru.kpfu.itis.kmp.feature.auth.presentation.registration

sealed class RegistrationAction {
    data object ShowInternetConnectionError : RegistrationAction()
    data object ShowEmailError : RegistrationAction()
    data object ShowPasswordError : RegistrationAction()
    data object NavigateToLogin : RegistrationAction()
    data object NavigateToHome : RegistrationAction()
}
