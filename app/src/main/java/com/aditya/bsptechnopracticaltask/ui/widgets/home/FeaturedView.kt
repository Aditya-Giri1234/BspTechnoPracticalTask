package com.aditya.bsptechnopracticaltask.ui.widgets.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.core.text.HtmlCompat
import com.aditya.bsptechnopracticaltask.common.utils.ElementType
import com.aditya.bsptechnopracticaltask.domain.models.BookResponse
import com.aditya.bsptechnopracticaltask.ui.components.AddVerticalSpace
import com.aditya.bsptechnopracticaltask.ui.components.ImageLoading
import retrofit2.Response

@Composable
fun FeaturedView(modifier: Modifier = Modifier, response: BookResponse) {
    val data by remember {
        derivedStateOf {
            response.page?.elements?.find {
                it.elementType == ElementType.FEATURED.elementType
            }
        }
    }

    AnimatedVisibility(
        visible = data != null,
        modifier = modifier
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 5.dp) // Adjust padding for better spacing
        ) {
            Text(
                text = data?.header.orEmpty(),
                style = MaterialTheme.typography.titleMedium.copy(
                    color = Color.Black,
                    fontWeight = FontWeight.Medium
                )
            )
            AddVerticalSpace(10)

            data?.componentItems?.let { items ->
                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(items) { item ->
                        Card(
                            modifier = Modifier
                                .width(250.dp),
                            elevation = CardDefaults.cardElevation(defaultElevation = 1.dp), // Slightly increased elevation
                            colors = CardDefaults.cardColors(containerColor = Color.White), // Set white instead of transparent
                            shape = RoundedCornerShape(12.dp) // Slightly rounded edges for a modern look
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(
                                        Brush.verticalGradient(
                                            listOf(
                                                Color.White,
                                                Color.LightGray.copy(alpha = 0.4f)
                                            )
                                        )
                                    )
                                    .padding(12.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                ImageLoading(
                                    imageUrl = item.mediaData?.cover?.fullUrl.orEmpty(),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .aspectRatio(2f/2f)
                                        .clip(RoundedCornerShape(10.dp)) ,
                                    contentScale = ContentScale.FillBounds
                                )
                                AddVerticalSpace(8)
                                Text(
                                    text = item.mediaData?.title.orEmpty(),
                                    style = MaterialTheme.typography.bodyMedium.copy(
                                        color = Color.Black,
                                        fontWeight = FontWeight.SemiBold
                                    ),
                                    maxLines = 2,
                                    overflow = TextOverflow.Ellipsis
                                )
                                AddVerticalSpace(5)
                                Text(
                                    text = HtmlCompat.fromHtml(item.mediaData?.description.orEmpty(), 0).toString(),
                                    style = MaterialTheme.typography.bodySmall.copy(
                                        color = Color.Gray,
                                        fontWeight = FontWeight.Normal
                                    ),
                                    maxLines = 3,
                                    overflow = TextOverflow.Ellipsis
                                )
                                AddVerticalSpace(8)
                                TextButton(
                                    onClick = { },
                                    modifier = Modifier
                                        .border(1.dp, Color.Red.copy(alpha = 0.8f), RoundedCornerShape(10.dp))
                                        .clip(RoundedCornerShape(10.dp))
                                ) {
                                    Text("Listen Now", color = Color.Red)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
