//
//  BackButtonView.swift
//  iosApp
//
//  Created by Язгуль Хасаншина on 25.06.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI
struct BackButtonView: View {
    var color: Color = .black
    @Environment(\.dismiss) var dismiss

    var body: some View {
        Button(action: {
            dismiss()
        }) {
            Image(systemName: "chevron.left")
                .foregroundColor(color)
                .imageScale(.large)
        }
    }
}

#Preview {
    BackButtonView()
}

