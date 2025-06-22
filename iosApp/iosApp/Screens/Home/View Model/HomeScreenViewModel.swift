//
//  HomeScreenViewModel.swift
//  iosApp
//
//  Created by Язгуль Хасаншина on 17.06.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import Foundation
import shared
import Combine

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
            toastMessage = AlertMessage.internetConnectionError
            showToast = true

            DispatchQueue.main.asyncAfter(deadline: .now() + 2) {
                self.showToast = false
            }
        }
    }

    deinit {
        homeCommonViewModel.onCleared()
    }
}
