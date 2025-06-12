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

public val IconPack.HomeFill: ImageVector
    get() {
        if (home24dpE3e3e3Fill1Wght400Grad0Opsz24 != null) {
            return home24dpE3e3e3Fill1Wght400Grad0Opsz24!!
        }
        home24dpE3e3e3Fill1Wght400Grad0Opsz24 = Builder(name =
                "Home24dpE3e3e3Fill1Wght400Grad0Opsz24", defaultWidth = 24.0.dp, defaultHeight =
                24.0.dp, viewportWidth = 960.0f, viewportHeight = 960.0f).apply {
            path(fill = SolidColor(Color(0xFFe3e3e3)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(160.0f, 840.0f)
                verticalLineToRelative(-480.0f)
                lineToRelative(320.0f, -240.0f)
                lineToRelative(320.0f, 240.0f)
                verticalLineToRelative(480.0f)
                lineTo(560.0f, 840.0f)
                verticalLineToRelative(-280.0f)
                lineTo(400.0f, 560.0f)
                verticalLineToRelative(280.0f)
                lineTo(160.0f, 840.0f)
                close()
            }
        }
        .build()
        return home24dpE3e3e3Fill1Wght400Grad0Opsz24!!
    }

private var home24dpE3e3e3Fill1Wght400Grad0Opsz24: ImageVector? = null
