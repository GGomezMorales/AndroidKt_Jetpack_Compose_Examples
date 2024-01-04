package com.example.mytestingapp.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.mytestingapp.presentation.ui.composables.DrawPaths
import com.example.mytestingapp.presentation.ui.composables.LazyListsCompose
import com.example.mytestingapp.presentation.ui.composables.ListsCompose
import com.example.mytestingapp.presentation.ui.composables.SimpleAnimation
import com.example.mytestingapp.presentation.ui.composables.Unit1BirthdayCard

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize()
            ) {
//                TextFieldButtonsAndSnackbarsCompose()
//                SimpleAnimation()
//                ListsCompose()
//                LazyListsCompose()
//                DrawPaths()
                Unit1BirthdayCard()
            }

        }
    }
}


