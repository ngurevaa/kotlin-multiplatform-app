package ru.kpfu.itis.kmp.feature.auth.presentation.login

import androidx.compose.runtime.Immutable

@Immutable
data class LoginViewState(
    val email: String = "",
    val password: String = "",
)
