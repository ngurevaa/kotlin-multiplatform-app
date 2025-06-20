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

enum HomeTab {
    case home, search, favorite
}

class HomeScreenViewModel: ObservableObject {

    var homeCommonViewModel: HomeViewModel

    var commonStateFlow: CommonStateFlow<HomeViewState>
    @Published var homeState: HomeViewState?

//    var commonActionFlow: CommonFlow<HomeAction>
//    @Published var homeActions: HomeAction?

    private var cancellables = Set<AnyCancellable>()

    @Published var selectedTab: HomeTab = .home

    @Published var selectedGenre: Genre? {
        didSet {
            setNewSelectedBooks()
        }
    }

    var selectedBooks: [Book_] = []

    init(homeCommonViewModel: HomeViewModel) {
        self.homeCommonViewModel = homeCommonViewModel

        commonStateFlow = homeCommonViewModel.getViewStates()
//        commonActionFlow = homeCommonViewModel.getActions()

        publishHomeStateFlow()
//        publishHomeActionFlow()
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

//                print("@@@@@@@Новое состояние HomeState genres: \(newState.genres)")
//                print("&&&&&&&Новое состояние HomeState books: \(newState.books)")

            }
            .store(in: &cancellables)
    }

    func setNewSelectedBooks() {
        guard let selectedGenre = selectedGenre else { return }

        if let genreKey = homeState?.books.keys.first(where: { $0.id == selectedGenre.id }) {
            selectedBooks = (homeState?.books[genreKey])!
        }
    }

    deinit {
        homeCommonViewModel.onCleared()
    }
}
