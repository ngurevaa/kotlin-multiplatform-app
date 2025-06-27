//
//  ThemeToggleButtonView.swift
//  iosApp
//
//  Created by Язгуль Хасаншина on 25.06.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI
import shared
struct ThemeToggleButtonView: View {
    @Environment(\.colorScheme) var colorScheme
    var onToggle: () -> Void

    var body: some View {
        Button {
            onToggle()
        } label: {
            Group {
                if ThemeViewModelService.shared.isDarkThemeAppStorage() {
                    LightModeIconShape()
                } else {
                    DarkModeIconShape()
                }
            }
            .aspectRatio(contentMode: .fit)
            .frame(width: 25, height: 25)
            .foregroundColor(AppColors.text(colorScheme))
        }
    }
}

#Preview {
    ThemeToggleButtonView(onToggle: {})
}
