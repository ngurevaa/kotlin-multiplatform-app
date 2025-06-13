package ru.kpfu.itis.kmp.feature.home.data.datasource

import ru.kpfu.itis.kmp.feature.home.domain.model.Genre

class PersistenceHomeDatasource {
    fun getGenres() = listOf<Genre>(
        Genre(1, "Fiction"),
        Genre(2, "Science"),
        Genre(3, "Psychology"),
        Genre(4, "Romance"),
        Genre(5, "Horror"),
        Genre(6, "Fantasy"),
        Genre(7, "History")
    )
}
