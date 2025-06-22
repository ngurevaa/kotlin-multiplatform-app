//
//  SearchIconView.swift
//  iosApp
//
//  Created by Язгуль Хасаншина on 22.06.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct SearchIconShape: Shape {
    func path(in rect: CGRect) -> Path {
        var path = Path()

        let scaleX = rect.width / 960
        let scaleY = rect.height / 960

        func s(_ x: CGFloat, _ y: CGFloat) -> CGPoint {
            CGPoint(x: x * scaleX, y: y * scaleY)
        }

        // Внешний круг + ручка
        path.move(to: s(380, 640))
        path.addQuadCurve(to: s(195.5, 555.5), control: s(271, 640))
        path.addQuadCurve(to: s(120, 380), control: s(120, 471))
        path.addQuadCurve(to: s(204.5, 195.5), control: s(120, 289))
        path.addQuadCurve(to: s(380, 125), control: s(289, 125))
        path.addQuadCurve(to: s(564.5, 204.5), control: s(471, 120))
        path.addQuadCurve(to: s(640, 380), control: s(640, 289))
        path.addQuadCurve(to: s(626, 463), control: s(640, 424))
        path.addQuadCurve(to: s(588, 532), control: s(612, 502))
        path.addLine(to: s(812, 756))
        path.addQuadCurve(to: s(823, 784), control: s(823, 770))
        path.addQuadCurve(to: s(800, 812), control: s(830, 800))
        path.addQuadCurve(to: s(767, 810), control: s(783, 812))
        path.addQuadCurve(to: s(739, 784), control: s(751, 800))
        path.addLine(to: s(532, 588))
        path.addQuadCurve(to: s(463, 626), control: s(502, 612))
        path.addQuadCurve(to: s(380, 640), control: s(424, 640))
        path.closeSubpath()

        // Внутренний круг
        path.move(to: s(380, 560))
        path.addQuadCurve(to: s(507.5, 500), control: s(445, 560))
        path.addQuadCurve(to: s(560, 400), control: s(550, 450))
        path.addQuadCurve(to: s(507.5, 252.5), control: s(560, 315))
        path.addQuadCurve(to: s(380, 200), control: s(450, 200))
        path.addQuadCurve(to: s(252.5, 252.5), control: s(315, 200))
        path.addQuadCurve(to: s(200, 380), control: s(200, 315))
        path.addQuadCurve(to: s(252.5, 507.5), control: s(200, 445))
        path.addQuadCurve(to: s(380, 560), control: s(320, 570))
        path.closeSubpath()

        return path
    }
}


#Preview {
    SearchIconShape()
}
