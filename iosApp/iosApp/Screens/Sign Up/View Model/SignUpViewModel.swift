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

    private var cancellables = Set<AnyCancellable>()

    @Published var registartionStates: RegistrationViewState


    @Published var email = ""
    @Published var password = ""

    @Published var showLoginAlertSuccess = false

    @Published var showEmailAlert = false
    @Published var emailAlertMessage = "Please enter a valid email (e.g., example@mail.com)."

    @Published var showPasswordAlert = false
    @Published var passwordAlertMessage = "Password must be at least 8 characters long and include: 1 uppercase letter, 1 lowercase letter, 1 number, 1 special character (e.g., !@#$%)"

    @Published var isSecure = true

    init(registrationCommonViewModel: RegistrationViewModel) {
        self.registrationCommonViewModel = registrationCommonViewModel
        self.registartionStates = registrationCommonViewModel.viewStates.value as! RegistrationViewState
        commonFlow = registrationCommonViewModel.getViewStates()

        publishRegistrationStateFlow()
    }

    func publishRegistrationStateFlow() {
        commonStatePublisherFlow(commonFlow)
            .sink { newState in
                self.registartionStates = newState
                print("Новое состояние: \(newState)")
            }
            .store(in: &cancellables)
    }

    func doSignUp() {
        if !Validator.isValidEmail(for: email) {
            showEmailAlert = true
            return
        }
        if !Validator.isValidPassword(for: password) {
            showPasswordAlert = true
            return
        }

        let emailEvent = RegistrationEvent.UpdateEmail(email: email)
        registrationCommonViewModel.obtainEvent(event: emailEvent)

        let passwordEvent = RegistrationEvent.UpdatePassword(password: password)
        registrationCommonViewModel.obtainEvent(event: passwordEvent)

        let signUpEvent = RegistrationEvent.SignUp()
        registrationCommonViewModel.obtainEvent(event: signUpEvent)
    }

    func openSignInScreen() {
        UserDefaults.standard.set(false, forKey: "isRegistering")
    }

    deinit {
        registrationCommonViewModel.onCleared()
    }

}
