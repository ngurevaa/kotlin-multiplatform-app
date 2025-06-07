package ru.kpfu.itis.kmp.core.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<State : Any, Action, Event>(
    initState: State
) : ViewModel() {
    private val _viewState = MutableStateFlow(initState)
    private val _actions = MutableSharedFlow<Action>()

    protected var viewState: State
        get() = _viewState.value
        set(value) {
            _viewState.value = value
        }

    val viewStates: StateFlow<State>
        get() = _viewState.asStateFlow()

    val actions: SharedFlow<Action> = _actions.asSharedFlow()

    abstract fun obtainEvent(event: Event)

    protected fun sendAction(action: Action) {
        viewModelScope.launch(MainViewModelDispatcher) {
            _actions.emit(action)
        }
    }
}
