package com.example.myapplication.domain.repositories

import com.example.myapplication.domain.model.Book
import kotlinx.coroutines.flow.Flow

interface BooksRepository {

    fun getBooks(query: String?): Flow<List<Book>>
    fun saveBooks(bookList: List<Book>)

}