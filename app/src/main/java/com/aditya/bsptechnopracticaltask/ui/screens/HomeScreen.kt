package com.aditya.bsptechnopracticaltask.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.material3.pulltorefresh.PullToRefreshState
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.aditya.bsptechnopracticaltask.common.models.ApiResponse
import com.aditya.bsptechnopracticaltask.common.utils.Constants
import com.aditya.bsptechnopracticaltask.common.utils.ElementType
import com.aditya.bsptechnopracticaltask.domain.models.BookResponse
import com.aditya.bsptechnopracticaltask.domain.models.Element
import com.aditya.bsptechnopracticaltask.ui.components.AddVerticalSpace
import com.aditya.bsptechnopracticaltask.ui.viewmodels.HomeScreenViewModel
import com.aditya.bsptechnopracticaltask.ui.widgets.ErrorText
import com.aditya.bsptechnopracticaltask.ui.widgets.InitialText
import com.aditya.bsptechnopracticaltask.ui.widgets.Loader
import com.aditya.bsptechnopracticaltask.ui.widgets.home.BannerView
import com.aditya.bsptechnopracticaltask.ui.widgets.home.CarousalView
import com.aditya.bsptechnopracticaltask.ui.widgets.home.ClassicView
import com.aditya.bsptechnopracticaltask.ui.widgets.home.FeaturedView
import com.aditya.bsptechnopracticaltask.ui.widgets.home.GroupContentView

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(homeScreenViewModel: HomeScreenViewModel) {

    val context = LocalContext.current
    var isLoading by remember { mutableStateOf(false) }
    val pullToRefreshState = rememberPullToRefreshState()

    val bookResponse by homeScreenViewModel.bookResponse.collectAsStateWithLifecycle(ApiResponse.Initial())

    LaunchedEffect(Unit) {
        homeScreenViewModel.getBooksData(context)
    }

    Scaffold { innerPadding ->

        when (val value = bookResponse) {
            is ApiResponse.Initial -> {
                Box(
                    Modifier
                        .padding(innerPadding)
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    InitialText(modifier = Modifier.fillMaxSize(), "No Data Available!")
                }
            }

            is ApiResponse.Success -> {
                isLoading = false
                ShowData(innerPadding, pullToRefreshState, value.data , isLoading, onRefresh = {
                    isLoading = true
                    homeScreenViewModel.getBooksData(context, true)
                })
            }

            is ApiResponse.Loading -> {
                Box(
                    Modifier
                        .padding(innerPadding)
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Loader(modifier = Modifier.fillMaxSize(), "Data is Loading...")
                }
            }

            is ApiResponse.Error -> {
                Box(
                    Modifier
                        .padding(innerPadding)
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    isLoading = false
                    ErrorText(modifier = Modifier.fillMaxSize(), value.message , onRetry = {
                        homeScreenViewModel.getBooksData(context, false)
                    })
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ShowData(
    innerPadding: PaddingValues,
    pullToRefreshState: PullToRefreshState,
    response: BookResponse,
    isLoading : Boolean,
    onRefresh: () -> Unit
) {
    PullToRefreshBox(
        modifier = Modifier
            .testTag(Constants.PULL_TO_REFRESH)
            .padding(innerPadding)
            .fillMaxSize(),
        state = pullToRefreshState,
        isRefreshing = isLoading,
        onRefresh = onRefresh
    ) {
        LazyColumn(
            modifier = Modifier.testTag(Constants.OUTER_LAZY_COLUMN).fillMaxSize()
        ) {
            this@LazyColumn.HandleSuccessResponse(Modifier.fillMaxSize(), response)
        }
    }
}

private fun LazyListScope.HandleSuccessResponse(
    modifier: Modifier = Modifier,
    response: BookResponse
) {
    item {
        BannerView(Modifier.fillMaxWidth(), response)
        AddVerticalSpace(10)
        CarousalView(Modifier.fillMaxWidth(), response)
        AddVerticalSpace(10)
        ClassicView(Modifier.fillMaxWidth(), response)
        AddVerticalSpace(10)
        FeaturedView(Modifier.fillMaxWidth(), response)
        AddVerticalSpace(10)
    }
// Extract the required element only once
    response.findElement(ElementType.GROUP_CONTENT)?.let { groupContent ->
        GroupContentView(Modifier.fillMaxWidth(), groupContent)
    }
}

/**
 * Extracts the first matching element of the given [elementType] from the response.
 */
private fun BookResponse.findElement(elementType: ElementType): Element? {
    return page?.elements?.find { it.elementType == elementType.elementType }
}