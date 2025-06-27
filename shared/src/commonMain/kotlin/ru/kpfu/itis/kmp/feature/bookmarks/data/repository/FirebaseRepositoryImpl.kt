package ru.kpfu.itis.kmp.feature.bookmarks.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext
import ru.kpfu.itis.kmp.core.firebase.AnalyticsService
import ru.kpfu.itis.kmp.core.firebase.FirebaseEvent
import ru.kpfu.itis.kmp.feature.bookmarks.domain.repository.FirebaseRepository

internal class FirebaseRepositoryImpl(
    private val analyticsService: AnalyticsService
) : FirebaseRepository {
    override suspend fun logEvent(event: FirebaseEvent) {
        withContext(Dispatchers.IO) {
            analyticsService.logFirebaseEvent(event)
        }
    }
}
