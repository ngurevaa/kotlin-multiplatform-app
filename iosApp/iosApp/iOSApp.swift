import SwiftUI
import shared

@main
struct iOSApp: App {

    init() {
        initShared()
    }
    
    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
    private func initShared() {

        CommonKmpKt.doInitKoin { app in
            print("app: \(app)")

        }

    }
}
