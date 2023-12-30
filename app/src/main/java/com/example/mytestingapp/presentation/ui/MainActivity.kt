package com.example.mytestingapp.presentation.theme.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.mytestingapp.presentation.ui.composables.DrawPaths
import com.example.mytestingapp.presentation.ui.composables.LazyListsCompose
import com.example.mytestingapp.presentation.ui.composables.ListsCompose
import com.example.mytestingapp.presentation.ui.composables.SimpleAnimation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            TextFieldButtonsAndSnackbarsCompose()
            SimpleAnimation()
//            ListsCompose()
//            LazyListsCompose()
//            DrawPaths()
        }
    }
}


