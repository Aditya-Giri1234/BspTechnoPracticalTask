package com.aditya.bsptechnopracticaltask.ui.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.aditya.bsptechnopracticaltask.ui.components.AddVerticalSpace

@Composable
fun ErrorText(modifier: Modifier = Modifier, text: String , onRetry : (()-> Unit)? = null) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text, style = MaterialTheme.typography.titleLarge.copy(
                    color = Color.Red,
                    fontWeight = FontWeight.SemiBold
                )
            )
            AddVerticalSpace(20)
            AnimatedVisibility(onRetry!=null) {
                Button(onClick = onRetry!! , colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black.copy(
                        alpha = .8f
                    )
                ) , modifier = Modifier.padding(horizontal = 20.dp)) {
                    Text("Retry" , color = Color.White)
                }
            }
        }
    }
}