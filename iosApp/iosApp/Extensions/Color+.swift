//
//  Color+.swift
//  iosApp
//
//  Created by Язгуль Хасаншина on 12.06.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI
import shared
extension Color {

    init(hex int64: Int64) {
        let hex = UInt64(bitPattern: int64)
        let components = (
            R: Double((hex >> 16) & 0xFF) / 255,
            G: Double((hex >> 8) & 0xFF) / 255,
            B: Double(hex & 0xFF) / 255,
            A: Double((hex >> 24) & 0xFF) / 255
        )
        self.init(.sRGB, red: components.R, green: components.G, blue: components.B, opacity: components.A)
    }

    static var dataTextfieldColor: Color {
        return Color(red: 0.9, green: 0.9, blue: 0.9)
    }

}
