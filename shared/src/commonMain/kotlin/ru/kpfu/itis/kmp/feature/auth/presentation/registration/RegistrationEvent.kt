package ru.kpfu.itis.kmp.feature.auth.presentation.registration

sealed class RegistrationEvent {
    data class UpdateEmail(val email: String) : RegistrationEvent()
    data class UpdatePassword(val password: String): RegistrationEvent()
    data object SignUp : RegistrationEvent()
    data object ClickLoginReference: RegistrationEvent()
}
