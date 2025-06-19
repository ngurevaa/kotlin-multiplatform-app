package ru.kpfu.itis.kmp.feature.bookdetails.presentation

import CommonFlow
import CommonStateFlow
import asCommonFlow
import asCommonStateFlow
import org.koin.core.component.KoinComponent
import ru.kpfu.itis.kmp.core.viewmodel.BaseViewModel

class BookDetailsViewModel : BaseViewModel<BookDetailsViewState, BookDetailsAction, BookDetailsEvent>(
    initState = BookDetailsViewState()
), KoinComponent {

    override fun obtainEvent(event: BookDetailsEvent) {

    }

    fun getViewStates(): CommonStateFlow<BookDetailsViewState> = viewStates.asCommonStateFlow()
    fun getActions(): CommonFlow<BookDetailsAction> = actions.asCommonFlow()
}
