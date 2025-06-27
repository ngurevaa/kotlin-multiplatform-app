
import Foundation
import Combine
import shared

@MainActor
class SearchScreenViewModel: ObservableObject {
    var searchCommonViewModel: SearchViewModel

    var commonStateFlow: CommonStateFlow<SearchViewState>
    @Published var searchState: SearchViewState?

    var commonActionFlow: CommonFlow<SearchAction>
    @Published var searchAction: SearchAction?

    private var cancellables = Set<AnyCancellable>()

    @Published var showToast: Bool = false
    var toastMessage: String = ""

    @Published var detailScreenSelectedBookId: String?
    @Published var showBookDetailScreen: Bool = false
    
    @Published var selectedFilter: Filter?

    @Published var searchText = ""

    var loadedBooks: [Book___] = []

    init(searchCommonViewModel: SearchViewModel) {
        self.searchCommonViewModel = searchCommonViewModel

        commonStateFlow = searchCommonViewModel.getViewStates()
        commonActionFlow = searchCommonViewModel.getActions()

        publishSearchStateFlow()
        publishSearchActionFlow()

    }

    func publishSearchStateFlow() {
        commonStatePublisherFlow(commonStateFlow)
            .sink { [weak self] newState in
                self?.searchState = newState
                
                self?.setNewSelectedFilter(state: newState)

                self?.loadedBooks = newState.books
            }
            .store(in: &cancellables)
    }

    func publishSearchActionFlow() {
        commonPublisherFlow(commonActionFlow)
            .sink { [weak self] newAction in
                self?.searchAction = newAction
                self?.doActionOption(action: newAction)
            }
            .store(in: &cancellables)
    }

    func setNewSelectedFilter(state: SearchViewState) {
        if selectedFilter == nil, let firstFilter = state.filters.first {
            selectedFilter = firstFilter
        }
        selectedFilter = state.selectedFilter
    }

    func doClickToBookEvent(id: String) {
        let searchEvent = SearchEvent.ClickToBook(id: id)
        searchCommonViewModel.obtainEvent(event: searchEvent)
    }

    func doSelectFilterEvent(filter: Filter) {
        let searchEvent = SearchEvent.SelectFilter(filter: filter)
        searchCommonViewModel.obtainEvent(event: searchEvent)
    }

    func doSearchEvent() {
        let searchEvent = SearchEvent.Search()
        searchCommonViewModel.obtainEvent(event: searchEvent)
    }

    func doUpdateSearchEvent() {
        let searchEvent = SearchEvent.UpdateSearch(search: searchText)
        searchCommonViewModel.obtainEvent(event: searchEvent)
    }

    func doOpenScreenEvent() {
        let searchEvent = SearchEvent.OpenScreen()
        searchCommonViewModel.obtainEvent(event: searchEvent)
    }

    func doActionOption(action: SearchAction) {
        if (action.isEqual(SearchAction.ShowInternetConnectionError())) {
            showToastForSeconds(message: AlertMessage.internetConnectionError, seconds: 2)
        }
        if (action.isEqual(SearchAction.ShowEmptySearchError())) {
            showToastForSeconds(message: AlertMessage.emptySearchError, seconds: 2)
        }
        if let bookId = detailScreenSelectedBookId {
            if (action.isEqual(SearchAction.NavigateToBook(id: bookId))) {
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
        searchCommonViewModel.onCleared()
    }
}
