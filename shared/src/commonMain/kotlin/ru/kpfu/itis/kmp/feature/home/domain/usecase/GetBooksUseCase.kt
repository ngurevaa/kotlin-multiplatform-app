package ru.kpfu.itis.kmp.feature.home.domain.usecase

import ru.kpfu.itis.kmp.feature.home.domain.model.Book
import ru.kpfu.itis.kmp.feature.home.domain.model.Genre

interface GetBooksUseCase {
    suspend operator fun invoke(genres: List<Genre>): Map<Genre, List<Book>>
}
