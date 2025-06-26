//
//  AppColors.swift
//  iosApp
//
//  Created by Язгуль Хасаншина on 26.06.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI
import shared

struct AppColors {
    struct Light {
        static let primary = Color(hex: Colors.shared.primaryLight)
        static let background = Color(hex: Colors.shared.backgroundLight)
        static let alert = Color(hex: Colors.shared.inverseSurfaceLight)
        static let alertText = Color(hex: Colors.shared.inverseSurfaceDark)
        static let text = Color(hex: Colors.shared.inverseSurfaceLight)
        static let subtitle = Color(hex: Colors.shared.secondaryLight)
        static let textfield = Color(hex: Colors.shared.surfaceContainerHighestLight)

    }

    struct Dark {
        static let primary = Color(hex: Colors.shared.primaryDark)
        static let background = Color(hex: Colors.shared.backgroundDark)
        static let alert = Color(hex: Colors.shared.inverseSurfaceDark)
        static let alertText = Color(hex: Colors.shared.inverseSurfaceLight)
        static let text = Color(hex: Colors.shared.inverseSurfaceDark)
        static let subtitle = Color(hex: Colors.shared.secondaryDark)
        static let textfield = Color(hex: Colors.shared.surfaceContainerHighestDark)
    }

    static func primary(_ scheme: ColorScheme) -> Color {
        scheme == .dark ? Dark.primary : Light.primary
    }

    static func background(_ scheme: ColorScheme) -> Color {
        scheme == .dark ? Dark.background : Light.background
    }

    static func alert(_ scheme: ColorScheme) -> Color {
        scheme == .dark ? Dark.alert : Light.alert
    }

    static func text(_ scheme: ColorScheme) -> Color {
        scheme == .dark ? Dark.text : Light.text
    }

    static func subtitle(_ scheme: ColorScheme) -> Color {
        scheme == .dark ? Dark.subtitle : Light.subtitle
    }

    static func alertText(_ scheme: ColorScheme) -> Color {
        scheme == .dark ? Dark.alertText : Light.alertText
    }

    static func textfield(_ scheme: ColorScheme) -> Color {
        scheme == .dark ? Dark.textfield : Light.textfield
    }
}
