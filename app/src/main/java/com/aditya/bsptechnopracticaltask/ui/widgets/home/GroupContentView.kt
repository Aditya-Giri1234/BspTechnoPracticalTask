package com.aditya.bsptechnopracticaltask.ui.widgets.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.aditya.bsptechnopracticaltask.common.utils.ElementType
import com.aditya.bsptechnopracticaltask.domain.models.BookResponse
import com.aditya.bsptechnopracticaltask.ui.components.AddHorizontalSpace
import com.aditya.bsptechnopracticaltask.ui.components.AddVerticalSpace
import com.aditya.bsptechnopracticaltask.ui.components.ImageLoading

@Composable
fun LazyListScope.GroupContentView(modifier: Modifier = Modifier, response: BookResponse) {
    val data by remember {
        derivedStateOf {
            response.page?.elements?.find {
                it.elementType != null && it.elementType == ElementType.GROUP_CONTENT.elementType
            }
        }
    }

    AnimatedVisibility(
        data != null,
        modifier = modifier
    ) {
        item {
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text(
                    data?.header ?: "",
                    style = MaterialTheme.typography.headlineSmall.copy(
                        color = Color.Black,
                        fontWeight = FontWeight.Medium
                    )
                )
                Row() {
                    Text(
                        "See All",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            color = Color.Green,
                            fontWeight = FontWeight.SemiBold
                        )
                    )
                    AddHorizontalSpace(5)
                    Icon(
                        Icons.AutoMirrored.Filled.KeyboardArrowRight,
                        tint = Color.Green,
                        contentDescription = ""
                    )
                }
            }
            AddVerticalSpace(15)
        }
        data?.componentItems?.let { data1 ->
            items(data1) { item ->
                Card(
                    modifier = Modifier
                        .padding(10.dp), // Padding should be applied outside
                    elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.Transparent) // Make card transparent so gradient is visible
                ) {
                    Box(
                        modifier = Modifier
                            .background(
                                Brush.horizontalGradient( // Apply horizontal gradient
                                    listOf(
                                        Color.White,
                                        Color.Gray.copy(alpha = 0.2f)
                                    )
                                )
                            )
                            .padding(10.dp) // Inner padding for content
                    ) {
                        Row(
                            modifier = Modifier.fillMaxSize(),
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            ImageLoading(
                                item.mediaData?.cover?.fullUrl ?: "",
                                Modifier
                                    .height(100.dp)
                                    .width(90.dp)
                                    .clip(RoundedCornerShape(10.dp))
                            )
                            AddHorizontalSpace(10)
                            Column(
                                horizontalAlignment = Alignment.Start,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    item.mediaData?.title ?: "",
                                    style = MaterialTheme.typography.bodyMedium.copy(
                                        color = Color.Black,
                                        fontWeight = FontWeight.SemiBold
                                    )
                                )
                                AddVerticalSpace(5)
                                Text(
                                    item.mediaData?.authors?.firstOrNull()
                                        ?.let { "${it.firstName} ${it.lastName}" } ?: "",
                                    style = MaterialTheme.typography.bodyMedium.copy(
                                        color = Color.Black,
                                        fontWeight = FontWeight.Light
                                    ),
                                    maxLines = 3,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }
                        }
                    }
                }

            }
        }
    }
}