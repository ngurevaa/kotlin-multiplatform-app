//
//  HomeScreenViewModel.swift
//  iosApp
//
//  Created by Язгуль Хасаншина on 17.06.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI
import shared
import Combine

@MainActor
class HomeScreenViewModel: ObservableObject {

    var homeCommonViewModel: HomeViewModel

    var commonStateFlow: CommonStateFlow<HomeViewState>
    @Published var homeState: HomeViewState?

    var commonActionFlow: CommonFlow<HomeAction>
    @Published var homeAction: HomeAction?

    private var cancellables = Set<AnyCancellable>()

    @Published var showToast: Bool = false
    var toastMessage: String = ""

    @Published var selectedGenre: Genre? {
        didSet {
            setNewSelectedBooks()
        }
    }

    var selectedBooks: [Book__] = []

    @Published var detailScreenSelectedBookId: String?
    @Published var showBookDetailScreen: Bool = false

    init(homeCommonViewModel: HomeViewModel) {
        self.homeCommonViewModel = homeCommonViewModel

        commonStateFlow = homeCommonViewModel.getViewStates()
        commonActionFlow = homeCommonViewModel.getActions()

        publishHomeStateFlow()
        publishHomeActionFlow()
    }

    func publishHomeStateFlow() {
        commonStatePublisherFlow(commonStateFlow)
            .sink { [weak self] newState in
                self?.homeState = newState

                if self?.selectedGenre == nil, let firstGenre = newState.genres.first {
                    self?.selectedGenre = firstGenre
                }
                if !newState.books.isEmpty {
                    self?.setNewSelectedBooks()
                }
            }
            .store(in: &cancellables)
    }

    func publishHomeActionFlow() {
        commonPublisherFlow(commonActionFlow)
            .sink { [weak self] newAction in
                self?.homeAction = newAction
                self?.doActionOption(action: newAction)
            }
            .store(in: &cancellables)
    }

    func setNewSelectedBooks() {
        guard let selectedGenre = selectedGenre else { return }

        if let genreKey = homeState?.books.keys.first(where: { $0.id == selectedGenre.id }), let books = homeState?.books[genreKey] {
            selectedBooks = books
        }
    }

    func doActionOption(action: HomeAction) {
        if (action.isEqual(HomeAction.ShowInternetConnectionError())) {
            showToastForSeconds(message: AlertMessage.internetConnectionError, seconds: 2)

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

    func doClickToBookEvent(id: String) {
        let homeEvent = HomeEvent.ClickToBook(id: id)
        homeCommonViewModel.obtainEvent(event: homeEvent)
    }

    func changeAppTheme() {
        ThemeViewModelService.shared.doChangeThemeEvent()
    }

    deinit {
        homeCommonViewModel.onCleared()
    }
}
