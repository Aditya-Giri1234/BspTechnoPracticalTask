package com.aditya.bsptechnopracticaltask.ui.viewmodels

import android.content.Context
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.isDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.test.core.app.ApplicationProvider
import androidx.test.runner.AndroidJUnitRunner
import com.aditya.bsptechnopracticaltask.common.utils.Constants
import com.aditya.bsptechnopracticaltask.common.utils.SoftwareManager
import com.aditya.bsptechnopracticaltask.data.local.datastore.SessionManager
import com.aditya.bsptechnopracticaltask.data.remote.BookService
import com.aditya.bsptechnopracticaltask.domain.repo.BookApiRepo
import com.aditya.bsptechnopracticaltask.domain.repo.LocalBooksRepo
import com.aditya.bsptechnopracticaltask.ui.screens.HomeScreen
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import javax.inject.Inject


@HiltAndroidTest
class HomeScreenViewModelTest {

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get: Rule(order = 1)
    val createComposeRule = createComposeRule()


    @Inject
    lateinit var sessionManager: SessionManager

    @Inject
    lateinit var bookApiRepo: BookApiRepo

    @Inject
    lateinit var localBooksRepo: LocalBooksRepo

    private lateinit var homeScreenViewModel: HomeScreenViewModel

    private val testDispatcher = StandardTestDispatcher()

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher) // Override Dispatchers.Main for testing coroutines
        hiltRule.inject() // Hilt injects dependencies
        homeScreenViewModel = HomeScreenViewModel(sessionManager, bookApiRepo, localBooksRepo)
        createComposeRule.setContent {
            HomeScreen(homeScreenViewModel)
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun tearDown(){
        Dispatchers.resetMain() // Reset the dispatcher after tests
    }

    @Test
    fun checkBookDataCome() {
        createComposeRule.waitUntil(timeoutMillis = 5000) {
            // Check if ViewModel state has changed (e.g., bookResponse emits data)
            homeScreenViewModel.bookResponse.replayCache.isNotEmpty()
        }
    }

}