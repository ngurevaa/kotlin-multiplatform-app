//
//  AppHomeView.swift
//  iosApp
//
//  Created by Язгуль Хасаншина on 12.06.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct AppHomeView: View {
    @StateObject var homeTabBarVisibility = HomeTabBarVisibility()
//    Произведена авторизация, показать домашний экран приложения
    @AppStorage("isLoggedIn") var isLoggedIn = false
//    Пользователь регистрируется, показать экран регистрации
    @AppStorage("isRegistering") var isRegistering = false

    @AppStorage("appTheme") var appThemeRaw: String = AppTheme.system.rawValue

    var body: some View {
        Group {
            if isLoggedIn {
                HomeTabBarView()
                    .environmentObject(homeTabBarVisibility)
            } else if isRegistering {
                NavigationStack {
                    SignUpView()
                }
            } else {
                NavigationStack {
                    SignInView()
                }
            }
        }
        .preferredColorScheme(AppTheme(rawValue: appThemeRaw)?.colorScheme)
    }
//    var body: some View {
//        Group {
//            if isRegistering {
//                NavigationStack {
//                    SignUpView()
//                }
//            } else {
//                NavigationStack {
//                    SignInView()
//                }
//            }
//        }
//        .preferredColorScheme(AppTheme(rawValue: appThemeRaw)?.colorScheme)
//    }

}

#Preview {
    AppHomeView()
}
