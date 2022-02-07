package com.example.myapplication.data.data_source.remote

import com.example.myapplication.domain.model.Book
import kotlinx.coroutines.flow.Flow

interface BooksRemoteDataSource {

    fun getBooks(accessToken: String, query: String?): Flow<List<Book>>

}