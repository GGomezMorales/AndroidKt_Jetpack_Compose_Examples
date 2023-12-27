package com.example.mytestingapp.presentation.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mytestingapp.R

@Composable
fun ListsCompose() {

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .verticalScroll(scrollState)
    ) {
        for (i in 1..50) {
            Text(
                text = "Item #$i",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp)
            )
            Divider(color = Color.Black, thickness = 5.dp)
        }
    }
}

@Composable
fun LazyListsCompose() {

    LazyColumn {
        itemsIndexed(
            listOf(
                "This",
                "is",
                "Jetpack",
                "Compose",
                "This",
                "Take",
                "Android",
                "Monokai",
                "Pro",
                "Developer",
                "Amazing",
                "LifeCycle",
                "Kotlin",
                "I get it",
                "Interesting",
                "Easy",
                "Hello world"
            )
        ) { index: Int, item: String ->
            Text(
                text = item + ", Index: " + index.toString(),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp)
            )
        }
//        items(5000) {
//            Text(
//                text = "Item #$it",
//                fontSize = 24.sp,
//                fontFamily = FontFamily(Font(R.font.varelaround_regular)),
//                fontWeight = FontWeight.Bold,
//                textAlign = TextAlign.Center,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(vertical = 12.dp)
//            )
//        }
    }
}