package ru.kpfu.itis.kmp.feature.home.presentation

import ru.kpfu.itis.kmp.feature.home.domain.model.Book
import ru.kpfu.itis.kmp.feature.home.domain.model.Genre

data class HomeViewState(
    val genres: List<Genre> = listOf(),
    val books: Map<Genre, List<Book>> = mapOf()
)
