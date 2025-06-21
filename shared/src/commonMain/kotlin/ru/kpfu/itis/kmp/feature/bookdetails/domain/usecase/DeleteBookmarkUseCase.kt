package ru.kpfu.itis.kmp.feature.bookdetails.domain.usecase

interface DeleteBookmarkUseCase {
    suspend operator fun invoke(bookId: String)
}
