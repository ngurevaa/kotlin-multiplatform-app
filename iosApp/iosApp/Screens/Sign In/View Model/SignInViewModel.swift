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

    var commonFlow: CommonStateFlow<LoginViewState>

    private var cancellables = Set<AnyCancellable>()

    @Published var loginStates: LoginViewState

    @Published var email = ""
    @Published var password = ""

    @Published var showLoginAlertSuccess = false

    @Published var showEmailAlert = false
    @Published var emailAlertMessage = "Please enter a valid email (e.g., example@mail.com)."

    @Published var showPasswordAlert = false
    @Published var passwordAlertMessage = "Password must be at least 8 characters long and include: 1 uppercase letter, 1 lowercase letter, 1 number, 1 special character (e.g., !@#$%)"

    @Published var isSecure = true


    init(loginCommonViewModel: LoginViewModel) {
        self.loginCommonViewModel = loginCommonViewModel
        self.loginStates = loginCommonViewModel.viewStates.value as! LoginViewState
        commonFlow = loginCommonViewModel.getViewStates()

        publishLoginStateFlow()
    }

    func publishLoginStateFlow() {
        commonStatePublisherFlow(commonFlow)
            .sink { [weak self] newState in
                self?.loginStates = newState
                print("Новое состояние: \(newState)")
            }
            .store(in: &cancellables)
    }

    func doSignIn() {
        if !Validator.isValidEmail(for: email) {
            showEmailAlert = true
            return
        }
        if !Validator.isValidPassword(for: password) {
            showPasswordAlert = true
            return
        }

        let emailEvent = LoginEvent.UpdateEmail(email: email)
        loginCommonViewModel.obtainEvent(event: emailEvent)

        let passwordEvent = LoginEvent.UpdatePassword(password: password)
        loginCommonViewModel.obtainEvent(event: passwordEvent)

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
