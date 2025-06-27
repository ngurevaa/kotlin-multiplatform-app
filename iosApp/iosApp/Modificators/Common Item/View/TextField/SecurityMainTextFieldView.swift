//
//  SecurityMainTextFieldView.swift
//  iosApp
//
//  Created by Язгуль Хасаншина on 28.06.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct SecurityMainTextFieldView: View {
    @Binding var text: String
    @Binding var isSecure: Bool
    var onTextChange: () -> Void

    @Environment(\.colorScheme) var colorScheme

    var body: some View {
        HStack {
            if isSecure {
                SecureField("", text: $text)
            } else {
                TextField("", text: $text)
            }

            Button(action: {
                isSecure.toggle()
            }) {
                Image(systemName: isSecure ? "eye.slash" : "eye")
                    .foregroundColor(AppColors.text(colorScheme))
            }
        }
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
    SecurityMainTextFieldView(text: .constant(""), isSecure: .constant(true), onTextChange: {})
}
