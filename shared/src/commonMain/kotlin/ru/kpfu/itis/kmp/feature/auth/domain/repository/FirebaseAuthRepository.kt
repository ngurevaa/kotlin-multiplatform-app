package ru.kpfu.itis.kmp.feature.auth.domain.repository


interface FirebaseAuthRepository {
    suspend fun signUp(email: String, password: String)
    suspend fun signIn(email: String, password: String)
}
