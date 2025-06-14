package ru.kpfu.itis.kmp.feature.home.data.usecase

import ru.kpfu.itis.kmp.feature.home.domain.model.Genre
import ru.kpfu.itis.kmp.feature.home.domain.repository.HomeRepository
import ru.kpfu.itis.kmp.feature.home.domain.usecase.GetGenresUseCase

class GetGenresUseCaseImpl(
    private val homeRepository: HomeRepository
) : GetGenresUseCase {
    override suspend operator fun invoke(): List<Genre> {
        return homeRepository.getGenres()
    }
}
