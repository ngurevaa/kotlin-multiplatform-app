package ru.kpfu.itis.kmp.feature.auth.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext
import ru.kpfu.itis.kmp.core.firebase.AnalyticsService
import ru.kpfu.itis.kmp.core.firebase.AuthService
import ru.kpfu.itis.kmp.core.firebase.FirebaseEvent
import ru.kpfu.itis.kmp.feature.auth.domain.repository.FirebaseRepository

internal class FirebaseRepositoryImpl(
    private val authService: AuthService,
    private val analyticsService: AnalyticsService
) : FirebaseRepository {
    override suspend fun signUp(email: String, password: String) {
        withContext(Dispatchers.IO) {
            authService.signUpWithEmail(email, password)
        }
    }

    override suspend fun signIn(email: String, password: String) {
        withContext(Dispatchers.IO) {
            authService.signInWithEmail(email, password)
        }
    }

    override suspend fun logEvent(event: FirebaseEvent) {
        withContext(Dispatchers.IO) {
            analyticsService.logFirebaseEvent(event)
        }
    }
}
