
import SwiftUI

struct RadioButtonView: View {

    @Environment(\.colorScheme) var colorScheme

    let text: String
    let textSize: CGFloat = 17
    let isSelected: Bool
    let action: () -> Void

    var body: some View {
        Button(action: action) {
            HStack(spacing: 8) {
                ZStack {
                    // внешний круг (обводка)
                    Circle()
                        .stroke(AppColors.primary(colorScheme), lineWidth: 2)
                        .frame(width: 20, height: 20)
                    // внутренний круг
                    if isSelected {
                        Circle()
                            .fill(AppColors.primary(colorScheme))
                            .frame(width: 10, height: 10)
                    }
                }

                Text(text)
                    .font(AppFont.regular(size: textSize))
                    .foregroundStyle(AppColors.text(colorScheme))
            }
        }
        .padding(.trailing, 10)
    }
}

#Preview {
    RadioButtonView(text: "Title", isSelected: true, action: {})
}
