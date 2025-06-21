package ru.kpfu.itis.kmp.feature.bookdetails.presentation

data class BookDetailsViewState(
    val name: String = "",
    val author: String = "",
    val image: String = "",
    val overview: String = "",
    val isBookmarked: Boolean = false,
    val isLoading: Boolean = true
)
