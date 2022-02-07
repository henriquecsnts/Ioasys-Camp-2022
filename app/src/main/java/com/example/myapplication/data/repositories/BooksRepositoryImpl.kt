package com.example.myapplication.data.repositories

import com.example.myapplication.data.data_source.remote.BooksRemoteDataSource
import com.example.myapplication.domain.model.Book
import com.example.myapplication.domain.repositories.BooksRepository
import kotlinx.coroutines.flow.Flow

class BooksRepositoryImpl(
    private val booksRemoteDataSource: BooksRemoteDataSource
): BooksRepository {

    override fun getBooks(accessToken: String, query: String?): Flow<List<Book>> =
        booksRemoteDataSource.getBooks(accessToken, query)

}