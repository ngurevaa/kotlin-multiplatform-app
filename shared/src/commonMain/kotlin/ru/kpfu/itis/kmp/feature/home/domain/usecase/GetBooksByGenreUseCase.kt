package ru.kpfu.itis.kmp.feature.home.domain.usecase

import ru.kpfu.itis.kmp.feature.home.domain.model.Book
import ru.kpfu.itis.kmp.feature.home.domain.model.Genre

interface GetBooksByGenreUseCase {
    suspend operator fun invoke(genre: Genre): List<Book>
}
