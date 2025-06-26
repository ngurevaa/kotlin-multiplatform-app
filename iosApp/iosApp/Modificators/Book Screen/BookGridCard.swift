//
//  BookGridCard.swift
//  iosApp
//
//  Created by Язгуль Хасаншина on 24.06.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI
import shared

struct BookGridCard: View {

    @Environment(\.colorScheme) var colorScheme

    var bookImage: String = ""
    var bookName: String = ""
    var bookAuthor: String = ""

    var body: some View {
        VStack(spacing: 4) {
            AsyncImage(url: URL(string: bookImage)) { image in
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
                Text(bookName)
                    .font(AppFont.medium(size: 18))
                    .foregroundColor(AppColors.text(colorScheme))
                    .lineLimit(3)
                    .minimumScaleFactor(0.8)

                Text(bookAuthor)
                    .font(AppFont.medium(size: 14))
                    .foregroundColor(AppColors.subtitle(colorScheme))
                    .lineLimit(2)
            }
            .frame(maxWidth: .infinity, alignment: .leading)
        }
        .background(AppColors.background(colorScheme))
    }
}

#Preview {
    BookGridCard()
}
