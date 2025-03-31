package com.aditya.bsptechnopracticaltask.data.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import com.aditya.bsptechnopracticaltask.domain.models.BookResponse
import kotlinx.coroutines.flow.Flow

@Dao
interface BookDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBookResponse(bookResponse: BookResponse) : Long

    @Query("DELETE FROM BookResponse")
    suspend fun deleteAllBookResponse(): Int

    @Query("Select * From BookResponse")
    fun getAllBookResponse() : Flow<BookResponse>

}