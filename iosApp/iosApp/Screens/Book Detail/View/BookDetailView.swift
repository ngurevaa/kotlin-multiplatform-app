//
//  BookDetailView.swift
//  iosApp
//
//  Created by Язгуль Хасаншина on 24.06.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI
import shared

struct BookDetailView: View {
    
    @Environment(\.dismiss) var dismiss
    @Environment(\.colorScheme) var colorScheme
    @EnvironmentObject var homeTabBarVisibility: HomeTabBarVisibility

    @ObservedObject var viewModel: BookDetailViewModel

    var body: some View {
        ZStack {
            VStack {
                //            Индикатор загрузки
                if viewModel.bookDetailState?.isLoading == true {
                    RoundLoadingIndicatorView()
                } else {
                    ScrollView {
                        VStack(spacing: 36) {
                            VStack(spacing: 14) {
                                AsyncImage(url: URL(string: viewModel.bookDetailState?.image ?? "")) { image in
                                    image
                                        .resizable()
                                        .scaledToFill()
                                } placeholder: {
                                    Image("cat-placeholder")
                                        .resizable()
                                        .scaledToFill()
                                        .opacity(0.8)
                                }
                                .frame(width: 200, height: 320)
                                .cornerRadius(20)
                                .clipped()

                                VStack(alignment: .center, spacing: 4) {
                                    Text(viewModel.bookDetailState?.name ?? "")
                                        .font(AppFont.regular(size: 19))
                                        .foregroundColor(AppColors.text(colorScheme))
                                        .lineLimit(3)
                                        .minimumScaleFactor(0.8)

                                    Text(viewModel.bookDetailState?.author ?? "")
                                        .font(AppFont.regular(size: 16))
                                        .foregroundColor(AppColors.subtitle(colorScheme))
                                        .lineLimit(2)
                                }
                            }

                            VStack(alignment: .leading, spacing: 12) {
                                Text("Overview")
                                    .font(AppFont.regular(size: 19))
                                    .padding(.bottom, 2)
                                Text(viewModel.bookDetailState?.overview ?? "")
                                    .foregroundColor(AppColors.subtitle(colorScheme))
                                    .font(AppFont.regular(size: 16))
                                    .lineSpacing(4)
                            }
                            .padding(.horizontal, 26)
                            .frame(maxWidth: .infinity, alignment: .leading)
                        }
                    }
                    .padding(.bottom, 8)
                }
            }

            //        Кнопки таббара
            .navigationBarBackButtonHidden(true)
            .toolbar {
                ToolbarItem(placement: .navigationBarLeading) {
                    BackButtonView(color: AppColors.text(colorScheme))
                }
                ToolbarItem(placement: .navigationBarTrailing) {
                    BookmarkButtonView(
                        isBookmarked: viewModel.bookDetailState?.isBookmarked == true,
                        onSave: { viewModel.doSaveBookmarkEvent() },
                        onDelete: { viewModel.doDeleteBookmarkEvent() }
                    )
                }
            }

            //            Алерт (Toast) оповещение
            if viewModel.showToast {
                VStack {
                    Spacer()
                    HStack {
                        ToastAlertView(message: viewModel.toastMessage)
                    }
                    .transition(.move(edge: .bottom).combined(with: .opacity))

                }
                .zIndex(1)
            }
        }
        .background(AppColors.background(colorScheme))
        .animation(.easeInOut, value: viewModel.showToast)

        //        Скрытие таббара
        .onAppear {
            homeTabBarVisibility.isVisible = false
            viewModel.doOpenScreenEvent()
        }
        .onDisappear {
            homeTabBarVisibility.isVisible = true
        }

    }
}

#Preview {
    BookDetailView(viewModel: BookDetailViewModel(bookDetailCommonViewModel: BookDetailsViewModel(), bookId: "1"))
        .environmentObject(HomeTabBarVisibility())
}
