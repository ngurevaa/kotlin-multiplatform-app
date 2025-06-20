//
//  AppHomeView.swift
//  iosApp
//
//  Created by Язгуль Хасаншина on 12.06.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct AppHomeView: View {
//    Произведена авторизация, показать домашний экран приложения
    @AppStorage("isLoggedIn") var isLoggedIn = false
//    Пользователь регистрируется, показать экран регистрации
    @AppStorage("isRegistering") var isRegistering = false

//    var body: some View {
//        if isLoggedIn {
//            NavigationStack {
//                HomeTabBarView()
//            }
//        } else if isRegistering {
//            NavigationStack {
//                SignUpView()
//            }
//        } else {
//            NavigationStack {
//                SignInView()
//            }
//        }
//    }
    var body: some View {
        if isRegistering {
            NavigationStack {
                SignUpView()
            }
        } else {
            NavigationStack {
                SignInView()
            }
        }
    }

}

#Preview {
    AppHomeView()
}
