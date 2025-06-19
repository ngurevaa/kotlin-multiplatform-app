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

class BookDetailsViewModel(
    id: String
) : BaseViewModel<BookDetailsViewState, BookDetailsAction, BookDetailsEvent>(
    initState = BookDetailsViewState()
), KoinComponent {
    private val getBookDetailsUseCase: GetBookDetailsUseCase by inject()

    init {
        viewModelScope.launch {
            runCatching { getBookDetailsUseCase(id) }
                .onSuccess { book ->
                    viewState = viewState.copy(
                        name = book.name,
                        author = book.author,
                        image = book.image,
                        overview = book.overview
                    )
                }
        }
    }

    override fun obtainEvent(event: BookDetailsEvent) {

    }

    fun getViewStates(): CommonStateFlow<BookDetailsViewState> = viewStates.asCommonStateFlow()
    fun getActions(): CommonFlow<BookDetailsAction> = actions.asCommonFlow()
}
