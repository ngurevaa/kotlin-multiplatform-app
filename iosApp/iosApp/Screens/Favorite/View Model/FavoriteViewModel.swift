//
//  FavoriteViewModel.swift
//  iosApp
//
//  Created by Язгуль Хасаншина on 24.06.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import Foundation
import shared
import Combine

@MainActor
class FavoriteViewModel: ObservableObject {
    var favoriteCommonViewModel: BookmarksViewModel

    var commonStateFlow: CommonStateFlow<BookmarksViewState>
    @Published var bookmarksState: BookmarksViewState?

    var commonActionFlow: CommonFlow<BookmarksAction>
    @Published var bookmarksAction: BookmarksAction?

    private var cancellables = Set<AnyCancellable>()

    @Published var showToast: Bool = false
    var toastMessage: String = ""

    @Published var detailScreenSelectedBookId: String?
    @Published var showBookDetailScreen: Bool = false

    var loadedBooks: [Book_] = []

    init(favoriteCommonViewModel: BookmarksViewModel) {
        self.favoriteCommonViewModel = favoriteCommonViewModel

        commonStateFlow = favoriteCommonViewModel.getViewStates()
        commonActionFlow = favoriteCommonViewModel.getActions()

        publishFavoriteStateFlow()
        publishFavoriteActionFlow()

    }

    func publishFavoriteStateFlow() {
        commonStatePublisherFlow(commonStateFlow)
            .sink { [weak self] newState in
                self?.bookmarksState = newState
                self?.loadedBooks = newState.books
                print("bookmark books: ", newState.books)
            }
            .store(in: &cancellables)
    }

    func publishFavoriteActionFlow() {
        commonPublisherFlow(commonActionFlow)
            .sink { [weak self] newAction in
                self?.bookmarksAction = newAction
                self?.doActionOption(action: newAction)
            }
            .store(in: &cancellables)
    }

    func doClickToBookEvent(id: String) {
        let bookmarksEvent = BookmarksEvent.ClickToBook(id: id)
        favoriteCommonViewModel.obtainEvent(event: bookmarksEvent)
    }

    func doLoadBooksEvent() {
        let bookmarksEvent = BookmarksEvent.LoadBooks()
        favoriteCommonViewModel.obtainEvent(event: bookmarksEvent)
    }

    func doActionOption(action: BookmarksAction) {
        if (action.isEqual(BookmarksAction.ShowBookmarksLoadingError())) {
            showToastForSeconds(message: AlertMessage.dataLoadingError, seconds: 2)
        }
        if let bookId = detailScreenSelectedBookId {
            if (action.isEqual(BookmarksAction.NavigateToBook(id: bookId))) {
                showBookDetailScreen = true
            }
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

    deinit {
        favoriteCommonViewModel.onCleared()
    }
}
