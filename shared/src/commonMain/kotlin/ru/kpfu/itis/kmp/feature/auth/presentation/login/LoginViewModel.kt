package ru.kpfu.itis.kmp.feature.auth.presentation.login

import CommonStateFlow
import asCommonStateFlow
import org.koin.core.component.KoinComponent
import ru.kpfu.itis.kmp.core.viewmodel.BaseViewModel

class LoginViewModel : BaseViewModel<LoginViewState, LoginAction, LoginEvent>(
    initState = LoginViewState()
), KoinComponent {
//    private val signInUseCase: SignInUseCase by inject()

    override fun obtainEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.SignIn -> signIn()
            is LoginEvent.UpdateEmail -> updateEmail(event.email)
            is LoginEvent.UpdatePassword -> updatePassword(event.password)
        }
    }

    private fun signIn() {
        // call firebase sign in use case
    }

    private fun updateEmail(email: String) {
        viewState = viewState.copy(email = email)
    }

    private fun updatePassword(password: String) {
        viewState = viewState.copy(password = password)
    }

    fun getViewStates(): CommonStateFlow<LoginViewState> = viewStates.asCommonStateFlow()
}
