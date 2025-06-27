
import SwiftUI

struct LogoutButtonView: View {

    @Environment(\.colorScheme) var colorScheme

    let action: () -> Void

    var body: some View {
        Button(action: action) {
            Group {
                LogoutIconShape()
            }
            .aspectRatio(contentMode: .fit)
            .frame(width: 25, height: 25)
            .foregroundColor(AppColors.text(colorScheme))
        }
    }
}
#Preview {
    LogoutButtonView(action: {})
}
