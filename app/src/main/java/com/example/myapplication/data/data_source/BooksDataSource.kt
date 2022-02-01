package com.example.myapplication.data.data_source

import com.example.myapplication.domain.model.Book
import kotlinx.coroutines.flow.Flow

interface BooksDataSource {

    fun getBooks(accessToken: String, query: String?): Flow<List<Book>>

}