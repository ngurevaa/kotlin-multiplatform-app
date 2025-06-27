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

                self?.setNewSelectedBooks(state: newState)
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

    func setNewSelectedBooks(state: HomeViewState) {

        if let genreKey = state.books.keys.first(where: { $0.id == state.currentGenre.id }), let books = state.books[genreKey] {
            selectedBooks = books
        }
    }

    func doActionOption(action: HomeAction) {
        if (action.isEqual(HomeAction.ShowInternetConnectionError())) {
            showToastForSeconds(message: AlertMessage.internetConnectionError, seconds: 2)

        }
        if let bookId = detailScreenSelectedBookId {
            if (action.isEqual(HomeAction.NavigateToBook(id: bookId))) {
                showBookDetailScreen = true
            }
        }
        if (action.isEqual(HomeAction.NavigateToLogin())) {
            UserDefaults.standard.set(false, forKey: "isLoggedIn")
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

    func doUpdateCurrentGenreEvent(genre: Genre) {
        let homeEvent = HomeEvent.UpdateCurrentGenre(genre: genre)
        homeCommonViewModel.obtainEvent(event: homeEvent)
    }

    func doLogoutEvent() {
        let homeEvent = HomeEvent.Logout()
        homeCommonViewModel.obtainEvent(event: homeEvent)

    }

    func changeAppTheme() {
        ThemeViewModelService.shared.doChangeThemeEvent()
    }

    deinit {
        homeCommonViewModel.onCleared()
    }
}
