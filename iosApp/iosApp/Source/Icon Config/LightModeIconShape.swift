//
//  LightModeIconView.swift
//  iosApp
//
//  Created by Язгуль Хасаншина on 22.06.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

import SwiftUI

struct LightModeIconShape: Shape {
    func path(in rect: CGRect) -> Path {
        var path = Path()

        let scaleX = rect.width / 960
        let scaleY = rect.height / 960

        func s(_ x: CGFloat, _ y: CGFloat) -> CGPoint {
            CGPoint(x: x * scaleX, y: y * scaleY)
        }

        // Центральный круг с радиусом ~85
        path.move(to: s(480, 600))
        path.addQuadCurve(to: s(565, 565), control: s(530, 600))
        path.addQuadCurve(to: s(600, 480), control: s(600, 530))
        path.addQuadCurve(to: s(565, 395), control: s(600, 430))
        path.addQuadCurve(to: s(480, 360), control: s(515, 360))
        path.addQuadCurve(to: s(395, 395), control: s(430, 360))
        path.addQuadCurve(to: s(360, 480), control: s(360, 430))
        path.addQuadCurve(to: s(395, 565), control: s(360, 530))
        path.addQuadCurve(to: s(480, 600), control: s(445, 600))
        path.closeSubpath()

        // Внешний круг (больший)
        path.move(to: s(480, 680))
        path.addQuadCurve(to: s(338.5, 650), control: s(400, 680))
        path.addQuadCurve(to: s(280, 480), control: s(280, 600))
        path.addQuadCurve(to: s(280, 397), control: s(280, 438))
        path.addQuadCurve(to: s(338.5, 338.5), control: s(300, 340))
        path.addQuadCurve(to: s(480, 280), control: s(400, 300))
        path.addQuadCurve(to: s(621.5, 338.5), control: s(560, 300))
        path.addQuadCurve(to: s(680, 480), control: s(660, 400))
        path.addQuadCurve(to: s(621.5, 621.5), control: s(660, 560))
        path.addQuadCurve(to: s(480, 680), control: s(560, 660))
        path.closeSubpath()

        // Левая горизонтальная полоса
        path.move(to: s(80, 520))
        path.addQuadCurve(to: s(51.5, 508.5), control: s(64, 520))
        path.addQuadCurve(to: s(40, 480), control: s(40, 495))
        path.addQuadCurve(to: s(51.5, 451.5), control: s(40, 465))
        path.addQuadCurve(to: s(80, 440), control: s(60, 440))
        path.addLine(to: s(160, 440))
        path.addQuadCurve(to: s(188.5, 451.5), control: s(175, 440))
        path.addQuadCurve(to: s(200, 480), control: s(200, 465))
        path.addQuadCurve(to: s(188.5, 508.5), control: s(200, 495))
        path.addQuadCurve(to: s(160, 520), control: s(175, 520))
        path.addLine(to: s(80, 520))
        path.closeSubpath()

        // Правая горизонтальная полоса
        path.move(to: s(800, 520))
        path.addQuadCurve(to: s(771.5, 508.5), control: s(784, 520))
        path.addQuadCurve(to: s(760, 480), control: s(760, 495))
        path.addQuadCurve(to: s(771.5, 451.5), control: s(760, 465))
        path.addQuadCurve(to: s(800, 440), control: s(780, 440))
        path.addLine(to: s(880, 440))
        path.addQuadCurve(to: s(908.5, 451.5), control: s(895, 440))
        path.addQuadCurve(to: s(920, 480), control: s(920, 465))
        path.addQuadCurve(to: s(908.5, 508.5), control: s(920, 495))
        path.addQuadCurve(to: s(880, 520), control: s(895, 520))
        path.addLine(to: s(800, 520))
        path.closeSubpath()

        // Верхняя вертикальная полоса
        path.move(to: s(480, 200))
        path.addQuadCurve(to: s(451.5, 188.5), control: s(468, 200))
        path.addQuadCurve(to: s(440, 160), control: s(440, 175))
        path.addLine(to: s(440, 80))
        path.addQuadCurve(to: s(451.5, 51.5), control: s(440, 64))
        path.addQuadCurve(to: s(480, 40), control: s(465, 40))
        path.addQuadCurve(to: s(508.5, 51.5), control: s(495, 40))
        path.addQuadCurve(to: s(520, 80), control: s(520, 65))
        path.addLine(to: s(520, 160))
        path.addQuadCurve(to: s(508.5, 188.5), control: s(520, 175))
        path.addQuadCurve(to: s(480, 200), control: s(495, 200))
        path.closeSubpath()

        // Нижняя вертикальная полоса
        path.move(to: s(480, 920))
        path.addQuadCurve(to: s(451.5, 908.5), control: s(468, 920))
        path.addQuadCurve(to: s(440, 880), control: s(440, 895))
        path.addLine(to: s(440, 800))
        path.addQuadCurve(to: s(451.5, 771.5), control: s(440, 784))
        path.addQuadCurve(to: s(480, 760), control: s(465, 760))
        path.addQuadCurve(to: s(508.5, 771.5), control: s(495, 760))
        path.addQuadCurve(to: s(520, 800), control: s(520, 785))
        path.addLine(to: s(520, 880))
        path.addQuadCurve(to: s(508.5, 908.5), control: s(520, 895))
        path.addQuadCurve(to: s(480, 920), control: s(495, 920))
        path.closeSubpath()

        // Диагонали: 4 стрелочки по углам

        // Нижний левый угол
        path.move(to: s(226, 282))
        path.addLine(to: s(183, 240))
        path.addQuadCurve(to: s(171, 212), control: s(183, 224))
        path.addQuadCurve(to: s(183, 183), control: s(177, 197))
        path.addQuadCurve(to: s(212, 171), control: s(192, 183))
        path.addQuadCurve(to: s(240, 183), control: s(224, 183))
        path.addLine(to: s(282, 225))
        path.addQuadCurve(to: s(293, 253), control: s(282, 241))
        path.addQuadCurve(to: s(282, 281), control: s(293, 269))
        path.addQuadCurve(to: s(254, 293), control: s(271, 287))
        path.addQuadCurve(to: s(226, 282), control: s(240, 293))
        path.closeSubpath()

        // Правый нижний угол
        path.move(to: s(720, 777))
        path.addLine(to: s(678, 734))
        path.addQuadCurve(to: s(667, 705), control: s(678, 718))
        path.addQuadCurve(to: s(678, 678), control: s(668, 691))
        path.addQuadCurve(to: s(705, 667), control: s(687, 678))
        path.addQuadCurve(to: s(734, 678), control: s(718, 668))
        path.addLine(to: s(777, 720))
        path.addQuadCurve(to: s(788, 748), control: s(777, 735))
        path.addQuadCurve(to: s(777, 777), control: s(788, 764))
        path.addQuadCurve(to: s(748, 789), control: s(764, 785))
        path.addQuadCurve(to: s(720, 777), control: s(734, 789))
        path.closeSubpath()

        // Правый верхний угол
        path.move(to: s(678, 282))
        path.addQuadCurve(to: s(666, 271), control: s(676, 271))
        path.addQuadCurve(to: s(678, 226), control: s(671, 245))
        path.addLine(to: s(720, 183))
        path.addQuadCurve(to: s(748, 171), control: s(730, 171))
        path.addQuadCurve(to: s(777, 183), control: s(764, 183))
        path.addQuadCurve(to: s(789, 212), control: s(780, 183))
        path.addQuadCurve(to: s(777, 240), control: s(789, 224))
        path.addLine(to: s(734, 282))
        path.addQuadCurve(to: s(706, 293), control: s(722, 287))
        path.addQuadCurve(to: s(678, 282), control: s(706, 282))
        path.closeSubpath()

        // Нижний левый угол (повтор)
        path.move(to: s(183, 777))
        path.addQuadCurve(to: s(171, 765), control: s(183, 765))
        path.addQuadCurve(to: s(171, 737), control: s(171, 754))
        path.addLine(to: s(226, 695))
        path.addQuadCurve(to: s(254, 684), control: s(239, 684))
        path.addQuadCurve(to: s(282, 695), control: s(270, 684))
        path.addQuadCurve(to: s(282, 722), control: s(282, 705))
        path.addQuadCurve(to: s(267, 734), control: s(282, 728))
        path.addQuadCurve(to: s(183, 777), control: s(230, 777))
        path.closeSubpath()

        return path
    }
}


#Preview {
    LightModeIconShape()
}
