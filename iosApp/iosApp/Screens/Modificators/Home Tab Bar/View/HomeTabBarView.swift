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

    var body: some View {
        ZStack(alignment: .bottom) {
            Group {
                switch selectedTab {
                case .home:
                    NavigationStack {
                        HomeScreenView()
                    }
                case .search:
                    NavigationStack {
                        SearchView()
                    }
                case .favorite:
                    NavigationStack {
                        FavoriteView()
                    }
                }
            }
            .frame(maxWidth: .infinity, maxHeight: .infinity)
            .ignoresSafeArea()

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
                    .fill(Color(hex: Colors.shared.backgroundLight))
                    .frame(width: UIScreen.main.bounds.width * 0.9, height: 70)
                    .shadow(radius: 10)
            )
            .padding(.horizontal, 20)
            .padding(.bottom, 20)
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
                    selectedTab == tab ? Color(hex: Colors.shared.primaryLight) : .gray
                )
        }
    }

    @ViewBuilder
    private func tabIcon(for tab: HomeTab) -> some View {
        switch tab {
        case .home:
            HomeFillIconShape()
        case .search:
            SearchIconShape()
        case .favorite:
            BookmarkIconShape()
        }
    }

}


#Preview {
    HomeTabBarView()
}
