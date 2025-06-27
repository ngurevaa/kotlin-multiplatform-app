//
//  RoundLoadingIndicatorView.swift
//  iosApp
//
//  Created by Язгуль Хасаншина on 28.06.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct RoundLoadingIndicatorView: View {
    @Environment(\.colorScheme) var colorScheme

    var body: some View {
        HStack {
            Spacer()
            ProgressView()
                .progressViewStyle(CircularProgressViewStyle())
                .scaleEffect(2)
                .tint(AppColors.primary(colorScheme))
            Spacer()
        }
        .padding(.vertical, 16)
    }
}
#Preview {
    RoundLoadingIndicatorView()
}
