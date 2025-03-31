package com.aditya.bsptechnopracticaltask.ui.widgets.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
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
                it.elementType != null && it.elementType == ElementType.FEATURED.elementType
            }
        }
    }

    AnimatedVisibility(
        data != null,
        modifier = modifier
    ) {
        Column(Modifier.fillMaxWidth()) {
            Text(
                data?.header ?: "",
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = Color.Black.copy(
                        alpha = .6f
                    ),
                    fontWeight = FontWeight.Medium
                )
            )
            AddVerticalSpace(15)
            data?.componentItems?.let { data1 ->
                LazyRow(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(data1) { item ->
                        Card(
                            modifier = Modifier
                                .background(
                                    Brush.verticalGradient(
                                        listOf(
                                            Color.White,
                                            Color.Gray.copy(
                                                alpha = .7f
                                            )
                                        ),
                                    )
                                )
                                .padding(10.dp),
                            elevation = CardDefaults.cardElevation(
                                defaultElevation = 4.dp
                            )
                        ) {
                            Column(
                                modifier = Modifier.fillMaxSize(),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                ImageLoading(
                                    item.imageUrl ?: "",
                                    Modifier
                                        .height(150.dp)
                                        .fillMaxWidth(.8f)
                                        .clip(RoundedCornerShape(10.dp))
                                )
                                AddVerticalSpace(10)
                                Text(
                                    item.mediaData?.title ?: "",
                                    style = MaterialTheme.typography.bodyMedium.copy(
                                        color = Color.Black,
                                        fontWeight = FontWeight.SemiBold
                                    )
                                )
                                AddVerticalSpace(5)
                                Text(
                                    item.mediaData?.description ?: "",
                                    style = MaterialTheme.typography.bodyMedium.copy(
                                        color = Color.Black,
                                        fontWeight = FontWeight.SemiBold
                                    ),
                                    maxLines = 3,
                                    overflow = TextOverflow.Ellipsis
                                )
                                AddVerticalSpace(10)
                                TextButton(
                                    onClick = {

                                    },
                                    modifier = Modifier.clip(RoundedCornerShape(10.dp)).border(1.dp , color = Color.Red.copy(
                                        alpha = .8f
                                    ))
                                ) {
                                    Text("Listen Now")
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}