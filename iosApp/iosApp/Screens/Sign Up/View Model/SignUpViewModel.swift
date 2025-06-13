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

    @Published var registartionStates: RegistrationViewState?


    @Published var email = ""
    @Published var password = ""

    @Published var showLoginAlertSuccess = false

    @Published var isSecure = true

    init(registrationCommonViewModel: RegistrationViewModel) {
        self.registrationCommonViewModel = registrationCommonViewModel

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

    deinit {
        registrationCommonViewModel.onCleared()
    }

}
