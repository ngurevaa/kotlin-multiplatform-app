package ru.kpfu.itis.kmp.feature.bookmarks.data.usecase

import ru.kpfu.itis.kmp.core.firebase.FirebaseEvent
import ru.kpfu.itis.kmp.feature.bookmarks.domain.repository.FirebaseRepository
import ru.kpfu.itis.kmp.feature.bookmarks.domain.usecase.SendFirebaseEventUseCase

internal class SendFirebaseEventUseCaseImpl(
    private val firebaseRepository: FirebaseRepository
) : SendFirebaseEventUseCase {
    override suspend operator fun invoke(event: FirebaseEvent) {
        firebaseRepository.logEvent(event)
    }
}
