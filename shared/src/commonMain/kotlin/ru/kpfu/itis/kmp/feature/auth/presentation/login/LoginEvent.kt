package ru.kpfu.itis.kmp.feature.auth.presentation.login

sealed class LoginEvent {
    data class UpdateEmail(val email: String) : LoginEvent()
    data class UpdatePassword(val password: String): LoginEvent()
    data object SignIn : LoginEvent()
    data object ClickRegistrationReference : LoginEvent()
    data object OpenScreen : LoginEvent()
}
