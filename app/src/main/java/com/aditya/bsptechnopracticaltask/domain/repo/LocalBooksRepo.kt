package com.aditya.bsptechnopracticaltask.domain.repo

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.aditya.bsptechnopracticaltask.data.local.db.BookDao
import com.aditya.bsptechnopracticaltask.domain.models.BookResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalBooksRepo @Inject constructor(private  val bookDao: BookDao)  {
    suspend fun insertBookResponse(bookResponse: BookResponse)  = bookDao.insertBookResponse(bookResponse)

    suspend fun deleteAllBookResponse() = bookDao.deleteAllBookResponse()

    fun getAllBookResponse()  = bookDao.getAllBookResponse()
}