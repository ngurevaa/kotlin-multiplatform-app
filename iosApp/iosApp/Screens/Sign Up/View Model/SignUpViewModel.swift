//
//  SignUpViewModel.swift
//  iosApp
//
//  Created by Язгуль Хасаншина on 11.06.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI
import shared
import Combine

@MainActor
class SignUpViewModel: ObservableObject {
    var registrationCommonViewModel: RegistrationViewModel

    var commonFlow: CommonStateFlow<RegistrationViewState>
    var commonActionFlow: CommonFlow<RegistrationAction>

    private var cancellables = Set<AnyCancellable>()

    @Published var registartionStates: RegistrationViewState?
    @Published var registrationActions: RegistrationAction?

    @Published var email = ""
    @Published var password = ""

    @Published var showToast: Bool = false
    var toastMessage: String = ""

    @Published var isSecure = true

    init(registrationCommonViewModel: RegistrationViewModel) {
        self.registrationCommonViewModel = registrationCommonViewModel

        commonFlow = registrationCommonViewModel.getViewStates()
        commonActionFlow = registrationCommonViewModel.getActions()

        publishRegistrationStateFlow()
        publishLoginActionFlow()
    }

    func publishRegistrationStateFlow() {
        commonStatePublisherFlow(commonFlow)
            .sink { newState in
                self.registartionStates = newState
            }
            .store(in: &cancellables)
    }
    func publishLoginActionFlow() {
        commonPublisherFlow(commonActionFlow)
            .sink { [weak self] newAction in
                self?.registrationActions = newAction
                self?.doActionOption(action: newAction)
                print("Новое action: \(newAction)")
            }
            .store(in: &cancellables)
    }

    func doUpdateEmailEvent() {
        let emailEvent = RegistrationEvent.UpdateEmail(email: email)
        registrationCommonViewModel.obtainEvent(event: emailEvent)
    }

    func doUpdatePasswordEvent() {
        let passwordEvent = RegistrationEvent.UpdatePassword(password: password)
        registrationCommonViewModel.obtainEvent(event: passwordEvent)
    }

    func doSignUpEvent() {
        let signUpEvent = RegistrationEvent.SignUp()
        registrationCommonViewModel.obtainEvent(event: signUpEvent)
    }
    
    func openSignInScreen() {
        UserDefaults.standard.set(false, forKey: "isRegistering")
    }

    func openHomeScreen() {
        UserDefaults.standard.set(true, forKey: "isLoggedIn")
    }

    func doActionOption(action: RegistrationAction) {
        if (action.isEqual(RegistrationAction.ShowEmailError())) {
            showToastForSeconds(message: AlertMessage.emailIncorrectError, seconds: 2)
        }
        
        if (action.isEqual(RegistrationAction.ShowPasswordError())) {
            showToastForSeconds(message: AlertMessage.passwordIncorrectError, seconds: 2)
        }

        if (action.isEqual(RegistrationAction.ShowInternetConnectionError())) {
            showToastForSeconds(message: AlertMessage.internetConnectionError, seconds: 2)
        }

        if (action.isEqual(RegistrationAction.NavigateToHome())) {
            openHomeScreen()
        }
    }

    func showToastForSeconds(message: String, seconds: Int) {
        toastMessage = message
        showToast = true

        Task {
            try? await Task.sleep(nanoseconds: UInt64(seconds) * 1_000_000_000)
            showToast = false
        }
    }

    deinit {
        registrationCommonViewModel.onCleared()
    }

}
