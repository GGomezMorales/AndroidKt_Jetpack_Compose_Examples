package com.example.jetpackcomposeexamples.presentation.ui.composables

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun Timer(
    modifier: Modifier = Modifier,
    totalTime: Long,
    handleColor: Color,
    inactiveBarColor: Color,
    activeBarColor: Color,
    initialValue: Float = 1f,
    strokeWidth: Dp = 5.dp
) {
    var size by remember {
        mutableStateOf(IntSize.Zero)
    }
    var value by remember {
        mutableStateOf(initialValue)
    }
    var currentTime by remember {
        mutableStateOf(totalTime)
    }
    var isTimerRunning by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(key1 = currentTime, key2 = isTimerRunning) {
        if (currentTime > 0 && isTimerRunning) {
            delay(100L)
            currentTime -= 100L
            value = currentTime / totalTime.toFloat()
        }
    }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.onSizeChanged { size = it },
            contentAlignment = Alignment.Center
        ) {
            Canvas(modifier = modifier) {
                drawArc(
                    color = inactiveBarColor,
                    startAngle = -215f,
                    sweepAngle = 250f,
                    useCenter = false, // Change to true
                    size = Size(width = size.width.toFloat(), height = size.height.toFloat()),
                    style = Stroke(width = strokeWidth.toPx(), cap = StrokeCap.Round)
                )
                drawArc(
                    color = activeBarColor,
                    startAngle = -215f,
                    sweepAngle = 250f * value,
                    useCenter = false, // Change to true
                    size = Size(width = size.width.toFloat(), height = size.height.toFloat()),
                    style = Stroke(width = strokeWidth.toPx(), cap = StrokeCap.Round)
                )
                val center = Offset(x = size.width / 2f, y = size.height / 2f)
                val angleBeta = (250f * value + 145f) * (PI / 180f).toFloat()
                val radius = size.width / 2f
                val xPoint = cos(angleBeta) * radius
                val yPoint = sin(angleBeta) * radius
                drawPoints(
                    listOf(Offset(x = center.x + xPoint, y = center.y + yPoint)),
                    pointMode = PointMode.Points,
                    color = handleColor,
                    strokeWidth = (strokeWidth * 3f).toPx(),
                    cap = StrokeCap.Round
                )
            }
            Text(
                text = (currentTime / 1000L).toString(),
                fontSize = 44.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Button(
                modifier = Modifier.align(Alignment.BottomCenter),
                onClick = {
                    if (currentTime <= 0) {
                        currentTime = totalTime
                        isTimerRunning = true
                    } else {
                        isTimerRunning = !isTimerRunning
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (!isTimerRunning || currentTime <= 0L) Color.Green else Color.Red
                ),
                shape = RoundedCornerShape(5.dp)
            ) {
                Text(
                    text = if (isTimerRunning && currentTime > 0L) "Stop"
                    else if (!isTimerRunning && currentTime >= 0L) "Star"
                    else "Restart",
                    color = Color(0xFF101010)
                )
            }
        }
        Spacer(modifier = Modifier.height(32.dp))
        TextField(
            modifier = Modifier.fillMaxWidth(0.2f),
            value = (currentTime / 1000L).toString(),
            onValueChange = { currentTime = if (it == "") 0L else it.toLong() * 1000L },
            textStyle = TextStyle(
                color = Color.Black,
                textAlign = TextAlign.Center
            ),
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.LightGray,
                unfocusedContainerColor = Color.LightGray
            )
        )
    }
}