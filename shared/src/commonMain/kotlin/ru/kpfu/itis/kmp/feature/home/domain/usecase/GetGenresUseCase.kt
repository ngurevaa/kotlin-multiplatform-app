package ru.kpfu.itis.kmp.feature.home.domain.usecase

import ru.kpfu.itis.kmp.feature.home.domain.model.Genre

interface GetGenresUseCase {
    suspend operator fun invoke(): List<Genre>
}
