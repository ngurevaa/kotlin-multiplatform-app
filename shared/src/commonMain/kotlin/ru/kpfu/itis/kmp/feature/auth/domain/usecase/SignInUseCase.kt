package ru.kpfu.itis.kmp.feature.auth.domain.usecase

interface SignInUseCase {
    suspend operator fun invoke(email: String, password: String)
}
