//
//  HomeFillIconView.swift
//  iosApp
//
//  Created by Язгуль Хасаншина on 22.06.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct HomeFillIconShape: Shape {
    func path(in rect: CGRect) -> Path {
        var path = Path()

        let scaleX = rect.width / 960
        let scaleY = rect.height / 960

        func s(_ x: CGFloat, _ y: CGFloat) -> CGPoint {
            CGPoint(x: x * scaleX, y: y * scaleY)
        }

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
        path.addLine(to: s(600, 840))
        path.addQuadCurve(to: s(582.5, 828.5), control: s(592, 840))
        path.addQuadCurve(to: s(560, 800), control: s(570, 815))
        path.addLine(to: s(560, 600))
        path.addQuadCurve(to: s(548.5, 571.5), control: s(560, 583))
        path.addQuadCurve(to: s(520, 560), control: s(534, 560))
        path.addLine(to: s(440, 560))
        path.addQuadCurve(to: s(412.5, 571.5), control: s(428, 560))
        path.addQuadCurve(to: s(400, 600), control: s(400, 583))
        path.addLine(to: s(400, 800))
        path.addQuadCurve(to: s(388.5, 828.5), control: s(400, 815))
        path.addQuadCurve(to: s(360, 840), control: s(375, 840))
        path.addLine(to: s(240, 840))
        path.addQuadCurve(to: s(183.5, 816.5), control: s(207, 840))
        path.addQuadCurve(to: s(160, 760), control: s(160, 788))
        path.closeSubpath()

        return path
    }
}


#Preview {
    HomeFillIconShape()
}
