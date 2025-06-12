import SwiftUI
import shared

struct SignInView: View {
    @StateObject var viewModel: SignInViewModel = SignInViewModel(loginCommonViewModel: LoginViewModel())

    var body: some View {
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
                        .padding()
                        .frame(height: 38)
                        .background(AppColor.Light.dataTextfield)
                        .cornerRadius(10)
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
                    .padding()
                    .frame(height: 38)
                    .background(AppColor.Light.dataTextfield)
                    .cornerRadius(10)
                }

            }

            Spacer()

            VStack(spacing: 12) {
                Button(action: {
                    viewModel.doSignIn()
                }) {
                    Text("Sign In")
                        .font(AppFont.medium(size: 20))
                        .foregroundColor(.white)
                        .padding()
                        .frame(maxWidth: .infinity)
                        .frame(height: 38)
                        .background(AppColor.Light.primary)
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
            .padding(.bottom, 16)
        }
        .padding()
        .background(AppColor.Light.background)
        .ignoresSafeArea(edges: .bottom)
        .alert(isPresented: $viewModel.showEmailAlert) {
            Alert(title: Text("Invalid email"), message: Text(viewModel.emailAlertMessage), dismissButton: .default(Text("Submit")))
        }
//        .alert(isPresented: $viewModel.showPasswordAlert) {
//            Alert(title: Text("Invalid password"), message: Text(viewModel.passwordAlertMessage), dismissButton: .default(Text("Submit")))
//        }
    }

}

struct SignInView_Previews: PreviewProvider {
    static var previews: some View {
        SignInView()
    }
}
