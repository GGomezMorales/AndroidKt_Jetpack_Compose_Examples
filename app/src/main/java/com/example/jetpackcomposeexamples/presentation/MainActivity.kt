package com.example.jetpackcomposeexamples.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.jetpackcomposeexamples.presentation.ui.composables.CircularProgressBar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            CircularProgressBar(percentage = 0.8f, maxNumber = 100)

//            AppNavigation()
        }
    }
}


