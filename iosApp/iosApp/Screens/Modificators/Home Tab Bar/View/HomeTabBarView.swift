//
//  HomeTabBarView.swift
//  iosApp
//
//  Created by Язгуль Хасаншина on 20.06.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI
import shared

struct HomeTabBarView: View {
    @State private var selectedTab: HomeTab = .home

    var body: some View {

        TabView(selection: $selectedTab) {
            HomeScreenView()
                .tabItem {
                    Image(systemName: "house.fill")
                }
                .tag(HomeTab.home)

            SearchView()
                .tabItem {
                    Image(systemName: "magnifyingglass")
                }
                .tag(HomeTab.search)

            FavoriteView()
                .tabItem {
                    Image(systemName: "bookmark.fill")
                }
                .tag(HomeTab.favorite)
        }
        .tint(Color(hex: Colors.shared.primaryLight))
    }
//        .overlay(
//            VStack {
//                Spacer()
//                RoundedRectangle(cornerRadius: 25)
//                    .foregroundColor(Color(hex: Colors.shared.backgroundLight))
//                    .frame(height: 80)
//                    .shadow(radius: 5)
//                    .padding(.horizontal)
//                    .padding(.bottom, 10)
//            }
//        )
//    }
}


#Preview {
    HomeTabBarView()
}

//struct HomeTabBarView: View {
//    @State var selectedTab: HomeTab = .home
//
//    var body: some View {
//
//        HStack {
//            Spacer()
//            HomeScreenView()
//                .tabItem {
//                    Image(systemName: "house.fill")
//                        .foregroundColor(selectedTab == .home ? Color(hex: Colors.shared.primaryLight) : .gray)
//                        .onTapGesture {
//                            selectedTab = .home
//                        }
//                }
//            Spacer()
//            SignInView()
//                .tabItem {
//                    Image(systemName: "magnifyingglass")
//                        .foregroundColor(selectedTab == .search ? Color(hex: Colors.shared.primaryLight) : .gray)
//                        .onTapGesture {
//                            selectedTab = .search
//                        }
//                }
//            Spacer()
//            Image(systemName: "bookmark")
//                .foregroundColor(selectedTab == .favorite ? Color(hex: Colors.shared.primaryLight) : .gray)
//                .onTapGesture {
//                    selectedTab = .favorite
//                }
//            Spacer()
//        }
//        .padding()
//        .background(
//            RoundedRectangle(cornerRadius: 25)
//                .foregroundColor(Color(hex: Colors.shared.backgroundLight))
//                .shadow(radius: 5)
//        )
//        .padding(.horizontal)
//    }
//}
//
//
//#Preview {
//    HomeTabBarView(selectedTab: .home)
//}
