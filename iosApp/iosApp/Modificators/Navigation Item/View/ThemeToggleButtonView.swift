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
    
    @ObservedObject var viewModel: HomeScreenViewModel
    var color: Color = .black

    var body: some View {
        Button {
            viewModel.changeAppTheme()
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
            .foregroundColor(color)
        }
    }
}

#Preview {
    ThemeToggleButtonView(viewModel: HomeScreenViewModel(homeCommonViewModel: HomeViewModel()))
}
