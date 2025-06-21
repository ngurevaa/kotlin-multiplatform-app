package ru.kpfu.itis.kmp.feature.bookmarks.data.usecase

import ru.kpfu.itis.kmp.feature.bookmarks.domain.model.Book
import ru.kpfu.itis.kmp.feature.bookmarks.domain.repository.BookmarksRepository
import ru.kpfu.itis.kmp.feature.bookmarks.domain.usecase.GetBookmarksUseCase

class GetBookmarksUseCaseImpl(
    private val bookmarksRepository: BookmarksRepository
) : GetBookmarksUseCase {
    override suspend fun invoke(): List<Book> {
        return bookmarksRepository.getBookmarks()
    }
}
