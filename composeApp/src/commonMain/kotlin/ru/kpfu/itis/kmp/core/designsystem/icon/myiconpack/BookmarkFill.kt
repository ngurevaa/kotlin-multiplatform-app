package ru.kpfu.itis.kmp.core.designsystem.icon.myiconpack

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import ru.kpfu.itis.kmp.core.designsystem.icon.IconPack

public val IconPack.BookmarkFill: ImageVector
    get() {
        if (_bookmark24dpE3e3e3Fill1Wght0Grad0Opsz24 != null) {
            return _bookmark24dpE3e3e3Fill1Wght0Grad0Opsz24!!
        }
        _bookmark24dpE3e3e3Fill1Wght0Grad0Opsz24 = Builder(name =
                "Bookmark24dpE3e3e3Fill1Wght0Grad0Opsz24", defaultWidth = 24.0.dp, defaultHeight =
                24.0.dp, viewportWidth = 960.0f, viewportHeight = 960.0f).apply {
            path(fill = SolidColor(Color(0xFFe3e3e3)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveToRelative(480.0f, 720.0f)
                lineToRelative(-168.0f, 72.0f)
                quadToRelative(-40.0f, 17.0f, -76.0f, -6.5f)
                reflectiveQuadTo(200.0f, 719.0f)
                verticalLineToRelative(-519.0f)
                quadToRelative(0.0f, -33.0f, 23.5f, -56.5f)
                reflectiveQuadTo(280.0f, 120.0f)
                horizontalLineToRelative(400.0f)
                quadToRelative(33.0f, 0.0f, 56.5f, 23.5f)
                reflectiveQuadTo(760.0f, 200.0f)
                verticalLineToRelative(519.0f)
                quadToRelative(0.0f, 43.0f, -36.0f, 66.5f)
                reflectiveQuadToRelative(-76.0f, 6.5f)
                lineToRelative(-168.0f, -72.0f)
                close()
            }
        }
        .build()
        return _bookmark24dpE3e3e3Fill1Wght0Grad0Opsz24!!
    }

private var _bookmark24dpE3e3e3Fill1Wght0Grad0Opsz24: ImageVector? = null
