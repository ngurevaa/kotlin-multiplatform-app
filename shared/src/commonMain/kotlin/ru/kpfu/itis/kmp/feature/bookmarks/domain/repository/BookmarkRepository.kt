package ru.kpfu.itis.kmp.feature.bookmarks.domain.repository

import ru.kpfu.itis.kmp.feature.bookmarks.domain.model.Book

interface BookmarkRepository {
    suspend fun getBookmarks(): List<Book>
}
