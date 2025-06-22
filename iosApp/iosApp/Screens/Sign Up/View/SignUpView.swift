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

    var body: some View {
        ZStack {
            VStack {

                VStack(spacing: 8) {
                    Text("Sign Up")
                        .font(AppFont.medium(size: 28))
                        .foregroundColor(.black)

                    Text("Create your new account")
                        .font(AppFont.medium(size: 22))
                        .foregroundColor(.black)
                }
                .padding(.top, 110)

                Spacer()

                VStack(alignment: .leading, spacing: 46) {

                    // Email
                    VStack(alignment: .leading, spacing: 8) {
                        Text("Email")
                            .font(AppFont.regular(size: 14))
                            .foregroundColor(.black)

                        TextField("", text: $viewModel.email)
                            .foregroundColor(.black)
                            .textInputAutocapitalization(.never)
                            .padding()
                            .frame(height: 38)
                            .background(Color.dataTextfieldColor)
                            .cornerRadius(10)
                            .onChange(of: viewModel.email) { newEmail in
                                viewModel.doUpdateEmailEvent()
                            }
                    }

                    // Password
                    VStack(alignment: .leading, spacing: 8) {
                        Text("Password")
                            .font(AppFont.regular(size: 14))
                            .foregroundColor(.black)

                        HStack {
                            if viewModel.isSecure {
                                SecureField("", text: $viewModel.password)
                            } else {
                                TextField("", text: $viewModel.password)
                            }

                            Button(action: {
                                viewModel.isSecure.toggle()
                            }) {
                                Image(systemName: viewModel.isSecure ? "eye.slash" : "eye")
                                    .foregroundColor(.black)
                            }
                        }
                        .foregroundColor(.black)
                        .textInputAutocapitalization(.never)
                        .padding()
                        .frame(height: 38)
                        .background(Color.dataTextfieldColor)
                        .cornerRadius(10)
                        .onChange(of: viewModel.password) { newPassword in
                            viewModel.doUpdatePasswordEvent()
                        }
                    }

                }

                Spacer()

                VStack(spacing: 20) {
                    Button(action: {
                        viewModel.doSignUpEvent()
                    }) {
                        Text("Sign Up")
                            .font(AppFont.medium(size: 20))
                            .foregroundColor(.white)
                            .padding()
                            .frame(maxWidth: .infinity)
                            .frame(height: 38)
                            .background(Color(hex: Colors.shared.primaryLight))
                            .cornerRadius(10)
                    }

                    HStack {
                        Text("Already have an account?")
                            .font(AppFont.regular(size: 14))

                        Button(action: {
                            viewModel.openSignInScreen()
                        }) {
                            Text("Login")
                                .underline()
                                .font(AppFont.regular(size: 14))
                        }
                    }
                    .foregroundColor(.black)
                }
                .padding(.bottom, 20)
            }
            .padding()
            .background(Color(hex: Colors.shared.backgroundLight))

//            Алерт (Toast) оповещение
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

}

struct SignUpView_Previews: PreviewProvider {
    static var previews: some View {
        SignUpView()
    }
}
