package ru.kpfu.itis.kmp.feature.home.data.usecase

import ru.kpfu.itis.kmp.feature.home.domain.repository.FirebaseRepository
import ru.kpfu.itis.kmp.feature.home.domain.usecase.LogoutUseCase

class LogoutUseCaseImpl(
    private val firebaseRepository: FirebaseRepository
) : LogoutUseCase {
    override operator fun invoke() {
        firebaseRepository.logout()
    }
}
