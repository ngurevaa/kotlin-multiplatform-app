package ru.kpfu.itis.kmp.core.firebase

import kotlinx.serialization.Serializable

@Serializable
data class SignUpRequest(
    val email: String,
    val password: String,
    val returnSecureToken: Boolean = true
)
