package ru.kpfu.itis.kmp.feature.auth.presentation.login

import CommonFlow
import CommonStateFlow
import androidx.lifecycle.viewModelScope
import asCommonFlow
import asCommonStateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import ru.kpfu.itis.kmp.core.firebase.FirebaseEvent
import ru.kpfu.itis.kmp.core.viewmodel.BaseViewModel
import ru.kpfu.itis.kmp.feature.auth.domain.usecase.SendFirebaseEventUseCase
import ru.kpfu.itis.kmp.feature.auth.domain.usecase.SignInUseCase

class LoginViewModel : BaseViewModel<LoginViewState, LoginAction, LoginEvent>(
    initState = LoginViewState()
), KoinComponent {
    private val signInUseCase: SignInUseCase by inject()
    private val sendFirebaseEventUseCase: SendFirebaseEventUseCase by inject()

    override fun obtainEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.SignIn -> signIn()
            is LoginEvent.UpdateEmail -> updateEmail(event.email)
            is LoginEvent.UpdatePassword -> updatePassword(event.password)
            is LoginEvent.ClickRegistrationReference -> clickRegistrationReference()
            is LoginEvent.OpenScreen -> openScreen()
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

    private fun clickRegistrationReference() {
        sendAction(LoginAction.NavigateToRegistration)
    }

    private fun signIn() {
        viewModelScope.launch {
            runCatching {
                signInUseCase(viewState.email, viewState.password)
            }
            .onSuccess {
                sendAction(LoginAction.NavigateToHome)
            }
            .onFailure {
                sendAction(LoginAction.ShowLoginError)
            }
        }
    }

    private fun updateEmail(email: String) {
        viewState = viewState.copy(email = email)
    }

    private fun updatePassword(password: String) {
        viewState = viewState.copy(password = password)
    }

    fun getViewStates(): CommonStateFlow<LoginViewState> = viewStates.asCommonStateFlow()
    fun getActions(): CommonFlow<LoginAction> = actions.asCommonFlow()

    companion object {
        private const val SCREEN_NAME = "login"
    }
}
