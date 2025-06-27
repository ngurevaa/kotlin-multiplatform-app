package ru.kpfu.itis.kmp.feature.home.data.usecase

import ru.kpfu.itis.kmp.feature.home.domain.model.Book
import ru.kpfu.itis.kmp.feature.home.domain.model.Genre
import ru.kpfu.itis.kmp.feature.home.domain.repository.BookRepository
import ru.kpfu.itis.kmp.feature.home.domain.usecase.GetBooksByGenreUseCase

internal class GetBooksByGenreUseCaseImpl(
    private val bookRepository: BookRepository
) : GetBooksByGenreUseCase {
    override suspend operator fun invoke(genre: Genre): List<Book> {
        return bookRepository.getBooksByGenre(genre)
    }
}
