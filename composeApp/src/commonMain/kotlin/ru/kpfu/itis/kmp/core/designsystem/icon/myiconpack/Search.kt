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

public val IconPack.Search: ImageVector
    get() {
        if (_search24dpE3e3e3Fill0Wght0Grad0Opsz24 != null) {
            return _search24dpE3e3e3Fill0Wght0Grad0Opsz24!!
        }
        _search24dpE3e3e3Fill0Wght0Grad0Opsz24 = Builder(name =
                "Search24dpE3e3e3Fill0Wght0Grad0Opsz24", defaultWidth = 24.0.dp, defaultHeight =
                24.0.dp, viewportWidth = 960.0f, viewportHeight = 960.0f).apply {
            path(fill = SolidColor(Color(0xFFe3e3e3)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(380.0f, 640.0f)
                quadToRelative(-109.0f, 0.0f, -184.5f, -75.5f)
                reflectiveQuadTo(120.0f, 380.0f)
                quadToRelative(0.0f, -109.0f, 75.5f, -184.5f)
                reflectiveQuadTo(380.0f, 120.0f)
                quadToRelative(109.0f, 0.0f, 184.5f, 75.5f)
                reflectiveQuadTo(640.0f, 380.0f)
                quadToRelative(0.0f, 44.0f, -14.0f, 83.0f)
                reflectiveQuadToRelative(-38.0f, 69.0f)
                lineToRelative(224.0f, 224.0f)
                quadToRelative(11.0f, 11.0f, 11.0f, 28.0f)
                reflectiveQuadToRelative(-11.0f, 28.0f)
                quadToRelative(-11.0f, 11.0f, -28.0f, 11.0f)
                reflectiveQuadToRelative(-28.0f, -11.0f)
                lineTo(532.0f, 588.0f)
                quadToRelative(-30.0f, 24.0f, -69.0f, 38.0f)
                reflectiveQuadToRelative(-83.0f, 14.0f)
                close()
                moveTo(380.0f, 560.0f)
                quadToRelative(75.0f, 0.0f, 127.5f, -52.5f)
                reflectiveQuadTo(560.0f, 380.0f)
                quadToRelative(0.0f, -75.0f, -52.5f, -127.5f)
                reflectiveQuadTo(380.0f, 200.0f)
                quadToRelative(-75.0f, 0.0f, -127.5f, 52.5f)
                reflectiveQuadTo(200.0f, 380.0f)
                quadToRelative(0.0f, 75.0f, 52.5f, 127.5f)
                reflectiveQuadTo(380.0f, 560.0f)
                close()
            }
        }
        .build()
        return _search24dpE3e3e3Fill0Wght0Grad0Opsz24!!
    }

private var _search24dpE3e3e3Fill0Wght0Grad0Opsz24: ImageVector? = null
