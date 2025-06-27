//
//  AuthSwitchLinkView.swift
//  iosApp
//
//  Created by Язгуль Хасаншина on 28.06.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct AuthSwitchLinkView: View {
    let message: String
    let linkText: String
    let action: () -> Void

    @Environment(\.colorScheme) var colorScheme

    var body: some View {
        HStack {
            Text(message)
                .font(AppFont.regular(size: 14))
                .foregroundStyle(AppColors.text(colorScheme))

            Button(action: action) {
                Text(linkText)
                    .underline()
                    .font(AppFont.regular(size: 14))
                    .foregroundStyle(AppColors.text(colorScheme))
            }
        }
//        .foregroundStyle(AppColors.text(colorScheme))
    }
}

#Preview {
    AuthSwitchLinkView(message: "Let`s Sign In", linkText: "text", action: {})
}
