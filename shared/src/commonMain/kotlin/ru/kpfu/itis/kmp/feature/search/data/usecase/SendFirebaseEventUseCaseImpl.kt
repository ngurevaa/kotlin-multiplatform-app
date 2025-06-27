package ru.kpfu.itis.kmp.feature.search.data.usecase

import ru.kpfu.itis.kmp.core.firebase.FirebaseEvent
import ru.kpfu.itis.kmp.feature.search.domain.repository.FirebaseRepository
import ru.kpfu.itis.kmp.feature.search.domain.usecase.SendFirebaseEventUseCase

internal class SendFirebaseEventUseCaseImpl(
    private val firebaseRepository: FirebaseRepository
) : SendFirebaseEventUseCase {
    override suspend fun invoke(event: FirebaseEvent) {
        firebaseRepository.logEvent(event)
    }
}
