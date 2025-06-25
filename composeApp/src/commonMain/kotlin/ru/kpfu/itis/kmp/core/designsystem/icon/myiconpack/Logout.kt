package ru.kpfu.itis.kmp.core.designsystem.icon.myiconpack

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import kotlin.Unit
import ru.kpfu.itis.kmp.core.designsystem.icon.IconPack

public val IconPack.Logout: ImageVector
    get() {
        if (_logout != null) {
            return _logout!!
        }
        _logout = Builder(name = "Logout", defaultWidth = 24.0.dp, defaultHeight = 24.0.dp,
                viewportWidth = 960.0f, viewportHeight = 960.0f).apply {
            path(fill = SolidColor(Color(0xFFe3e3e3)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(200.0f, 840.0f)
                quadToRelative(-33.0f, 0.0f, -56.5f, -23.5f)
                reflectiveQuadTo(120.0f, 760.0f)
                verticalLineToRelative(-560.0f)
                quadToRelative(0.0f, -33.0f, 23.5f, -56.5f)
                reflectiveQuadTo(200.0f, 120.0f)
                horizontalLineToRelative(240.0f)
                quadToRelative(17.0f, 0.0f, 28.5f, 11.5f)
                reflectiveQuadTo(480.0f, 160.0f)
                quadToRelative(0.0f, 17.0f, -11.5f, 28.5f)
                reflectiveQuadTo(440.0f, 200.0f)
                lineTo(200.0f, 200.0f)
                verticalLineToRelative(560.0f)
                horizontalLineToRelative(240.0f)
                quadToRelative(17.0f, 0.0f, 28.5f, 11.5f)
                reflectiveQuadTo(480.0f, 800.0f)
                quadToRelative(0.0f, 17.0f, -11.5f, 28.5f)
                reflectiveQuadTo(440.0f, 840.0f)
                lineTo(200.0f, 840.0f)
                close()
                moveTo(687.0f, 520.0f)
                lineTo(400.0f, 520.0f)
                quadToRelative(-17.0f, 0.0f, -28.5f, -11.5f)
                reflectiveQuadTo(360.0f, 480.0f)
                quadToRelative(0.0f, -17.0f, 11.5f, -28.5f)
                reflectiveQuadTo(400.0f, 440.0f)
                horizontalLineToRelative(287.0f)
                lineToRelative(-75.0f, -75.0f)
                quadToRelative(-11.0f, -11.0f, -11.0f, -27.0f)
                reflectiveQuadToRelative(11.0f, -28.0f)
                quadToRelative(11.0f, -12.0f, 28.0f, -12.5f)
                reflectiveQuadToRelative(29.0f, 11.5f)
                lineToRelative(143.0f, 143.0f)
                quadToRelative(12.0f, 12.0f, 12.0f, 28.0f)
                reflectiveQuadToRelative(-12.0f, 28.0f)
                lineTo(669.0f, 651.0f)
                quadToRelative(-12.0f, 12.0f, -28.5f, 11.5f)
                reflectiveQuadTo(612.0f, 650.0f)
                quadToRelative(-11.0f, -12.0f, -10.5f, -28.5f)
                reflectiveQuadTo(613.0f, 594.0f)
                lineToRelative(74.0f, -74.0f)
                close()
            }
        }
        .build()
        return _logout!!
    }

private var _logout: ImageVector? = null
