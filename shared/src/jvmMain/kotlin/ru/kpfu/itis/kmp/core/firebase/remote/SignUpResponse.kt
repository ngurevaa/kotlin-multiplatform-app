package ru.kpfu.itis.kmp.core.firebase.remote

import kotlinx.serialization.Serializable

@Serializable
data class SignUpResponse(
    val idToken: String,
    val email: String,
    val refreshToken: String? = null,
    val expiresIn: String? = null,
    val localId: String,
)
