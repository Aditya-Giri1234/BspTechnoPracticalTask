package com.aditya.bsptechnopracticaltask.ui.viewmodels

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aditya.bsptechnopracticaltask.common.models.ApiResponse
import com.aditya.bsptechnopracticaltask.common.utils.Helper
import com.aditya.bsptechnopracticaltask.common.utils.SoftwareManager
import com.aditya.bsptechnopracticaltask.data.local.datastore.SessionManager
import com.aditya.bsptechnopracticaltask.domain.models.BookResponse
import com.aditya.bsptechnopracticaltask.domain.repo.BookApiRepo
import com.aditya.bsptechnopracticaltask.domain.repo.LocalBooksRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val sessionManager: SessionManager,
    private val bookApiRepo: BookApiRepo,
    private val localBooksRepo: LocalBooksRepo
) : ViewModel() {

    private val _bookResponse = MutableSharedFlow<ApiResponse<BookResponse>>(
        1, 64, BufferOverflow.DROP_OLDEST
    )
    val bookResponse = _bookResponse.asSharedFlow()

    private fun setLastTimeApiTimeStamp(timeStamp: Long) = viewModelScope.launch {
        sessionManager.setLastTimeApiTimeStamp(timeStamp)
    }

    fun getBooksData(context: Context, isRefresh: Boolean = false) =
        viewModelScope.launch(Dispatchers.IO) {
            _bookResponse.emit(ApiResponse.Loading())

            if (isRefresh) {
                if (Helper.isTwoHoursAgo(sessionManager.getLastTimeApiTimeStamp())) {
                    //fire api
                    getDataFromApi(context)
                } else {
                    //getData from local
                    getDataFromLocal()
                }
            } else {
                if (sessionManager.getIsDataLoaded()) {
                    //getData from local
                    getDataFromLocal()
                } else {
                    //fire api
                    getDataFromApi(context)
                }
            }
        }

    private suspend fun getDataFromLocal() {
        localBooksRepo.getAllBookResponse().first().let {
            _bookResponse.emit(ApiResponse.Success(it))
        }
    }

    private suspend fun getDataFromApi(context: Context) {

        if (SoftwareManager.isNetworkAvailable(context)) {
            handleApiResponse(bookApiRepo.getBookList())
        } else {
            _bookResponse.emit(ApiResponse.Error("No Internet Connection !"))
        }
    }

    suspend fun handleApiResponse(response: Response<BookResponse>) {
        if (response.isSuccessful) {
            response.body()?.let {
                _bookResponse.emit(ApiResponse.Success(it))
                insertNewBookResponse(it)
            }
        } else {
            _bookResponse.emit(ApiResponse.Error(response.message()))
        }
    }

    private suspend fun insertNewBookResponse(bookResponse: BookResponse) {
        localBooksRepo.deleteAllBookResponse()
        localBooksRepo.insertBookResponse(bookResponse)
        setLastTimeApiTimeStamp(System.currentTimeMillis())
        sessionManager.setIsDataLoaded(true)
    }
}