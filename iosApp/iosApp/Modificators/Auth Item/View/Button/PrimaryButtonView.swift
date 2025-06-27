//
//  PrimaryButtonView.swift
//  iosApp
//
//  Created by Язгуль Хасаншина on 28.06.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct PrimaryButtonView: View {
    let title: String
    let action: () -> Void

    @Environment(\.colorScheme) var colorScheme

    var body: some View {
        Button(action: action) {
            Text(title)
                .font(AppFont.medium(size: 20))
                .foregroundColor(AppColors.background(colorScheme))
                .padding()
                .frame(maxWidth: .infinity)
                .frame(height: 38)
                .background(AppColors.primary(colorScheme))
                .cornerRadius(10)
        }
    }
}

#Preview {
    PrimaryButtonView(title: "Sing In", action: {})
}
