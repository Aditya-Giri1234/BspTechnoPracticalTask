package com.aditya.bsptechnopracticaltask.data.remote

import com.aditya.bsptechnopracticaltask.common.utils.Constants
import com.aditya.bsptechnopracticaltask.domain.models.BookResponse
import retrofit2.Response
import retrofit2.http.GET

interface BookService {
    @GET(Constants.TEST_DISCOVERY)
    suspend fun getBooks() : Response<BookResponse>
}