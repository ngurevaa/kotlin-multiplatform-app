package ru.kpfu.itis.kmp.feature.home.data.usecase

import ru.kpfu.itis.kmp.feature.home.domain.model.Genre
import ru.kpfu.itis.kmp.feature.home.domain.repository.GenreRepository
import ru.kpfu.itis.kmp.feature.home.domain.usecase.GetGenresUseCase

internal class GetGenresUseCaseImpl(
    private val genreRepository: GenreRepository
) : GetGenresUseCase {
    override suspend operator fun invoke(): List<Genre> {
        return genreRepository.getGenres()
    }
}
