package ru.kpfu.itis.kmp.feature.bookmarks.data.datasource

import ru.kpfu.itis.kmp.BookmarkDB
import ru.kpfu.itis.kmp.Database

internal class PersistenceBookmarkDatasource(
    private val database: Database
) {
    fun getAll(): List<BookmarkDB> {
        return database.bookmarkQueries.getAll().executeAsList()
    }
}
