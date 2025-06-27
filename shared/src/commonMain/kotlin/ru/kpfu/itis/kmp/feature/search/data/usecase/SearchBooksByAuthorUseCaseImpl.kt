package ru.kpfu.itis.kmp.feature.search.data.usecase

import ru.kpfu.itis.kmp.feature.search.domain.model.Book
import ru.kpfu.itis.kmp.feature.search.domain.repository.BookRepository
import ru.kpfu.itis.kmp.feature.search.domain.usecase.SearchBooksByAuthorUseCase

internal class SearchBooksByAuthorUseCaseImpl(
    private val bookRepository: BookRepository
) : SearchBooksByAuthorUseCase {
    override suspend operator fun invoke(query: String): List<Book> {
        return bookRepository.searchBooksByAuthor(query)
    }
}
