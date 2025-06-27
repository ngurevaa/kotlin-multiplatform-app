package ru.kpfu.itis.kmp.feature.bookdetails.data.usecase

import ru.kpfu.itis.kmp.feature.bookdetails.domain.model.Book
import ru.kpfu.itis.kmp.feature.bookdetails.domain.repository.BookmarkRepository
import ru.kpfu.itis.kmp.feature.bookdetails.domain.usecase.SaveBookmarkUseCase

internal class SaveBookmarkUseCaseImpl(
    private val bookmarkRepository: BookmarkRepository
) : SaveBookmarkUseCase {
    override suspend operator fun invoke(book: Book) {
        bookmarkRepository.saveBookmark(book)
    }
}
