package com.aditya.bsptechnopracticaltask.ui.widgets.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.aditya.bsptechnopracticaltask.common.utils.ElementType
import com.aditya.bsptechnopracticaltask.domain.models.BookResponse
import com.aditya.bsptechnopracticaltask.ui.components.ImageLoading

@Composable
fun BannerView(modifier: Modifier = Modifier, data: BookResponse) {
    val bannerData by remember {
        derivedStateOf {
            data.page?.elements?.find {
                it.elementType != null && it.elementType == ElementType.BANNER.elementType
            }
        }
    }

    AnimatedVisibility(
        bannerData != null,
        modifier = modifier
    ) {
        bannerData?.mobileImageUrl?.let {
            ImageLoading(it , Modifier.fillMaxWidth().height(200.dp))
        }
    }
}