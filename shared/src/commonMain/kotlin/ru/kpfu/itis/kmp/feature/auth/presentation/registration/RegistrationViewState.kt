package ru.kpfu.itis.kmp.feature.auth.presentation.registration

import androidx.compose.runtime.Immutable

@Immutable
data class RegistrationViewState(
    val email: String = "",
    val password: String = ""
)
