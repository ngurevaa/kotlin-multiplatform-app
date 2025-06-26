//
//  FavoriteView.swift
//  iosApp
//
//  Created by Язгуль Хасаншина on 20.06.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI
import shared

struct FavoriteView: View {
    @StateObject var viewModel = FavoriteViewModel(favoriteCommonViewModel: BookmarksViewModel())

    @Environment(\.colorScheme) var colorScheme

    let columns = [
        GridItem(.flexible()),
        GridItem(.flexible())
    ]

    var body: some View {
        ZStack {
            VStack {
                // Книги в 2 колонки
                ScrollView {
                    LazyVGrid(columns: columns, spacing: 10) {
                        ForEach(viewModel.loadedBooks, id: \.id) { book in
                            Button {
                                viewModel.detailScreenSelectedBookId = book.id
                                viewModel.showBookDetailScreen = true
                            } label: {
                                BookGridCard(bookImage: book.image, bookName: book.name, bookAuthor: book.author)
                                    .frame(maxWidth: .infinity, alignment: .leading)

                            }
                            .buttonStyle(.plain)
                            .frame(width: 150, height: 350, alignment: .top)
                        }
                    }
                    .padding(.horizontal, 4)
                    .padding(.top, 6)
                }
                .navigationDestination(isPresented: $viewModel.showBookDetailScreen) {
                    if let bookId = viewModel.detailScreenSelectedBookId {
                        BookDetailView(
                            viewModel: BookDetailViewModel(
                                bookDetailCommonViewModel: BookDetailsViewModel(),
                                bookId: bookId
                            )
                        )
                    }
                }

            }

            .safeAreaInset(edge: .bottom) {
                Color.clear.frame(height: 80)
            }

            //            Алерт (Toast) оповещение
            if viewModel.showToast {
                VStack {
                    HStack {
                        ToastAlertView(message: viewModel.toastMessage)
                    }
                    .transition(.move(edge: .top).combined(with: .opacity))
                    Spacer()
                }
                .zIndex(1)
            }
        }
        .animation(.easeInOut, value: viewModel.showToast)

        .background(AppColors.background(colorScheme))

        .navigationBarTitleDisplayMode(.inline)
        .toolbar {
            ToolbarItem(placement: .principal) {
                NavigationScreenTitleView(title: "Bookmarks")
            }
        }
        .onAppear {
            viewModel.doLoadBooksEvent()
        }

    }
}

#Preview {
    FavoriteView()
}
