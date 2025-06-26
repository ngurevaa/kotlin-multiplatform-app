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
    @Environment(\.colorScheme) var colorScheme

    var message: String

    var body: some View {
        HStack {
            Text(message)
                .font(AppFont.medium(size: 12))
                .foregroundColor(AppColors.alertText(colorScheme))
                .multilineTextAlignment(.leading)
            Spacer()
        }
        .padding(10)
        .frame(maxWidth: .infinity)
        .background(AppColors.alert(colorScheme))
        .cornerRadius(4)
        .shadow(color: .black.opacity(0.4), radius: 5)
        .padding(16)

    }
}
#Preview {
    ToastAlertView(message: "Invalid email or password.")
}

