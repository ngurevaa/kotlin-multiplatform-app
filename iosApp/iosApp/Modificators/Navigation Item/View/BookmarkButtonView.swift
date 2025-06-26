//
//  BookmarkButtonView.swift
//  iosApp
//
//  Created by Язгуль Хасаншина on 25.06.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct BookmarkButtonView: View {
    @ObservedObject var viewModel: BookDetailViewModel
    var color: Color = .black

    var body: some View {
        if viewModel.bookDetailState?.isBookmarked == true {
            Button(action: {
                viewModel.doDeleteBookmarkEvent()
            }) {
                BookmarkFillIconShape()
                    .aspectRatio(contentMode: .fit)
                    .frame(width: 30, height: 30)
                    .foregroundColor(color)
            }
        } else {
            Button(action: {
                viewModel.doSaveBookmarkEvent()
            }) {
                BookmarkIconShape()
                    .aspectRatio(contentMode: .fit)
                    .frame(width: 30, height: 30)
                    .foregroundColor(color)
            }
        }
    }
}
