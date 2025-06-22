//
//  HomeIconView.swift
//  iosApp
//
//  Created by Язгуль Хасаншина on 22.06.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct HomeIconShape: Shape {
    func path(in rect: CGRect) -> Path {
        var path = Path()

        let scaleX = rect.width / 960
        let scaleY = rect.height / 960

        func s(_ x: CGFloat, _ y: CGFloat) -> CGPoint {
            CGPoint(x: x * scaleX, y: y * scaleY)
        }

        // Нижний дом — прямоугольник
        path.move(to: s(240, 760))
        path.addLine(to: s(360, 760))
        path.addLine(to: s(360, 560))
        path.addQuadCurve(to: s(371.5, 531.5), control: s(360, 543))
        path.addLine(to: s(400, 520))
        path.addLine(to: s(560, 520))
        path.addQuadCurve(to: s(588.5, 531.5), control: s(574, 520))
        path.addLine(to: s(600, 560))
        path.addLine(to: s(600, 760))
        path.addLine(to: s(720, 760))
        path.addLine(to: s(720, 400))
        path.addLine(to: s(480, 220))
        path.addLine(to: s(240, 400))
        path.addLine(to: s(240, 760))
        path.closeSubpath()

        // Контур вокруг дома (крыша и стены)
        path.move(to: s(160, 760))
        path.addLine(to: s(160, 400))
        path.addQuadCurve(to: s(168.5, 364), control: s(160, 381.5))
        path.addQuadCurve(to: s(192, 336), control: s(176, 344))
        path.addLine(to: s(432, 156))
        path.addQuadCurve(to: s(480, 140), control: s(450, 140))
        path.addQuadCurve(to: s(528, 156), control: s(510, 140))
        path.addLine(to: s(768, 336))
        path.addQuadCurve(to: s(791.5, 364), control: s(783, 348))
        path.addQuadCurve(to: s(800, 400), control: s(800, 382))
        path.addLine(to: s(800, 760))
        path.addQuadCurve(to: s(776.5, 816.5), control: s(800, 788))
        path.addQuadCurve(to: s(720, 840), control: s(753, 840))
        path.addLine(to: s(560, 840))
        path.addQuadCurve(to: s(542.5, 828.5), control: s(552, 840))
        path.addQuadCurve(to: s(520, 800), control: s(530, 815))
        path.addLine(to: s(520, 600))
        path.addLine(to: s(440, 600))
        path.addLine(to: s(440, 800))
        path.addQuadCurve(to: s(428.5, 828.5), control: s(440, 815))
        path.addQuadCurve(to: s(400, 840), control: s(415, 840))
        path.addLine(to: s(240, 840))
        path.addQuadCurve(to: s(183.5, 816.5), control: s(207, 840))
        path.addQuadCurve(to: s(160, 760), control: s(160, 788))
        path.closeSubpath()

        return path
    }
}

#Preview {
    HomeIconShape()
}
