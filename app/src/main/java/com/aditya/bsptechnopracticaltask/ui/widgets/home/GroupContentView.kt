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
import androidx.compose.foundation.layout.wrapContentWidth
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
import com.aditya.bsptechnopracticaltask.domain.models.Element
import com.aditya.bsptechnopracticaltask.ui.components.AddHorizontalSpace
import com.aditya.bsptechnopracticaltask.ui.components.AddVerticalSpace
import com.aditya.bsptechnopracticaltask.ui.components.ImageLoading
import com.aditya.bsptechnopracticaltask.ui.theme.DarkGreen

fun LazyListScope.GroupContentView(modifier: Modifier = Modifier, data: Element?) {

    item {
        AnimatedVisibility(
            data != null,
            modifier = modifier
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = data?.header.orEmpty(),
                    style = MaterialTheme.typography.titleMedium.copy(
                        color = Color.Black,
                        fontWeight = FontWeight.Medium
                    ),
                    maxLines = 1, // Ensure text remains on one line
                    overflow = TextOverflow.Ellipsis, // Show "..." if text is too long
                    modifier = Modifier.weight(1f)
                )

                Row(
                    modifier = Modifier.wrapContentWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "See All",
                        style = MaterialTheme.typography.bodySmall.copy(
                            color = DarkGreen,
                            fontWeight = FontWeight.SemiBold
                        )
                    )
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                        tint = DarkGreen,
                        contentDescription = null
                    )
                }
            }

            AddVerticalSpace(15)
        }
    }

    data?.componentItems?.let { data1 ->
        items(data1) { item ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp), // Padding should be applied outside
                colors = CardDefaults.cardColors(containerColor = Color.LightGray.copy(
                    alpha = .2f
                )) // Make card transparent so gradient is visible
            ) {
                Row(
                    modifier = Modifier.fillMaxSize().padding(12.dp),
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
                            style = MaterialTheme.typography.bodySmall.copy(
                                color = Color.Black.copy(
                                    alpha = .8f
                                ),
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