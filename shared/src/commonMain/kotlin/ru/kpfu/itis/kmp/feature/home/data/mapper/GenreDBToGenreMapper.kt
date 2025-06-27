package ru.kpfu.itis.kmp.feature.home.data.mapper

import ru.kpfu.itis.kmp.GenreDB
import ru.kpfu.itis.kmp.feature.home.domain.model.Genre

fun GenreDB.mapToGenre(): Genre {
    return Genre(
        id = id,
        name = name
    )
}

fun List<GenreDB>.mapToGenreList(): List<Genre> {
    return map {
        it.mapToGenre()
    }
}
