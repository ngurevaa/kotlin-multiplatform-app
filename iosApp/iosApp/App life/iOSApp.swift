import SwiftUI
import shared
import FirebaseCore

@main
struct iOSApp: App {

    init() {
        initShared()
        FirebaseApp.configure()
    }
    
    var body: some Scene {
        WindowGroup {
            AppHomeView()
        }
    }
    private func initShared() {

        CommonKmpKt.doInitKoin { app in
            print("app: \(app)")

        }

    }
}
