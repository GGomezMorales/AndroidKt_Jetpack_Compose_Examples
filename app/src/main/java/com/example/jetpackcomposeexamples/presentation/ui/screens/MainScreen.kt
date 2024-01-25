package com.example.jetpackcomposeexamples.presentation.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.jetpackcomposeexamples.presentation.Screens

@Composable
fun MainScreen(navController: NavController) {
    
    var text by remember {
        mutableStateOf<String?>("")
    }
    
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 50.dp),
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = text ?: "",
            onValueChange = {
                text = it ?: ""
            }
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            modifier= Modifier.align(Alignment.End),
            onClick = {
                navController.navigate(Screens.DetailsScreen.route+"/${text}")
        }) {
            Text(text = "To Details Screen")
        }
    }
}