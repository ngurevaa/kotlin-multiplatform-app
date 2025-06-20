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

    let columns = [
        GridItem(.flexible()),
        GridItem(.flexible())
    ]

    var body: some View {
        VStack(alignment: .leading) {
            // Тексты сверху
            VStack(alignment: .leading, spacing: 2) {
                Text("Hello!")
                    .font(AppFont.medium(size: 22))
                    .foregroundColor(.black)
                Text("What do you want to read today?")
                    .font(AppFont.medium(size: 26))
                    .foregroundColor(.black)
                
            }
            .padding(.horizontal)
            .padding(.bottom, 20)

            // Жанры (горизонтальный скроллинг)
            ScrollView(.horizontal, showsIndicators: false) {
                HStack() {
                    ForEach(viewModel.homeState?.genres ?? [], id: \.id) { genre in
                        VStack(spacing: 10) {
                            Text(genre.name)
                                .foregroundColor(viewModel.selectedGenre == genre ? .black : .gray)
                                .font(AppFont.regular(size: 14))
                                .padding(.horizontal)

                            if viewModel.selectedGenre == genre {
                                Capsule()
                                    .frame(height: 3)
                                    .foregroundColor(Color(hex: Colors.shared.primaryLight))
                                    .matchedGeometryEffect(id: "genreUnderline", in: animationNamespace)
                            } else {
                                Color.clear.frame(height: 3)

                            }
                        }
                        .onTapGesture {
                            withAnimation(.easeInOut) {
                                viewModel.selectedGenre = genre
                            }
                        }
                    }
                }
            }

            // Книги в 2 колонки
            ScrollView {
                LazyVGrid(columns: columns, spacing: 10) {
                    ForEach(viewModel.selectedBooks, id: \.self) { book in
                        VStack(spacing: 4) {
                            AsyncImage(url: URL(string: book.image)) { image in
                                image
                                    .resizable()
                                    .scaledToFill()
                            } placeholder: {
                                Image("cat-placeholder")
                                    .resizable()
                                    .scaledToFill()
                                    .opacity(0.8)
                            }
                            .frame(width: 150, height: 240)
                            .cornerRadius(20)
                            .clipped()

                            VStack(alignment: .leading, spacing: 2) {
                                Text(book.name)
                                    .font(AppFont.medium(size: 18))
                                    .foregroundColor(.black)
                                    .lineLimit(3)
                                    .minimumScaleFactor(0.8)

                                Text(book.author)
                                    .font(AppFont.medium(size: 14))
                                    .foregroundColor(.gray)
                                    .lineLimit(2)
                            }
                            .frame(maxWidth: .infinity, alignment: .leading)
                        }
                        .frame(width: 150, height: 350, alignment: .top)
                    }
                }
                .padding(.horizontal, 4)
                .padding(.top, 6)
            }

            Spacer()
        }
        .background(Color(hex: Colors.shared.backgroundLight))
    }
}
#Preview {
    HomeScreenView()
}
