package com.example.jetpackcomposeexamples.presentation.ui.composables

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SimpleAnimation() {

    var sizeState by remember {
        mutableStateOf(200.dp)
    }

    val size by animateDpAsState(
        targetValue = sizeState,
        label = "",
//        animationSpec = tween(
//            durationMillis = 3000,
//            delayMillis = 300,
//            easing = LinearOutSlowInEasing
//        )
//    )
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioHighBouncy,
            stiffness = Spring.StiffnessLow
        )
//    )
//        keyframes {
//            durationMillis = 5000
//            sizeState at 0 with LinearOutSlowInEasing
//            sizeState * 1.5f at 1000 with FastOutLinearInEasing
//            sizeState * 2f at 5000
//        }
    )

    val infiniteTransition = rememberInfiniteTransition(label = "")
    val color by infiniteTransition.animateColor(
        initialValue = Color.Red,
        targetValue = Color.Green,
        animationSpec = infiniteRepeatable(
            tween(durationMillis = 2000),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    )

    Box(
        modifier = Modifier
            .size(size)
            .background(Color.DarkGray),
        contentAlignment = Alignment.Center
    ) {
        Button(
            onClick = {
                sizeState += 50.dp
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = color,
                contentColor = Color.Black
            )
        ) {
            Text(text = "Increase Size")
        }
    }
}