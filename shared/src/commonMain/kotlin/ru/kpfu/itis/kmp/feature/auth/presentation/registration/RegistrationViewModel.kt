package ru.kpfu.itis.kmp.feature.auth.presentation.registration

import CommonFlow
import CommonStateFlow
import androidx.lifecycle.viewModelScope
import asCommonFlow
import asCommonStateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import ru.kpfu.itis.kmp.core.viewmodel.BaseViewModel
import ru.kpfu.itis.kmp.feature.auth.domain.usecase.SignUpUseCase
import ru.kpfu.itis.kmp.feature.auth.presentation.login.LoginAction
import kotlin.getValue

class RegistrationViewModel : BaseViewModel<RegistrationViewState, RegistrationAction, RegistrationEvent>(
    initState = RegistrationViewState()
), KoinComponent {
    private val signUpUseCase: SignUpUseCase by inject()

    override fun obtainEvent(event: RegistrationEvent) {
        when (event) {
            is RegistrationEvent.SignUp -> signUp()
            is RegistrationEvent.UpdateEmail -> updateEmail(event.email)
            is RegistrationEvent.UpdatePassword -> updatePassword(event.password)
            is RegistrationEvent.ClickLoginReference -> clickLoginReference()
        }
    }

    private fun clickLoginReference() {
        sendAction(RegistrationAction.NavigateToLogin)
    }

    private fun signUp() {
        viewModelScope.launch {
            runCatching {
                signUpUseCase(viewState.email, viewState.password)
            }
            .onSuccess {
                // action navigate to home screen
            }
            .onFailure {
                sendAction(RegistrationAction.ShowError)
            }
        }
    }

    private fun updateEmail(email: String) {
        viewState = viewState.copy(email = email)
    }

    private fun updatePassword(password: String) {
        viewState = viewState.copy(password = password)
    }

    fun getViewStates(): CommonStateFlow<RegistrationViewState> = viewStates.asCommonStateFlow()
    fun getActions(): CommonFlow<RegistrationAction> = actions.asCommonFlow()
}
