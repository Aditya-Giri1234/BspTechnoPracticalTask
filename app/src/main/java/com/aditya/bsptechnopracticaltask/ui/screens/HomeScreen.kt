package com.aditya.bsptechnopracticaltask.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.aditya.bsptechnopracticaltask.common.models.ApiResponse
import com.aditya.bsptechnopracticaltask.domain.models.BookResponse
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
        PullToRefreshBox(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            state = pullToRefreshState,
            isRefreshing = isLoading,
            onRefresh = {
                isLoading = true
                if (!(bookResponse is ApiResponse.Loading || bookResponse is ApiResponse.Initial)) {
                    homeScreenViewModel.getBooksData(context, true)
                }
            }
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                when (val value = bookResponse) {
                    is ApiResponse.Initial -> {
                        item {
                            InitialText(modifier = Modifier.fillMaxSize(), "No Data Available!")
                        }
                    }

                    is ApiResponse.Success -> {
                        isLoading = false
                        item {
                            this@LazyColumn.HandleSuccessResponse(Modifier.fillMaxSize(), value.data)
                        }
                    }

                    is ApiResponse.Loading -> {
                        item {
                            Loader(modifier = Modifier.fillMaxSize(), "Data is Loading...")
                        }
                    }

                    is ApiResponse.Error -> {
                        item {
                            isLoading = false
                            ErrorText(modifier = Modifier.fillMaxSize(), value.message)
                        }
                    }
                }
            }
        }

    }
}

@Composable
private fun LazyListScope.HandleSuccessResponse(
    modifier: Modifier = Modifier,
    response: BookResponse
) {
    item{
        BannerView(Modifier.fillMaxWidth(), response)
        AddVerticalSpace(10)
        CarousalView(Modifier.fillMaxWidth(), response)
        AddVerticalSpace(10)
        ClassicView(Modifier.fillMaxWidth(), response)
        AddVerticalSpace(10)
        FeaturedView(Modifier.fillMaxWidth(), response)
        AddVerticalSpace(10)
    }
    GroupContentView(Modifier.fillMaxWidth(), response)
}