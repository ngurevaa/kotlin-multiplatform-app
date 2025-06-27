package ru.kpfu.itis.kmp.feature.auth.data.usecase

import ru.kpfu.itis.kmp.feature.auth.domain.repository.FirebaseRepository
import ru.kpfu.itis.kmp.feature.auth.domain.usecase.SignUpUseCase

internal class SignUpUseCaseImpl(
    private val firebaseRepository: FirebaseRepository
) : SignUpUseCase {
    override suspend operator fun invoke(email: String, password: String) {
        firebaseRepository.signUp(email, password)
    }
}
