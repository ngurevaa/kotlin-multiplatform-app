//
//  ThemeViewModelService.swift
//  iosApp
//
//  Created by Язгуль Хасаншина on 26.06.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI
import shared
import Combine

//MARK: - общий сервис для определения темы приложения
class ThemeViewModelService {

    static let shared = ThemeViewModelService()

    public var themeCommonViewModel = ThemeViewModel()

    public var commonStateFlow: CommonStateFlow<ThemeViewState>
    @Published var themeState: ThemeViewState?

    @AppStorage("appTheme") var appThemeRaw: String = AppTheme.system.rawValue

    private var cancellables = Set<AnyCancellable>()

    init() {
        commonStateFlow = themeCommonViewModel.getViewStates()
        publishThemeStateFlow()
    }

    func publishThemeStateFlow() {
        commonStatePublisherFlow(commonStateFlow)
            .sink { [weak self] newState in
                self?.themeState = newState

                self?.changeAppTheme(state: newState)
            }
            .store(in: &cancellables)
    }

    public func doChangeThemeEvent() {
        let isDark = isDarkThemeAppStorage()

        let themeEvent = ThemeEvent.ChangeTheme(isDarkTheme: !isDark)
        themeCommonViewModel.obtainEvent(event: themeEvent)
    }

    public func isDarkThemeAppStorage() -> Bool {
        switch appThemeRaw {
        case AppTheme.dark.rawValue:
            return true
        default:
            return false
        }
    }

    func changeAppTheme(state: ThemeViewState) {
        let isDark = state.isDarkTheme
// тема сбрасывается при новом запуске приложения т.к. имеется подвязка с Kotlin, откуда всегда первый State приходит с isDarkTheme = false
        if isDark {
            appThemeRaw = AppTheme.dark.rawValue
        } else {
            appThemeRaw = AppTheme.light.rawValue
        }
    }

}
