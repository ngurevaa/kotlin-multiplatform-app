package ru.kpfu.itis.kmp.feature.search.presentation

import androidx.compose.runtime.Immutable
import ru.kpfu.itis.kmp.feature.search.domain.model.Book

@Immutable
data class SearchViewState(
    val search: String = "",
    val isLoading: Boolean = false,
    val books: List<Book> = listOf(),
    val filters: List<Filter> = listOf(Filter.Title, Filter.Author, Filter.Genre),
    val selectedFilter: Filter = Filter.Title
)

enum class Filter {
    Title, Author, Genre
}
