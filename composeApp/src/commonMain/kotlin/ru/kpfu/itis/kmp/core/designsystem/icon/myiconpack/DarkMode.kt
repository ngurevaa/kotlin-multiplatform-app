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

public val IconPack.DarkMode: ImageVector
    get() {
        if (_darkmode != null) {
            return _darkmode!!
        }
        _darkmode = Builder(name = "Darkmode", defaultWidth = 24.0.dp, defaultHeight = 24.0.dp,
                viewportWidth = 960.0f, viewportHeight = 960.0f).apply {
            path(fill = SolidColor(Color(0xFFe3e3e3)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(480.0f, 840.0f)
                quadToRelative(-151.0f, 0.0f, -255.5f, -104.5f)
                reflectiveQuadTo(120.0f, 480.0f)
                quadToRelative(0.0f, -138.0f, 90.0f, -239.5f)
                reflectiveQuadTo(440.0f, 122.0f)
                quadToRelative(13.0f, -2.0f, 23.0f, 3.5f)
                reflectiveQuadToRelative(16.0f, 14.5f)
                quadToRelative(6.0f, 9.0f, 6.5f, 21.0f)
                reflectiveQuadToRelative(-7.5f, 23.0f)
                quadToRelative(-17.0f, 26.0f, -25.5f, 55.0f)
                reflectiveQuadToRelative(-8.5f, 61.0f)
                quadToRelative(0.0f, 90.0f, 63.0f, 153.0f)
                reflectiveQuadToRelative(153.0f, 63.0f)
                quadToRelative(31.0f, 0.0f, 61.5f, -9.0f)
                reflectiveQuadToRelative(54.5f, -25.0f)
                quadToRelative(11.0f, -7.0f, 22.5f, -6.5f)
                reflectiveQuadTo(819.0f, 481.0f)
                quadToRelative(10.0f, 5.0f, 15.5f, 15.0f)
                reflectiveQuadToRelative(3.5f, 24.0f)
                quadToRelative(-14.0f, 138.0f, -117.5f, 229.0f)
                reflectiveQuadTo(480.0f, 840.0f)
                close()
                moveTo(480.0f, 760.0f)
                quadToRelative(88.0f, 0.0f, 158.0f, -48.5f)
                reflectiveQuadTo(740.0f, 585.0f)
                quadToRelative(-20.0f, 5.0f, -40.0f, 8.0f)
                reflectiveQuadToRelative(-40.0f, 3.0f)
                quadToRelative(-123.0f, 0.0f, -209.5f, -86.5f)
                reflectiveQuadTo(364.0f, 300.0f)
                quadToRelative(0.0f, -20.0f, 3.0f, -40.0f)
                reflectiveQuadToRelative(8.0f, -40.0f)
                quadToRelative(-78.0f, 32.0f, -126.5f, 102.0f)
                reflectiveQuadTo(200.0f, 480.0f)
                quadToRelative(0.0f, 116.0f, 82.0f, 198.0f)
                reflectiveQuadToRelative(198.0f, 82.0f)
                close()
                moveTo(470.0f, 490.0f)
                close()
            }
        }
        .build()
        return _darkmode!!
    }

private var _darkmode: ImageVector? = null
