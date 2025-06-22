//
//  BookmarkFillIconView.swift
//  iosApp
//
//  Created by Язгуль Хасаншина on 22.06.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct BookmarkFillIconShape: Shape {
    func path(in rect: CGRect) -> Path {
        var path = Path()

        let scaleX = rect.width / 960.0
        let scaleY = rect.height / 960.0

        func s(_ x: CGFloat, _ y: CGFloat) -> CGPoint {
            CGPoint(x: x * scaleX, y: y * scaleY)
        }

        path.move(to: s(480, 720))
        path.addLine(to: s(312, 792)) // -168, +72
        path.addQuadCurve(to: s(236, 785.5), control: s(272, 809))
        path.addQuadCurve(to: s(200, 719), control: s(200, 719))
        path.addLine(to: s(200, 200))
        path.addQuadCurve(to: s(280, 120), control: s(223.5, 143.5))
        path.addLine(to: s(680, 120))
        path.addQuadCurve(to: s(760, 200), control: s(736.5, 143.5))
        path.addLine(to: s(760, 719))
        path.addQuadCurve(to: s(684, 785.5), control: s(724, 785.5))
        path.addLine(to: s(516, 720))
        path.closeSubpath()

        return path
    }
}

#Preview {
    BookmarkFillIconShape()
}
