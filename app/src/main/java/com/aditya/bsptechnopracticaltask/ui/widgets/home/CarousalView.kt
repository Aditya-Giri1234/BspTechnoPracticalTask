package com.aditya.bsptechnopracticaltask.ui.widgets.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.aditya.bsptechnopracticaltask.common.utils.ElementType
import com.aditya.bsptechnopracticaltask.domain.models.BookResponse
import com.aditya.bsptechnopracticaltask.ui.components.AddVerticalSpace
import com.aditya.bsptechnopracticaltask.ui.components.ImageLoading

@Composable
fun CarousalView(modifier: Modifier = Modifier, response: BookResponse) {
    val data by remember {
        derivedStateOf {
            response.page?.elements?.find {
                it.elementType != null && it.elementType == ElementType.CAROUSEL.elementType
            }
        }
    }

    AnimatedVisibility(
        data != null,
        modifier = modifier
    ) {
        Column(Modifier.fillMaxWidth().padding(10.dp)) {
            Text(
                data?.header ?: "",
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = Color.Black.copy(
                        alpha = .6f
                    ),
                    fontWeight = FontWeight.Medium
                )
            )
            AddVerticalSpace(5)
            Text(
                data?.subheader ?: "",
                style = MaterialTheme.typography.titleSmall.copy(
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold
                )
            )
            AddVerticalSpace(5)
            data?.componentItems?.let { data1 ->
                LazyRow(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(data1) {
                        ImageLoading(
                            it.imageUrl ?: "",
                            Modifier
                                .height(150.dp)
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(10.dp))
                        )
                    }
                }
            }
        }
    }
}