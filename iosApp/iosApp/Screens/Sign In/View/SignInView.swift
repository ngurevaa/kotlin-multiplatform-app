import SwiftUI
import shared

struct SignInView: View {
    @StateObject var viewModel: SignInViewModel = SignInViewModel(loginCommonViewModel: LoginViewModel())
    @Environment(\.colorScheme) var colorScheme
    @Environment(\.verticalSizeClass) var verticalSizeClass

    var body: some View {
        ZStack {
            Group {
                if verticalSizeClass == .compact {
//                    Горизонтальный экран
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

    var content: some View {
        VStack {
            VStack(spacing: 8) {
                Text("Sign In")
                    .font(AppFont.medium(size: 28))
                    .foregroundColor(AppColors.text(colorScheme))

                Text("Enter into your account")
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
                PrimaryButtonView(title: "Sign In") {
                    viewModel.doSignInEvent()
                }

                AuthSwitchLinkView(
                    message: "Do not have an account?",
                    linkText: "Register"
                ) {
                    viewModel.openSignUpScreen()
                }
            }
            .padding(.bottom, 20)
        }
    }
}


struct SignInView_Previews: PreviewProvider {
    static var previews: some View {
        SignInView()
    }
}
