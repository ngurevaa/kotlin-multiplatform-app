package ru.kpfu.itis.kmp.feature.home.presentation

import ru.kpfu.itis.kmp.feature.home.domain.model.Book
import ru.kpfu.itis.kmp.feature.home.domain.model.Genre
import androidx.compose.runtime.Immutable

@Immutable
data class HomeViewState(
    val genres: List<Genre> = listOf(),
    val currentGenre: Genre = Genre(0, ""),
    val books: Map<Genre, List<Book>> = mapOf(),
    val isLoading: Boolean = false
)
