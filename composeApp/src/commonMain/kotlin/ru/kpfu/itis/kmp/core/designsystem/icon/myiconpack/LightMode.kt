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

public val IconPack.LightMode: ImageVector
    get() {
        if (_lightmode != null) {
            return _lightmode!!
        }
        _lightmode = Builder(name = "Lightmode", defaultWidth = 24.0.dp, defaultHeight = 24.0.dp,
                viewportWidth = 960.0f, viewportHeight = 960.0f).apply {
            path(fill = SolidColor(Color(0xFFe3e3e3)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(480.0f, 600.0f)
                quadToRelative(50.0f, 0.0f, 85.0f, -35.0f)
                reflectiveQuadToRelative(35.0f, -85.0f)
                quadToRelative(0.0f, -50.0f, -35.0f, -85.0f)
                reflectiveQuadToRelative(-85.0f, -35.0f)
                quadToRelative(-50.0f, 0.0f, -85.0f, 35.0f)
                reflectiveQuadToRelative(-35.0f, 85.0f)
                quadToRelative(0.0f, 50.0f, 35.0f, 85.0f)
                reflectiveQuadToRelative(85.0f, 35.0f)
                close()
                moveTo(480.0f, 680.0f)
                quadToRelative(-83.0f, 0.0f, -141.5f, -58.5f)
                reflectiveQuadTo(280.0f, 480.0f)
                quadToRelative(0.0f, -83.0f, 58.5f, -141.5f)
                reflectiveQuadTo(480.0f, 280.0f)
                quadToRelative(83.0f, 0.0f, 141.5f, 58.5f)
                reflectiveQuadTo(680.0f, 480.0f)
                quadToRelative(0.0f, 83.0f, -58.5f, 141.5f)
                reflectiveQuadTo(480.0f, 680.0f)
                close()
                moveTo(80.0f, 520.0f)
                quadToRelative(-17.0f, 0.0f, -28.5f, -11.5f)
                reflectiveQuadTo(40.0f, 480.0f)
                quadToRelative(0.0f, -17.0f, 11.5f, -28.5f)
                reflectiveQuadTo(80.0f, 440.0f)
                horizontalLineToRelative(80.0f)
                quadToRelative(17.0f, 0.0f, 28.5f, 11.5f)
                reflectiveQuadTo(200.0f, 480.0f)
                quadToRelative(0.0f, 17.0f, -11.5f, 28.5f)
                reflectiveQuadTo(160.0f, 520.0f)
                lineTo(80.0f, 520.0f)
                close()
                moveTo(800.0f, 520.0f)
                quadToRelative(-17.0f, 0.0f, -28.5f, -11.5f)
                reflectiveQuadTo(760.0f, 480.0f)
                quadToRelative(0.0f, -17.0f, 11.5f, -28.5f)
                reflectiveQuadTo(800.0f, 440.0f)
                horizontalLineToRelative(80.0f)
                quadToRelative(17.0f, 0.0f, 28.5f, 11.5f)
                reflectiveQuadTo(920.0f, 480.0f)
                quadToRelative(0.0f, 17.0f, -11.5f, 28.5f)
                reflectiveQuadTo(880.0f, 520.0f)
                horizontalLineToRelative(-80.0f)
                close()
                moveTo(480.0f, 200.0f)
                quadToRelative(-17.0f, 0.0f, -28.5f, -11.5f)
                reflectiveQuadTo(440.0f, 160.0f)
                verticalLineToRelative(-80.0f)
                quadToRelative(0.0f, -17.0f, 11.5f, -28.5f)
                reflectiveQuadTo(480.0f, 40.0f)
                quadToRelative(17.0f, 0.0f, 28.5f, 11.5f)
                reflectiveQuadTo(520.0f, 80.0f)
                verticalLineToRelative(80.0f)
                quadToRelative(0.0f, 17.0f, -11.5f, 28.5f)
                reflectiveQuadTo(480.0f, 200.0f)
                close()
                moveTo(480.0f, 920.0f)
                quadToRelative(-17.0f, 0.0f, -28.5f, -11.5f)
                reflectiveQuadTo(440.0f, 880.0f)
                verticalLineToRelative(-80.0f)
                quadToRelative(0.0f, -17.0f, 11.5f, -28.5f)
                reflectiveQuadTo(480.0f, 760.0f)
                quadToRelative(17.0f, 0.0f, 28.5f, 11.5f)
                reflectiveQuadTo(520.0f, 800.0f)
                verticalLineToRelative(80.0f)
                quadToRelative(0.0f, 17.0f, -11.5f, 28.5f)
                reflectiveQuadTo(480.0f, 920.0f)
                close()
                moveTo(226.0f, 282.0f)
                lineToRelative(-43.0f, -42.0f)
                quadToRelative(-12.0f, -11.0f, -11.5f, -28.0f)
                reflectiveQuadToRelative(11.5f, -29.0f)
                quadToRelative(12.0f, -12.0f, 29.0f, -12.0f)
                reflectiveQuadToRelative(28.0f, 12.0f)
                lineToRelative(42.0f, 43.0f)
                quadToRelative(11.0f, 12.0f, 11.0f, 28.0f)
                reflectiveQuadToRelative(-11.0f, 28.0f)
                quadToRelative(-11.0f, 12.0f, -27.5f, 11.5f)
                reflectiveQuadTo(226.0f, 282.0f)
                close()
                moveTo(720.0f, 777.0f)
                lineTo(678.0f, 734.0f)
                quadToRelative(-11.0f, -12.0f, -11.0f, -28.5f)
                reflectiveQuadToRelative(11.0f, -27.5f)
                quadToRelative(11.0f, -12.0f, 27.5f, -11.5f)
                reflectiveQuadTo(734.0f, 678.0f)
                lineToRelative(43.0f, 42.0f)
                quadToRelative(12.0f, 11.0f, 11.5f, 28.0f)
                reflectiveQuadTo(777.0f, 777.0f)
                quadToRelative(-12.0f, 12.0f, -29.0f, 12.0f)
                reflectiveQuadToRelative(-28.0f, -12.0f)
                close()
                moveTo(678.0f, 282.0f)
                quadToRelative(-12.0f, -11.0f, -11.5f, -27.5f)
                reflectiveQuadTo(678.0f, 226.0f)
                lineToRelative(42.0f, -43.0f)
                quadToRelative(11.0f, -12.0f, 28.0f, -11.5f)
                reflectiveQuadToRelative(29.0f, 11.5f)
                quadToRelative(12.0f, 12.0f, 12.0f, 29.0f)
                reflectiveQuadToRelative(-12.0f, 28.0f)
                lineToRelative(-43.0f, 42.0f)
                quadToRelative(-12.0f, 11.0f, -28.0f, 11.0f)
                reflectiveQuadToRelative(-28.0f, -11.0f)
                close()
                moveTo(183.0f, 777.0f)
                quadToRelative(-12.0f, -12.0f, -12.0f, -29.0f)
                reflectiveQuadToRelative(12.0f, -28.0f)
                lineToRelative(43.0f, -42.0f)
                quadToRelative(12.0f, -11.0f, 28.5f, -11.0f)
                reflectiveQuadToRelative(27.5f, 11.0f)
                quadToRelative(12.0f, 11.0f, 11.5f, 27.5f)
                reflectiveQuadTo(282.0f, 734.0f)
                lineToRelative(-42.0f, 43.0f)
                quadToRelative(-11.0f, 12.0f, -28.0f, 11.5f)
                reflectiveQuadTo(183.0f, 777.0f)
                close()
                moveTo(480.0f, 480.0f)
                close()
            }
        }
        .build()
        return _lightmode!!
    }

private var _lightmode: ImageVector? = null
