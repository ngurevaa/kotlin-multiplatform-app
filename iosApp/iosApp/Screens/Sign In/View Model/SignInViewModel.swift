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

    @Published var isSecure = true

    @Published var showToast: Bool = false
    var toastMessage: String = ""


    init(loginCommonViewModel: LoginViewModel) {
        self.loginCommonViewModel = loginCommonViewModel

        commonStateFlow = loginCommonViewModel.getViewStates()
        commonActionFlow = loginCommonViewModel.getActions()

        publishLoginStateFlow()
        publishLoginActionFlow()
    }

    func publishLoginStateFlow() {
        commonStatePublisherFlow(commonStateFlow)
            .sink { [weak self] newState in
                self?.loginStates = newState
            }
            .store(in: &cancellables)
    }
    func publishLoginActionFlow() {
        commonPublisherFlow(commonActionFlow)
            .sink { [weak self] newAction in
                self?.loginActions = newAction
                self?.doActionOption(action: newAction)
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

    func doOpenScreenEvent() {
        let signInEvent = LoginEvent.OpenScreen()
        loginCommonViewModel.obtainEvent(event: signInEvent)
    }

    func openSignUpScreen() {
        UserDefaults.standard.set(true, forKey: "isRegistering")
    }


    func openHomeScreen() {
        UserDefaults.standard.set(true, forKey: "isLoggedIn")
    }

    func doActionOption(action: LoginAction) {
        if (action.isEqual(LoginAction.NavigateToHome())) {
            openHomeScreen()
        }
        if (action.isEqual(LoginAction.ShowLoginError())) {
            showToastForSeconds(message: AlertMessage.loginInvalidError, seconds: 2)
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
        loginCommonViewModel.onCleared()
    }

}
