//
//  SearchView.swift
//  iosApp
//
//  Created by Язгуль Хасаншина on 20.06.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI
import shared

struct SearchScreenView: View {

    @StateObject var viewModel = SearchScreenViewModel(searchCommonViewModel: SearchViewModel())

    @Environment(\.colorScheme) var colorScheme

    let columns = [
        GridItem(.flexible()),
        GridItem(.flexible())
    ]

    var body: some View {
        ZStack {
            VStack (alignment: .leading) {
                VStack (alignment: .leading, spacing: 32) {
                    VStack (alignment: .leading, spacing: 10) {
                        Text("Search by")
                            .font(AppFont.medium(size: 15))
                            .foregroundColor(AppColors.text(colorScheme))

                        HStack(spacing: 10) {
                            ForEach(viewModel.searchState?.filters ?? [], id: \.self) { filter in
                                RadioButtonView(text: filter.name, isSelected: filter == viewModel.selectedFilter) {
                                    viewModel.doSelectFilterEvent(filter: filter)
                                }
                            }
                        }
                    }
                    .padding(.horizontal, 30)
                    HStack(spacing: 20) {
                        TextField("", text: $viewModel.searchText)
                            .foregroundColor(AppColors.text(colorScheme))
                            .textInputAutocapitalization(.never)
                            .padding()
                            .frame(height: 38)
                            .background(AppColors.textfield(colorScheme))
                            .cornerRadius(10)
                            .onChange(of: viewModel.searchText) { _ in
                                viewModel.doUpdateSearchEvent()
                            }

                        Button(action: {
                            viewModel.doSearchEvent()
                        }) {
                            Image(systemName: "magnifyingglass")
                                .foregroundStyle(AppColors.text(colorScheme))
                                .font(AppFont.regular(size: 20))
                                .frame(width: 20, height: 20)
                        }
                    }
                    .padding(.horizontal, 24)
                }

                if viewModel.searchState?.isLoading == true {
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
                        ForEach(viewModel.loadedBooks, id: \.id) { book in
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
    SearchScreenView()
}
