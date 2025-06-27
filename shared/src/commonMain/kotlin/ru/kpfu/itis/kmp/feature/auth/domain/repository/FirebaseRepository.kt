package ru.kpfu.itis.kmp.feature.auth.domain.repository

import ru.kpfu.itis.kmp.core.firebase.FirebaseEvent


interface FirebaseRepository {
    suspend fun signUp(email: String, password: String)
    suspend fun signIn(email: String, password: String)
    suspend fun logEvent(event: FirebaseEvent)
}
