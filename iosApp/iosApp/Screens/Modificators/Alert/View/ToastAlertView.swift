//
//  ToastView.swift
//  iosApp
//
//  Created by Язгуль Хасаншина on 20.06.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI
import shared
struct ToastAlertView: View {
    var message: String

    var body: some View {
        HStack {
            Text(message)
                .font(AppFont.medium(size: 14))
                .foregroundColor(.white)
                .multilineTextAlignment(.leading)
            Spacer()
        }
        .padding(10)
        .frame(maxWidth: .infinity)
        .background(Color(hex: Colors.shared.inverseSurfaceLight))
        .cornerRadius(4)
        .shadow(color: .black.opacity(0.4), radius: 5)
        .padding(16)

    }
}
#Preview {
    ToastAlertView(message: "Invalid email or password.")
}

