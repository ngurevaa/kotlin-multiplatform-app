//
//  SignInViewModel.swift
//  iosApp
//
//  Created by Язгуль Хасаншина on 11.06.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI
import shared
import Combine

@MainActor
class SignInViewModel: ObservableObject {
    var loginCommonViewModel: LoginViewModel

    var commonStateFlow: CommonStateFlow<LoginViewState>
    var commonActionFlow: CommonFlow<LoginAction>

    private var cancellables = Set<AnyCancellable>()

    @Published var loginStates: LoginViewState?
    @Published var loginActions: LoginAction?

    @Published var email = ""
    @Published var password = ""

    @Published var showLoginAlertSuccess = false

    @Published var isSecure = true


    init(loginCommonViewModel: LoginViewModel) {
        self.loginCommonViewModel = loginCommonViewModel

        commonStateFlow = loginCommonViewModel.getViewStates()
        commonActionFlow = loginCommonViewModel.getActions()

        publishLoginStateFlow()
        publishLoginActionFlow()
    }
//    пока для просмотра состояний
    func publishLoginStateFlow() {
        commonStatePublisherFlow(commonStateFlow)
            .sink { [weak self] newState in
                self?.loginStates = newState
                print("Новое состояние: \(newState)")
            }
            .store(in: &cancellables)
    }
    func publishLoginActionFlow() {
        commonPublisherFlow(commonActionFlow)
            .sink { [weak self] newAction in
                self?.loginActions = newAction
                print("Новое action: \(newAction)")
            }
            .store(in: &cancellables)
    }

    func doUpdateEmailEvent() {
        let emailEvent = LoginEvent.UpdateEmail(email: email)
        loginCommonViewModel.obtainEvent(event: emailEvent)
    }

    func doUpdatePasswordEvent() {
        let passwordEvent = LoginEvent.UpdatePassword(password: password)
        loginCommonViewModel.obtainEvent(event: passwordEvent)
    }

    func doSignInEvent() {
        let signInEvent = LoginEvent.SignIn()
        loginCommonViewModel.obtainEvent(event: signInEvent)
    }

    func openSignUpScreen() {
        UserDefaults.standard.set(true, forKey: "isRegistering")
    }

    deinit {
        loginCommonViewModel.onCleared()
    }

}
