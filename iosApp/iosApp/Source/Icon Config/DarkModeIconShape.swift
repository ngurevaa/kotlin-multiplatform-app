//
//  DarkModeIconView.swift
//  iosApp
//
//  Created by Язгуль Хасаншина on 22.06.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct DarkModeIconShape: Shape {
    func path(in rect: CGRect) -> Path {
        var path = Path()

        let scaleX = rect.width / 960.0
        let scaleY = rect.height / 960.0

        func s(_ x: CGFloat, _ y: CGFloat) -> CGPoint {
            CGPoint(x: x * scaleX, y: y * scaleY)
        }

        // Внешний контур луны
        path.move(to: s(480, 840))
        path.addQuadCurve(to: s(224.5, 735.5), control: s(328.5, 840))
        path.addQuadCurve(to: s(120, 480), control: s(120, 630.5))
        path.addQuadCurve(to: s(210, 240.5), control: s(120, 342))
        path.addQuadCurve(to: s(440, 122), control: s(300, 139))
        path.addQuadCurve(to: s(463, 125.5), control: s(453, 118.5))
        path.addQuadCurve(to: s(479, 140), control: s(473, 132))
        path.addQuadCurve(to: s(485.5, 161), control: s(485, 149))
        path.addQuadCurve(to: s(478, 184), control: s(487, 173))
        path.addQuadCurve(to: s(453, 239), control: s(461, 210))
        path.addQuadCurve(to: s(444.5, 300), control: s(444.5, 268))
        path.addQuadCurve(to: s(507.5, 453), control: s(444.5, 390))
        path.addQuadCurve(to: s(660.5, 516), control: s(570.5, 516))
        path.addQuadCurve(to: s(722, 491), control: s(692, 507))
        path.addQuadCurve(to: s(744.5, 480.5), control: s(733, 480.5))
        path.addQuadCurve(to: s(774.5, 495.5), control: s(756, 486.5))
        path.addQuadCurve(to: s(778, 519.5), control: s(783, 506))
        path.addQuadCurve(to: s(660.5, 748), control: s(760, 660))
        path.addQuadCurve(to: s(480, 840), control: s(580, 828))
        path.closeSubpath()

        // Внутренняя часть (светлый контур луны)
        path.move(to: s(480, 760))
        path.addQuadCurve(to: s(638, 711.5), control: s(568, 760))
        path.addQuadCurve(to: s(740, 585), control: s(708, 663))
        path.addQuadCurve(to: s(700, 593), control: s(720, 590))
        path.addQuadCurve(to: s(620, 596), control: s(680, 596))
        path.addQuadCurve(to: s(410.5, 509.5), control: s(509.5, 596))
        path.addQuadCurve(to: s(364, 300), control: s(364, 423))
        path.addQuadCurve(to: s(372, 260), control: s(364, 280))
        path.addQuadCurve(to: s(380, 220), control: s(380, 240))
        path.addQuadCurve(to: s(252, 322), control: s(308, 252))
        path.addQuadCurve(to: s(200, 480), control: s(200, 398))
        path.addQuadCurve(to: s(282, 678), control: s(200, 598))
        path.addQuadCurve(to: s(480, 760), control: s(380, 760))
        path.closeSubpath()

        return path
    }
}


#Preview {
    DarkModeIconShape()
}
