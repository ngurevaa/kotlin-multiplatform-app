package ru.kpfu.itis.kmp.core.designsystem

import CommonStateFlow
import asCommonStateFlow
import ru.kpfu.itis.kmp.core.viewmodel.BaseViewModel

class ThemeViewModel : BaseViewModel<ThemeViewState, Nothing, ThemeEvent>(
    initState = ThemeViewState()
){
    override fun obtainEvent(event: ThemeEvent) {
        when(event) {
            is ThemeEvent.ChangeTheme -> changeTheme(event.isDarkTheme)
        }
    }

    private fun changeTheme(isDarkTheme: Boolean) {
        viewState = viewState.copy(isDarkTheme = isDarkTheme)
    }

    fun getViewStates(): CommonStateFlow<ThemeViewState> = viewStates.asCommonStateFlow()
}
