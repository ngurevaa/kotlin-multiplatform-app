package ru.kpfu.itis.kmp.feature.bookdetails.domain.model

data class Book(
    val id: String = "",
    val name: String = "",
    val author: String = "",
    val image: String = "",
    val overview: String = "",
    val isBookmarked: Boolean = false
)
