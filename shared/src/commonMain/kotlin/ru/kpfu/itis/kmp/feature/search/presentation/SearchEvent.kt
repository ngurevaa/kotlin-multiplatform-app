package ru.kpfu.itis.kmp.feature.search.presentation

sealed class SearchEvent {
    data class UpdateSearch(val search: String) : SearchEvent()
    data object Search : SearchEvent()
    data class SelectFilter(val filter: Filter) : SearchEvent()
    data class ClickToBook(val id: String) : SearchEvent()
}
