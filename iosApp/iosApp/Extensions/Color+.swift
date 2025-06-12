//
//  Color+.swift
//  iosApp
//
//  Created by Язгуль Хасаншина on 12.06.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

extension Color {
    init(hex: UInt32) {
        let components = (
            R: Double((hex >> 16) & 0xff) / 255,
            G: Double((hex >> 8) & 0xff) / 255,
            B: Double(hex & 0xff) / 255,
            A: Double((hex >> 24) & 0xff) / 255
        )
        self.init(.sRGB, red: components.R, green: components.G, blue: components.B, opacity: components.A)
    }
}
