package ru.kpfu.itis.kmp.core.firebase.remote

import kotlinx.serialization.Serializable

@Serializable
data class SignInResponse(
    val idToken: String,
    val email: String,
    val refreshToken: String? = null,
    val expiresIn: String? = null,
    val localId: String,
    val registered: Boolean
)
