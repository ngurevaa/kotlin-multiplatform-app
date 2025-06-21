package ru.kpfu.itis.kmp.feature.bookdetails.data.usecase

import ru.kpfu.itis.kmp.feature.bookdetails.domain.repository.BookmarkRepository
import ru.kpfu.itis.kmp.feature.bookdetails.domain.usecase.DeleteBookmarkUseCase

class DeleteBookmarkUseCaseImpl(
    private val bookmarkRepository: BookmarkRepository
) : DeleteBookmarkUseCase {
    override suspend fun invoke(bookId: String) {
        bookmarkRepository.deleteBookmark(bookId)
    }
}
