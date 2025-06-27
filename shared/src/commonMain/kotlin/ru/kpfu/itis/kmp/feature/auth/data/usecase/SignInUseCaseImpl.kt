package ru.kpfu.itis.kmp.feature.auth.data.usecase

import ru.kpfu.itis.kmp.feature.auth.domain.repository.FirebaseRepository
import ru.kpfu.itis.kmp.feature.auth.domain.usecase.SignInUseCase

internal class SignInUseCaseImpl(
    private val firebaseRepository: FirebaseRepository
) : SignInUseCase {
    override suspend operator fun invoke(email: String, password: String) {
        firebaseRepository.signIn(email, password)
    }
}
