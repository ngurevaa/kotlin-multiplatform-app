package ru.kpfu.itis.kmp.feature.auth.data.usecase

import ru.kpfu.itis.kmp.feature.auth.domain.repository.FirebaseAuthRepository
import ru.kpfu.itis.kmp.feature.auth.domain.usecase.SignInUseCase

internal class SignInUseCaseImpl(
    private val firebaseAuthRepository: FirebaseAuthRepository
) : SignInUseCase {
    override suspend operator fun invoke(email: String, password: String) {
        firebaseAuthRepository.signIn(email, password)
    }
}
