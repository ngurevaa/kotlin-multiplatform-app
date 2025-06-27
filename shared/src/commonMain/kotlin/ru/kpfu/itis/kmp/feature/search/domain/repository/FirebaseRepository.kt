package ru.kpfu.itis.kmp.feature.search.domain.repository

import ru.kpfu.itis.kmp.core.firebase.FirebaseEvent

interface FirebaseRepository {
    suspend fun logEvent(event: FirebaseEvent)
}
