//
//  SignUpView.swift
//  iosApp
//
//  Created by Язгуль Хасаншина on 11.06.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI
import shared

struct SignUpView: View {

    @StateObject var viewModel: SignUpViewModel = SignUpViewModel(registrationCommonViewModel: RegistrationViewModel())
    @Environment(\.colorScheme) var colorScheme
    @Environment(\.verticalSizeClass) var verticalSizeClass

    var body: some View {
        ZStack {
            Group {
//                    Горизонтальный экран
                if verticalSizeClass == .compact {
                    ScrollView {
                        content
                            .padding()
                    }
                } else {
//                    Вертикальный экран
                    content
                        .padding()
                }
            }
            .background(AppColors.background(colorScheme))
            .onAppear {
                viewModel.doOpenScreenEvent()
            }

            if viewModel.showToast {
                VStack {
                    Spacer()
                    HStack {
                        ToastAlertView(message: viewModel.toastMessage)
                    }
                    .transition(.move(edge: .bottom).combined(with: .opacity))
                }
                .zIndex(1)
            }
        }
        .animation(.easeInOut, value: viewModel.showToast)
    }

    private var content: some View {
        VStack {
            VStack(spacing: 8) {
                Text("Sign Up")
                    .font(AppFont.medium(size: 28))
                    .foregroundColor(AppColors.text(colorScheme))

                Text("Create your new account")
                    .font(AppFont.medium(size: 22))
                    .foregroundColor(AppColors.text(colorScheme))
            }
            .padding(.top, 110)

            Spacer()

            VStack(alignment: .leading, spacing: 46) {

                // Email
                VStack(alignment: .leading, spacing: 8) {
                    Text("Email")
                        .font(AppFont.regular(size: 14))
                        .foregroundColor(AppColors.text(colorScheme))

                    MainTextfieldView(text: $viewModel.email) {
                        viewModel.doUpdateEmailEvent()
                    }
                }

                // Password
                VStack(alignment: .leading, spacing: 8) {
                    Text("Password")
                        .font(AppFont.regular(size: 14))
                        .foregroundColor(AppColors.text(colorScheme))

                    SecurityMainTextFieldView(text: $viewModel.password, isSecure: $viewModel.isSecure) {
                        viewModel.doUpdatePasswordEvent()
                    }
                }
            }
            .padding(.vertical, 64)

            Spacer()

            VStack(spacing: 20) {
                PrimaryButtonView(title: "Sign Up") {
                    viewModel.doSignUpEvent()
                }

                AuthSwitchLinkView(
                    message: "Already have an account?",
                    linkText: "Login"
                ) {
                    viewModel.openSignInScreen()
                }
            }
            .padding(.bottom, 20)
        }
    }
}


struct SignUpView_Previews: PreviewProvider {
    static var previews: some View {
        SignUpView()
    }
}
