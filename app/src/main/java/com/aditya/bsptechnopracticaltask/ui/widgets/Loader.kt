package com.aditya.bsptechnopracticaltask.ui.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.aditya.bsptechnopracticaltask.ui.components.AddVerticalSpace

@Composable
fun Loader(modifier: Modifier = Modifier , text : String) {
    Box(
        modifier = modifier ,
        contentAlignment = Alignment.Center
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            CircularProgressIndicator(color = Color.Black)
            AddVerticalSpace(5)
            Text(text , style = MaterialTheme.typography.titleLarge.copy(
                color = Color.Black ,
                fontWeight = FontWeight.SemiBold
            ))
        }
    }
}