package ru.kpfu.itis.kmp.feature.bookdetails.domain.repository

import ru.kpfu.itis.kmp.core.firebase.FirebaseEvent

interface FirebaseRepository {
    suspend fun logEvent(event: FirebaseEvent)
}
