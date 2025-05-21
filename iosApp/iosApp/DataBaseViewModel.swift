//
//  RepositortViewModel.swift
//  iosApp
//
//  Created by Язгуль Хасаншина on 20.05.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import Foundation
import shared
import Combine

@MainActor
class DataBaseViewModel: ObservableObject {
    private let commonVM: BookViewModel

    var commonFlow: CommonStateFlow<BookViewState>

    private var cancellables = Set<AnyCancellable>()

    @Published var states: BookViewState

    var testingEvent = BookEvent.CreateBook(name: "Преступление и наказание")

    init(commonVM: BookViewModel) {
        self.commonVM = commonVM
        self.states = commonVM.viewStates.value as! BookViewState
        commonFlow = commonVM.getViewStates()

        publishBookStateFlow()
    }
    func publishBookStateFlow() {
        statePublisher(commonFlow)
            .sink { newState in
                print("Новое состояние: \(newState.title)")
                self.states = newState
                print("Новое состояние проверка: \(self.states.title)")
            }
            .store(in: &cancellables)
    }

    func obtainEvent() {
        let event = BookEvent.CreateBook(name: "Преступление и наказание")
        print("book event is created: \(event)")
        self.commonVM.obtainEvent(event: event)


    }

    deinit {
        commonVM.onCleared()
    }

}
