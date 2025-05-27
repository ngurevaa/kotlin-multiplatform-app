package ru.kpfu.itis.kmp.feature.auth.data.usecase

import ru.kpfu.itis.kmp.feature.auth.domain.repository.FirebaseAuthRepository
import ru.kpfu.itis.kmp.feature.auth.domain.usecase.SignUpUseCase

class SignUpUseCaseImpl(
    private val firebaseAuthRepository: FirebaseAuthRepository
) : SignUpUseCase {
    override suspend operator fun invoke(email: String, password: String) {
        firebaseAuthRepository.signUp(email, password)
    }
}
