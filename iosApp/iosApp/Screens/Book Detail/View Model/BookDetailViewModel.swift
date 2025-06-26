//
//  BookDetailViewModel.swift
//  iosApp
//
//  Created by Язгуль Хасаншина on 24.06.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import Foundation
import shared
import Combine

@MainActor
class BookDetailViewModel: ObservableObject {
    var bookDetailCommonViewModel: BookDetailsViewModel

    var commonStateFlow: CommonStateFlow<BookDetailsViewState>
    @Published var bookDetailState: BookDetailsViewState?

    var commonActionFlow: CommonFlow<BookDetailsAction>
    @Published var bookDetailAction: BookDetailsAction?

    private var cancellables = Set<AnyCancellable>()

    @Published var showToast: Bool = false
    var toastMessage: String = ""

    var bookId: String

    init(bookDetailCommonViewModel: BookDetailsViewModel, bookId: String) {
        self.bookDetailCommonViewModel = bookDetailCommonViewModel
        self.bookId = bookId

        commonStateFlow = bookDetailCommonViewModel.getViewStates()
        commonActionFlow = bookDetailCommonViewModel.getActions()

        publishBookDetailStateFlow()
        publishBookDetailActionFlow()

        doLoadBookEvent()
    }

    func publishBookDetailStateFlow() {
        commonStatePublisherFlow(commonStateFlow)
            .sink { [weak self] newState in
                self?.bookDetailState = newState
            }
            .store(in: &cancellables)
    }
    func publishBookDetailActionFlow() {
        commonPublisherFlow(commonActionFlow)
            .sink { [weak self] newAction in
                self?.bookDetailAction = newAction
                self?.doActionOption(action: newAction)

            }
            .store(in: &cancellables)
    }

    func doActionOption(action: BookDetailsAction) {
        if (action.isEqual(BookDetailsAction.ShowInternetConnectionError())) {
            showToastForSeconds(message: AlertMessage.internetConnectionError, seconds: 2)
        }

        if (action.isEqual(BookDetailsAction.ShowBookmarkSavingError())) {
            showToastForSeconds(message: AlertMessage.dataSavingError, seconds: 2)
        }
    }

    func showToastForSeconds(message: String, seconds: Int) {
        toastMessage = message
        showToast = true

        Task {
            try? await Task.sleep(nanoseconds: UInt64(seconds) * 1_000_000_000)
            showToast = false
        }
    }

    func doLoadBookEvent() {
        let bookDetailEvent = BookDetailsEvent.LoadBook(id: bookId)
        bookDetailCommonViewModel.obtainEvent(event: bookDetailEvent)
    }

    func doClearBookEvent() {
        let bookDetailEvent = BookDetailsEvent.ClearBook()
        bookDetailCommonViewModel.obtainEvent(event: bookDetailEvent)
    }

    func doSaveBookmarkEvent() {
        let bookDetailEvent = BookDetailsEvent.SaveBookmark()
        bookDetailCommonViewModel.obtainEvent(event: bookDetailEvent)
    }

    func doDeleteBookmarkEvent() {
        let bookDetailEvent = BookDetailsEvent.DeleteBookmark()
        bookDetailCommonViewModel.obtainEvent(event: bookDetailEvent)
    }

    deinit {
        bookDetailCommonViewModel.onCleared()
    }
}
