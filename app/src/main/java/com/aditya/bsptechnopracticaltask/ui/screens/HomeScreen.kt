package com.aditya.bsptechnopracticaltask.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.aditya.bsptechnopracticaltask.common.models.ApiResponse
import com.aditya.bsptechnopracticaltask.ui.viewmodels.HomeScreenViewModel
import com.aditya.bsptechnopracticaltask.ui.widgets.ErrorText
import com.aditya.bsptechnopracticaltask.ui.widgets.InitialText
import com.aditya.bsptechnopracticaltask.ui.widgets.Loader

@Composable
fun HomeScreen(homeScreenViewModel: HomeScreenViewModel) {

    val context = LocalContext.current

    val bookResponse by homeScreenViewModel.bookResponse.collectAsStateWithLifecycle(ApiResponse.Initial())

    LaunchedEffect(Unit) {
        homeScreenViewModel.getBooksData(context)
    }

    Scaffold { innerPadding ->
        LazyColumn(
            modifier = Modifier.padding(innerPadding)
        ) {
            when (val value = bookResponse) {
                is ApiResponse.Initial -> {
                    item {
                        InitialText(modifier = Modifier.fillMaxSize(), "No Data Available!")
                    }
                }

                is ApiResponse.Success -> {

                }

                is ApiResponse.Loading -> {
                    item {
                        Loader(modifier = Modifier.fillMaxSize(), "Data is Loading...")
                    }
                }

                is ApiResponse.Error -> {
                    item {
                        ErrorText(modifier = Modifier.fillMaxSize(), value.message)
                    }
                }
            }
        }
    }
}