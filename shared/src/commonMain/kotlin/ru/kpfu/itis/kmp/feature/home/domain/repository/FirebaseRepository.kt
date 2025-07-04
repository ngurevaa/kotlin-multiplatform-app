package ru.kpfu.itis.kmp.feature.home.domain.repository

import ru.kpfu.itis.kmp.core.firebase.FirebaseEvent

interface FirebaseRepository {
    fun logout()
    suspend fun logEvent(event: FirebaseEvent)
}
