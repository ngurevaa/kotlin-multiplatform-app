import SwiftUI
import shared

struct SignInView: View {
    @StateObject var viewModel: SignInViewModel = SignInViewModel(loginCommonViewModel: LoginViewModel())

    var body: some View {
        ZStack {
            VStack {

                VStack(spacing: 8) {
                    Text("Sign In")
                        .font(AppFont.medium(size: 28))
                        .foregroundColor(.black)

                    Text("Enter into your account")
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
                        .textInputAutocapitalization(.never)
                        .foregroundColor(.black)
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
                        viewModel.doSignInEvent()
                    }) {
                        Text("Sign In")
                            .font(AppFont.medium(size: 20))
                            .foregroundColor(.white)
                            .padding()
                            .frame(maxWidth: .infinity)
                            .frame(height: 38)
                            .background(Color(hex: Colors.shared.primaryLight))
                            .cornerRadius(10)
                    }

                    HStack {
                        Text("Do not have an account?")
                            .font(AppFont.regular(size: 14))

                        Button(action: {
                            viewModel.openSignUpScreen()
                        }) {
                            Text("Register")
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
            .ignoresSafeArea(edges: .bottom)


            if viewModel.showToast {
                VStack {
                    Spacer()
                    HStack {
                        ToastAlertView(message: viewModel.toastMessage)
                    }
                    .transition(.move(edge: .bottom).combined(with: .opacity))
                    .padding(.bottom, 5)
                    .padding(.horizontal, 16)
//                    .frame(maxWidth: .infinity, alignment: .leading)

                }
                .zIndex(1)
            }
        }
        .animation(.easeInOut, value: viewModel.showToast)

    }

}

struct SignInView_Previews: PreviewProvider {
    static var previews: some View {
        SignInView()
    }
}
