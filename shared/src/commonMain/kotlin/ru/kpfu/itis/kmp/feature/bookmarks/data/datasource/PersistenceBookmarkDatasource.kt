package ru.kpfu.itis.kmp.feature.bookmarks.data.datasource

import ru.kpfu.itis.kmp.Bookmark
import ru.kpfu.itis.kmp.Database

class PersistenceBookmarkDatasource(
    private val database: Database
) {
    fun getAll(): List<Bookmark> {
        return database.bookmarkQueries.getAll().executeAsList()
    }
}
