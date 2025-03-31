package com.aditya.bsptechnopracticaltask.domain.repo

import com.aditya.bsptechnopracticaltask.data.remote.BookService
import javax.inject.Inject

class BookApiRepo @Inject constructor(private val bookService: BookService)  {
    suspend fun getBookList() = bookService.getBooks()
}