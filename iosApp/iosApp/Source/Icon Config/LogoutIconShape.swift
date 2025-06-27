
import SwiftUI

struct LogoutIconShape: Shape {
    func path(in rect: CGRect) -> Path {
            var path = Path()

            let scaleX = rect.width / 960
            let scaleY = rect.height / 960

            path.move(to: CGPoint(x: 200 * scaleX, y: 840 * scaleY))
            path.addQuadCurve(to: CGPoint(x: 120 * scaleX, y: 760 * scaleY),
                              control: CGPoint(x: 167 * scaleX, y: 840 * scaleY))
            path.addLine(to: CGPoint(x: 120 * scaleX, y: 200 * scaleY))
            path.addQuadCurve(to: CGPoint(x: 200 * scaleX, y: 120 * scaleY),
                              control: CGPoint(x: 120 * scaleX, y: 167 * scaleY))
            path.addLine(to: CGPoint(x: 440 * scaleX, y: 120 * scaleY))
            path.addQuadCurve(to: CGPoint(x: 480 * scaleX, y: 160 * scaleY),
                              control: CGPoint(x: 467 * scaleX, y: 120 * scaleY))
            path.addQuadCurve(to: CGPoint(x: 440 * scaleX, y: 200 * scaleY),
                              control: CGPoint(x: 480 * scaleX, y: 187 * scaleY))
            path.addLine(to: CGPoint(x: 200 * scaleX, y: 200 * scaleY))
            path.addLine(to: CGPoint(x: 200 * scaleX, y: 760 * scaleY))
            path.addLine(to: CGPoint(x: 440 * scaleX, y: 760 * scaleY))
            path.addQuadCurve(to: CGPoint(x: 480 * scaleX, y: 800 * scaleY),
                              control: CGPoint(x: 467 * scaleX, y: 760 * scaleY))
            path.addQuadCurve(to: CGPoint(x: 440 * scaleX, y: 840 * scaleY),
                              control: CGPoint(x: 480 * scaleX, y: 827 * scaleY))
            path.addLine(to: CGPoint(x: 200 * scaleX, y: 840 * scaleY))

            // Стрелка
            path.move(to: CGPoint(x: 687 * scaleX, y: 520 * scaleY))
            path.addLine(to: CGPoint(x: 400 * scaleX, y: 520 * scaleY))
            path.addQuadCurve(to: CGPoint(x: 360 * scaleX, y: 480 * scaleY),
                              control: CGPoint(x: 373 * scaleX, y: 520 * scaleY))
            path.addQuadCurve(to: CGPoint(x: 400 * scaleX, y: 440 * scaleY),
                              control: CGPoint(x: 360 * scaleX, y: 453 * scaleY))
            path.addLine(to: CGPoint(x: 687 * scaleX, y: 440 * scaleY))
            path.addLine(to: CGPoint(x: 612 * scaleX, y: 365 * scaleY))
            path.addQuadCurve(to: CGPoint(x: 640 * scaleX, y: 325 * scaleY),
                              control: CGPoint(x: 612 * scaleX, y: 337 * scaleY))
            path.addQuadCurve(to: CGPoint(x: 669 * scaleX, y: 337 * scaleY),
                              control: CGPoint(x: 653 * scaleX, y: 325 * scaleY))
            path.addLine(to: CGPoint(x: 812 * scaleX, y: 480 * scaleY))
            path.addQuadCurve(to: CGPoint(x: 812 * scaleX, y: 508 * scaleY),
                              control: CGPoint(x: 824 * scaleX, y: 480 * scaleY))
            path.addLine(to: CGPoint(x: 669 * scaleX, y: 651 * scaleY))
            path.addQuadCurve(to: CGPoint(x: 640 * scaleX, y: 639 * scaleY),
                              control: CGPoint(x: 653 * scaleX, y: 651 * scaleY))
            path.addQuadCurve(to: CGPoint(x: 612 * scaleX, y: 594 * scaleY),
                              control: CGPoint(x: 613 * scaleX, y: 625 * scaleY))
            path.addLine(to: CGPoint(x: 686 * scaleX, y: 520 * scaleY))

            return path
        }
}

#Preview {
    LogoutIconShape()
}
