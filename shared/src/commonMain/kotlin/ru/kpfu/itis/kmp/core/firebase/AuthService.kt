package ru.kpfu.itis.kmp.core.firebase

expect class AuthService() {
    suspend fun signUpWithEmail(email: String, password: String)
    suspend fun signInWithEmail(email: String, password: String)
    fun isUserLoggedIn(): Boolean
    fun logout()
}
