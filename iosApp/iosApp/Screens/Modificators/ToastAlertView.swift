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
        Text(message)
            .font(AppFont.medium(size: 14))
            .foregroundColor(.white)
            .padding(10)
            .background(Color(hex: Colors.shared.inverseSurfaceLight))
            .cornerRadius(4)
            .shadow(color: .black.opacity(0.4), radius: 4)
            .multilineTextAlignment(.leading)
            .frame(maxWidth: .infinity, alignment: .leading)
    }
}
#Preview {
    ToastAlertView(message: "Invalid email or password.")
}
