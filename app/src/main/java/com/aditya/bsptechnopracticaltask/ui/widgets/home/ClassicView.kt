package com.aditya.bsptechnopracticaltask.ui.widgets.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.aditya.bsptechnopracticaltask.common.utils.ElementType
import com.aditya.bsptechnopracticaltask.domain.models.BookResponse
import com.aditya.bsptechnopracticaltask.ui.components.AddHorizontalSpace
import com.aditya.bsptechnopracticaltask.ui.components.AddVerticalSpace
import com.aditya.bsptechnopracticaltask.ui.components.ImageLoading
import com.aditya.bsptechnopracticaltask.ui.theme.DarkGreen

@Composable
fun ClassicView(modifier: Modifier = Modifier, response: BookResponse) {
    val data by remember {
        derivedStateOf {
            response.page?.elements?.find {
                it.elementType != null && it.elementType == ElementType.CLASSIC.elementType
            }
        }
    }

    AnimatedVisibility(
        data != null,
        modifier = modifier
    ) {
        Column(Modifier.fillMaxWidth()) {
            Row(Modifier.fillMaxWidth().padding(10.dp), horizontalArrangement = Arrangement.SpaceBetween) {
                Column {
                    Text(
                        data?.header ?: "",
                        style = MaterialTheme.typography.titleMedium.copy(
                            color = Color.Black,
                            fontWeight = FontWeight.Medium
                        )
                    )
                    AddVerticalSpace(5)
                    Text(
                        data?.subheader ?: "",
                        style = MaterialTheme.typography.bodySmall.copy(
                            color = Color.Black.copy(
                                alpha = .7f
                            ),
                            fontWeight = FontWeight.Light
                        )
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.Center ,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "See All",
                        style = MaterialTheme.typography.bodySmall.copy(
                            color = DarkGreen,
                            fontWeight = FontWeight.SemiBold
                        )
                    )
                    Icon(
                        Icons.AutoMirrored.Filled.KeyboardArrowRight,
                        tint = DarkGreen,
                        contentDescription = ""
                    )
                }
            }

            AddVerticalSpace(5)
            data?.componentItems?.let { data1 ->
                LazyRow(
                    Modifier.fillMaxWidth().padding(start = 10.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(data1) {
                        ImageLoading(
                            it.mediaData?.cover?.fullUrl ?: "",
                            Modifier
                                .width(150.dp)
                                .height(200.dp)
                                .clip(RoundedCornerShape(10.dp))
                        )
                    }
                }
            }
        }
    }
}