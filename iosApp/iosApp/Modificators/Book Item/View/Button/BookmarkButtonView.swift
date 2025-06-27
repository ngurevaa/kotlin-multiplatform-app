//
//  BookmarkButtonView.swift
//  iosApp
//
//  Created by Язгуль Хасаншина on 25.06.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct BookmarkButtonView: View {
    @Environment(\.colorScheme) var colorScheme

    var isBookmarked: Bool
    var onSave: () -> Void
    var onDelete: () -> Void

    var body: some View {
        Button(action: {
            isBookmarked ? onDelete() : onSave()
        }) {
            Group {
                if isBookmarked {
                    BookmarkFillIconShape()
                } else {
                    BookmarkIconShape()
                }
            }
            .aspectRatio(contentMode: .fit)
            .frame(width: 30, height: 30)
            .foregroundColor(AppColors.text(colorScheme))
        }
    }
}
