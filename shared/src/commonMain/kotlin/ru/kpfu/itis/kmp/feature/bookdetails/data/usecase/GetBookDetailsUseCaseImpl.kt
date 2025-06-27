package ru.kpfu.itis.kmp.feature.bookdetails.data.usecase

import ru.kpfu.itis.kmp.feature.bookdetails.domain.model.Book
import ru.kpfu.itis.kmp.feature.bookdetails.domain.repository.BookRepository
import ru.kpfu.itis.kmp.feature.bookdetails.domain.repository.BookmarkRepository
import ru.kpfu.itis.kmp.feature.bookdetails.domain.usecase.GetBookDetailsUseCase

internal class GetBookDetailsUseCaseImpl(
    private val bookRepository: BookRepository,
    private val bookmarkRepository: BookmarkRepository
) : GetBookDetailsUseCase {
    override suspend operator fun invoke(id: String): Book {
        var book = bookRepository.getBookDetails(id)
        book = book.copy(isBookmarked = bookmarkRepository.isBookmark(id))
        return book
    }
}
