//
//  HomeTabBarView.swift
//  iosApp
//
//  Created by Язгуль Хасаншина on 20.06.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI
import shared

enum HomeTab {
    case home, search, favorite
}
struct HomeTabBarView: View {
    @State private var selectedTab: HomeTab = .home
    @EnvironmentObject var homeTabBarVisibility: HomeTabBarVisibility
    @Environment(\.colorScheme) var colorScheme

    var body: some View {
        ZStack(alignment: .bottom) {
            Group {
                switch selectedTab {
                case .home:
                    NavigationStack {
                        HomeScreenView()
                    }
                    .tint(AppColors.primary(colorScheme))
                case .search:
                    NavigationStack {
                        SearchScreenView()
                    }
                    .tint(AppColors.primary(colorScheme))
                case .favorite:
                    NavigationStack {
                        FavoriteView()
                    }
                    .tint(AppColors.primary(colorScheme))
                }
            }
            .frame(maxWidth: .infinity, maxHeight: .infinity)
            .ignoresSafeArea()

            if homeTabBarVisibility.isVisible {
                HStack () {
                    Spacer()
                    tabBarItem(tab: .home)
                    Spacer()
                    Spacer()
                    tabBarItem(tab: .search)
                    Spacer()
                    Spacer()
                    tabBarItem(tab: .favorite)
                    Spacer()
                }

                .padding()

                .background(
                    Capsule()
                        .fill(AppColors.background(colorScheme))
                        .frame(maxWidth: 600, minHeight: 70)
                        .shadow(radius: 10)
                )
                .padding(.horizontal, 20)
                .padding(.bottom, 20)
            }
        }
    }

    @ViewBuilder
    private func tabBarItem(tab: HomeTab) -> some View {
        Button(action: {
            selectedTab = tab
        }) {
            tabIcon(for: tab)
                .aspectRatio(contentMode: .fit)
                .frame(width: 20, height: 20)
                .foregroundColor(
                    selectedTab == tab ? AppColors.primary(colorScheme) : AppColors.subtitle(colorScheme)
                )
        }
    }

    @ViewBuilder
    private func tabIcon(for tab: HomeTab) -> some View {
        switch tab {
        case .home:
            if selectedTab == tab {
                HomeFillIconShape()
            } else {
                HomeIconShape()
            }
        case .search:
            SearchIconShape()
        case .favorite:
            if selectedTab == tab {
                BookmarkFillIconShape()
            } else {
                BookmarkIconShape()
            }
        }
        
    }

}


#Preview {
    HomeTabBarView()
        .environmentObject(HomeTabBarVisibility())
}
