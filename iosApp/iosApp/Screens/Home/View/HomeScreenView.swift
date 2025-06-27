//
//  HomeView.swift
//  iosApp
//
//  Created by Язгуль Хасаншина on 17.06.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI
import shared

struct HomeScreenView: View {

    @StateObject var viewModel = HomeScreenViewModel(homeCommonViewModel: HomeViewModel())

    @Namespace private var animationNamespace

    @Environment(\.colorScheme) var colorScheme

    let columns = [
        GridItem(.flexible()),
        GridItem(.flexible())
    ]

    var body: some View {
        ZStack {
            VStack(alignment: .leading) {
                // Тексты сверху
                VStack(alignment: .leading, spacing: 4) {
                    HStack {
                        Text("Hello!")
                            .font(AppFont.medium(size: 22))
                            .foregroundColor(AppColors.text(colorScheme))

                        Spacer()

                        ThemeToggleButtonView(viewModel: viewModel, color: AppColors.text(colorScheme))
                        LogoutButtonView(action: viewModel.doLogoutEvent)

                    }
                    Text("What do you want to read today?")
                        .font(AppFont.medium(size: 26))
                        .foregroundColor(AppColors.text(colorScheme))

                }
                .padding(.horizontal)
                .padding(.bottom, 20)

                // Жанры (горизонтальный скроллинг)
                ScrollView(.horizontal, showsIndicators: false) {
                    HStack() {
                        ForEach(viewModel.homeState?.genres ?? [], id: \.id) { genre in
                            VStack(spacing: 10) {
                                Text(genre.name)
                                    .foregroundColor(viewModel.homeState?.currentGenre == genre ? AppColors.text(colorScheme) : AppColors.subtitle(colorScheme))
                                    .font(AppFont.regular(size: 14))
                                    .padding(.horizontal)

                                if viewModel.homeState?.currentGenre == genre {
                                    Capsule()
                                        .frame(height: 3)
                                        .foregroundColor(AppColors.primary(colorScheme))
                                        .matchedGeometryEffect(id: "genreUnderline", in: animationNamespace)
                                } else {
                                    Color.clear.frame(height: 3)

                                }
                            }
                            .onTapGesture {
                                withAnimation(.easeInOut) {
                                    viewModel.doUpdateCurrentGenreEvent(genre: genre) 
                                }
                            }
                        }
                    }
                }

                if viewModel.homeState?.isLoading == true {
                    HStack {
                        Spacer()
                        ProgressView()
                            .progressViewStyle(CircularProgressViewStyle())
                            .scaleEffect(2)
                            .tint(AppColors.primary(colorScheme))
                        Spacer()
                    }
                    .padding(.vertical, 16)
                }

                // Книги в 2 колонки
                ScrollView {
                    LazyVGrid(columns: columns, spacing: 10) {
                        ForEach(viewModel.selectedBooks, id: \.id) { book in
                            Button {
                                viewModel.detailScreenSelectedBookId = book.id
                                viewModel.doClickToBookEvent(id: book.id)
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
    }
}
#Preview {
    HomeScreenView()
}
