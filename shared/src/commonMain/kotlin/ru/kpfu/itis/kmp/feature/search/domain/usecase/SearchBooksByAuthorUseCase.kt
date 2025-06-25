package ru.kpfu.itis.kmp.feature.search.domain.usecase

import ru.kpfu.itis.kmp.feature.search.domain.model.Book

interface SearchBooksByAuthorUseCase {
    suspend operator fun invoke(query: String): List<Book>
}
