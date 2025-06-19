package ru.kpfu.itis.kmp.feature.bookdetails.presentation

import CommonFlow
import CommonStateFlow
import androidx.lifecycle.viewModelScope
import asCommonFlow
import asCommonStateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import ru.kpfu.itis.kmp.core.viewmodel.BaseViewModel
import ru.kpfu.itis.kmp.feature.bookdetails.domain.usecase.GetBookDetailsUseCase

class BookDetailsViewModel() : BaseViewModel<BookDetailsViewState, BookDetailsAction, BookDetailsEvent>(
    initState = BookDetailsViewState()
), KoinComponent {
    private val getBookDetailsUseCase: GetBookDetailsUseCase by inject()

    override fun obtainEvent(event: BookDetailsEvent) {
        when(event) {
            is BookDetailsEvent.LoadBook -> loadBook(event.id)
            BookDetailsEvent.ClearBook -> clearBook()
        }
    }

    private fun clearBook() {
        viewState = viewState.copy(isLoading = true)
    }

    private fun loadBook(id: String) {
        viewModelScope.launch {
            runCatching {
                getBookDetailsUseCase(id)
            }
                .onSuccess { book ->
                    viewState = viewState.copy(
                        name = book.name,
                        author = book.author,
                        image = book.image,
                        overview = book.overview,
                        isLoading = false
                    )
                }
        }
    }

    fun getViewStates(): CommonStateFlow<BookDetailsViewState> = viewStates.asCommonStateFlow()
    fun getActions(): CommonFlow<BookDetailsAction> = actions.asCommonFlow()
}
