package ru.kpfu.itis.kmp.feature.home.data.usecase

import ru.kpfu.itis.kmp.feature.home.domain.model.Book
import ru.kpfu.itis.kmp.feature.home.domain.model.Genre
import ru.kpfu.itis.kmp.feature.home.domain.repository.HomeRepository
import ru.kpfu.itis.kmp.feature.home.domain.usecase.GetBooksUseCase

class GetBooksUseCaseImpl(
    private val homeRepository: HomeRepository
) : GetBooksUseCase {
    override suspend operator fun invoke(genres: List<Genre>): Map<Genre, List<Book>> {
        val books = mutableMapOf<Genre, List<Book>>()
        for (genre in genres) {
            books.put(genre, homeRepository.getBooksByGenre(genre))
        }
        return books
    }
}
