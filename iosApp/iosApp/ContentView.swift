import SwiftUI
import shared

struct ContentView: View {
    @State private var showContent = false
    @StateObject var viewModel: DataBaseViewModel = DataBaseViewModel(commonVM: BookViewModel())

    //eventConsumer: (BookEvent) -> Void = {
    //    event in
    //    viewModel
    //
    //}

    var body: some View {
        VStack {
            Text(viewModel.states.title)
            Button {
                viewModel.obtainEvent()
            } label: {
                Text("Add book")
            }
            .padding()

            Button("Click me!") {
                withAnimation {
                    showContent = !showContent
                }
            }

            if showContent {
                VStack(spacing: 16) {
                    Image(systemName: "swift")
                        .font(.system(size: 200))
                        .foregroundColor(.accentColor)
                    Text("SwiftUI: \(Greeting().greet())")
                }
                .transition(.move(edge: .top).combined(with: .opacity))
            }
        }
        .frame(maxWidth: .infinity, maxHeight: .infinity, alignment: .top)
        .padding()
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
