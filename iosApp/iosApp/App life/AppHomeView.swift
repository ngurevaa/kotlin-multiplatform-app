//
//  AppHomeView.swift
//  iosApp
//
//  Created by Язгуль Хасаншина on 12.06.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct AppHomeView: View {
//    @AppStorage("isLoggedIn") var isLoggedIn = false

    @AppStorage("isRegistering") var isRegistering = false

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
