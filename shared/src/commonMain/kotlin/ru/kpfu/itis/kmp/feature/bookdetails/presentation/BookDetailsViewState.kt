package ru.kpfu.itis.kmp.feature.bookdetails.presentation

import androidx.compose.runtime.Immutable

@Immutable
data class BookDetailsViewState(
    val name: String = "",
    val author: String = "",
    val image: String = "",
    val overview: String = "",
    val isBookmarked: Boolean = false,
    val isLoading: Boolean = true
)
