//
//  NavigationScreenTitleView.swift
//  iosApp
//
//  Created by Язгуль Хасаншина on 25.06.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct NavigationScreenTitleView: View {

    @Environment(\.colorScheme) var colorScheme

    var title: String = "Screen"

    var body: some View {
        Text(title)
            .font(AppFont.medium(size: 22))
            .foregroundColor(AppColors.text(colorScheme))
    }
}

#Preview {
    NavigationScreenTitleView()
}
