package ru.kpfu.itis.kmp.feature.search.data.usecase

import ru.kpfu.itis.kmp.feature.search.domain.model.Book
import ru.kpfu.itis.kmp.feature.search.domain.repository.BookRepository
import ru.kpfu.itis.kmp.feature.search.domain.usecase.SearchBooksByTitleUseCase

class SearchBooksByTitleUseCaseImpl(
    private val bookRepository: BookRepository
) : SearchBooksByTitleUseCase {
    override suspend operator fun invoke(query: String): List<Book> {
        return bookRepository.searchBooksByTitle(query)
    }
}
