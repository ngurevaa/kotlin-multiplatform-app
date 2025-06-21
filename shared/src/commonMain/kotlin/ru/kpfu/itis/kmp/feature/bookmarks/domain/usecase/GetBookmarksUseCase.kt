package ru.kpfu.itis.kmp.feature.bookmarks.domain.usecase

import ru.kpfu.itis.kmp.feature.bookmarks.domain.model.Book

interface GetBookmarksUseCase {
    suspend operator fun invoke(): List<Book>
}
