package ru.kpfu.itis.kmp.feature.search.data.usecase

import ru.kpfu.itis.kmp.feature.search.domain.model.Book
import ru.kpfu.itis.kmp.feature.search.domain.repository.BookRepository
import ru.kpfu.itis.kmp.feature.search.domain.usecase.SearchBooksByGenreUseCase

class SearchBooksByGenreUseCaseImpl(
    private val bookRepository: BookRepository
) : SearchBooksByGenreUseCase {
    override suspend operator fun invoke(query: String): List<Book> {
        return bookRepository.searchBooksByGenre(query)
    }
}
