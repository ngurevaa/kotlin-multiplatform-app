package ru.kpfu.itis.kmp.feature.bookdetails.domain.usecase

import ru.kpfu.itis.kmp.core.firebase.FirebaseEvent

interface SendFirebaseEventUseCase {
    suspend operator fun invoke(event: FirebaseEvent)
}
