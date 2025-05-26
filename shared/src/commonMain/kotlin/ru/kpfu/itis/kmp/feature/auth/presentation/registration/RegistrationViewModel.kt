package ru.kpfu.itis.kmp.feature.auth.presentation.registration

import CommonStateFlow
import asCommonStateFlow
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import ru.kpfu.itis.kmp.core.viewmodel.BaseViewModel
import ru.kpfu.itis.kmp.feature.domain.usecase.SaveBookUseCase
import kotlin.getValue

class RegistrationViewModel : BaseViewModel<RegistrationViewState, RegistrationAction, RegistrationEvent>(
    initState = RegistrationViewState()
), KoinComponent {
//    private val signUpUseCase: SignUpUseCase by inject()

    override fun obtainEvent(event: RegistrationEvent) {
        when (event) {
            is RegistrationEvent.SignUp -> signUp()
            is RegistrationEvent.UpdateEmail -> updateEmail(event.email)
            is RegistrationEvent.UpdatePassword -> updatePassword(event.password)
        }
    }

    private fun signUp() {
        // call firebase sign up use case
    }

    private fun updateEmail(email: String) {
        viewState = viewState.copy(email = email)
    }

    private fun updatePassword(password: String) {
        viewState = viewState.copy(password = password)
    }

    fun getViewStates(): CommonStateFlow<RegistrationViewState> = viewStates.asCommonStateFlow()
}
