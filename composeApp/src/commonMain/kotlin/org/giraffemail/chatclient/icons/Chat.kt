/*
* Converted using https://composables.com/svgtocompose
*/

import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

public val ChatIcon: ImageVector
    get() {
        if (_Chat != null) {
            return _Chat!!
        }
        _Chat = ImageVector.Builder(
            name = "Chat",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF5F6368)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(240f, 560f)
                horizontalLineToRelative(320f)
                verticalLineToRelative(-80f)
                horizontalLineTo(240f)
                verticalLineToRelative(80f)
                close()
                moveToRelative(0f, -120f)
                horizontalLineToRelative(480f)
                verticalLineToRelative(-80f)
                horizontalLineTo(240f)
                verticalLineToRelative(80f)
                close()
                moveToRelative(0f, -120f)
                horizontalLineToRelative(480f)
                verticalLineToRelative(-80f)
                horizontalLineTo(240f)
                verticalLineToRelative(80f)
                close()
                moveTo(80f, 880f)
                verticalLineToRelative(-720f)
                quadToRelative(0f, -33f, 23.5f, -56.5f)
                reflectiveQuadTo(160f, 80f)
                horizontalLineToRelative(640f)
                quadToRelative(33f, 0f, 56.5f, 23.5f)
                reflectiveQuadTo(880f, 160f)
                verticalLineToRelative(480f)
                quadToRelative(0f, 33f, -23.5f, 56.5f)
                reflectiveQuadTo(800f, 720f)
                horizontalLineTo(240f)
                lineTo(80f, 880f)
                close()
                moveToRelative(126f, -240f)
                horizontalLineToRelative(594f)
                verticalLineToRelative(-480f)
                horizontalLineTo(160f)
                verticalLineToRelative(525f)
                lineToRelative(46f, -45f)
                close()
                moveToRelative(-46f, 0f)
                verticalLineToRelative(-480f)
                verticalLineToRelative(480f)
                close()
            }
        }.build()
        return _Chat!!
    }

private var _Chat: ImageVector? = null
