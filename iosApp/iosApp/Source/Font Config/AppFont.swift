//
//  AppFont.swift
//  iosApp
//
//  Created by Язгуль Хасаншина on 12.06.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct AppFont {
    static func regular(size: CGFloat) -> Font {
        .custom("Wix Madefor Text Regular", size: size)
    }

    static func medium(size: CGFloat) -> Font {
        .custom("Wix Madefor Text Medium", size: size)
    }

    static func semiBold(size: CGFloat) -> Font {
        .custom("Wix Madefor Text SemiBold", size: size)
    }
}
