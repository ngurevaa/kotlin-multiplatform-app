package ru.kpfu.itis.kmp.core.firebase.remote

import kotlinx.serialization.Serializable

@Serializable
data class SignUpRequest(
    val email: String,
    val password: String,
    val returnSecureToken: Boolean = true
)
