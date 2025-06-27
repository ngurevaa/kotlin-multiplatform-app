package ru.kpfu.itis.kmp.feature.home.domain.repository

import ru.kpfu.itis.kmp.feature.home.domain.model.Genre

interface GenreRepository {
    suspend fun getGenres(): List<Genre>
}
