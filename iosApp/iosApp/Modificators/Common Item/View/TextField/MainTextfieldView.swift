//
//  MainTextfieldView.swift
//  iosApp
//
//  Created by Язгуль Хасаншина on 28.06.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct MainTextfieldView: View {
    @Binding var text: String
    var onTextChange: () -> Void

    @Environment(\.colorScheme) var colorScheme

    var body: some View {
        TextField("", text: $text)
            .foregroundColor(AppColors.text(colorScheme))
            .textInputAutocapitalization(.never)
            .padding()
            .frame(height: 38)
            .background(AppColors.textfield(colorScheme))
            .cornerRadius(10)
            .onChange(of: text) { _ in
                onTextChange()
            }
    }
}

#Preview {
    MainTextfieldView(text: .constant("Text"), onTextChange: {})
}
