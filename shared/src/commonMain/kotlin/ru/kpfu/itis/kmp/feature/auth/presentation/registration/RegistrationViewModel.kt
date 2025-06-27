package ru.kpfu.itis.kmp.feature.auth.presentation.registration

import CommonFlow
import CommonStateFlow
import androidx.lifecycle.viewModelScope
import asCommonFlow
import asCommonStateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import ru.kpfu.itis.kmp.core.firebase.FirebaseEvent
import ru.kpfu.itis.kmp.core.util.FieldValidator
import ru.kpfu.itis.kmp.core.viewmodel.BaseViewModel
import ru.kpfu.itis.kmp.feature.auth.domain.usecase.SendFirebaseEventUseCase
import ru.kpfu.itis.kmp.feature.auth.domain.usecase.SignUpUseCase

class RegistrationViewModel : BaseViewModel<RegistrationViewState, RegistrationAction, RegistrationEvent>(
    initState = RegistrationViewState()
), KoinComponent {
    private val signUpUseCase: SignUpUseCase by inject()
    private val sendFirebaseEventUseCase: SendFirebaseEventUseCase by inject()

    override fun obtainEvent(event: RegistrationEvent) {
        when (event) {
            is RegistrationEvent.SignUp -> signUp()
            is RegistrationEvent.UpdateEmail -> updateEmail(event.email)
            is RegistrationEvent.UpdatePassword -> updatePassword(event.password)
            is RegistrationEvent.ClickLoginReference -> clickLoginReference()
            is RegistrationEvent.OpenScreen -> openScreen()
        }
    }

    private fun openScreen() {
        viewModelScope.launch {
            sendFirebaseEventUseCase(
                FirebaseEvent(
                    name = FirebaseEvent.NAME_OPEN_SCREEN,
                    params = mapOf(FirebaseEvent.PARAM_SCREEN_NAME to SCREEN_NAME)
                )
            )
        }
    }

    private fun clickLoginReference() {
        sendAction(RegistrationAction.NavigateToLogin)
    }

    private fun signUp() {
        if (!FieldValidator.isValidEmail(viewState.email)) {
            sendAction(RegistrationAction.ShowEmailError)
            return
        }
        if (!FieldValidator.isValidPassword(viewState.password)) {
            sendAction(RegistrationAction.ShowPasswordError)
            return
        }

        viewModelScope.launch {
            runCatching {
                signUpUseCase(viewState.email, viewState.password)
            }
            .onSuccess {
                sendAction(RegistrationAction.NavigateToHome)
            }
            .onFailure {
                sendAction(RegistrationAction.ShowInternetConnectionError)
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

    companion object {
        private const val SCREEN_NAME = "registration"
    }
}
