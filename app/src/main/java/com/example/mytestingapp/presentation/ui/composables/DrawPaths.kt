package com.example.mytestingapp.presentation.ui.composables

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.tooling.preview.Preview

@Preview(showSystemUi = true)
@Composable
fun DrawPaths() {
    BoxWithConstraints {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val path = Path().apply {
                moveTo(0f, 500f)
                quadraticBezierTo(150f, 50f, 200f, 100f)
                lineTo(250f, 100f)
                quadraticBezierTo(300f, 150f, 250f, 200f)
                lineTo(200f, 200f)
                quadraticBezierTo(150f, 250f, 100f, 200f)
                lineTo(100f, 100f)
            }
            drawPath(path, color = Color.DarkGray)
        }
    }
}
