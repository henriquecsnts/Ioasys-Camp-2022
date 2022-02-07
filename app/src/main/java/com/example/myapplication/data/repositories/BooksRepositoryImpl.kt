package com.example.myapplication.data.repositories

import com.example.myapplication.data.data_source.local.BooksLocalDataSource
import com.example.myapplication.data.data_source.remote.BooksRemoteDataSource
import com.example.myapplication.domain.model.Book
import com.example.myapplication.domain.repositories.BooksRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow

class BooksRepositoryImpl(
    private val booksRemoteDataSource: BooksRemoteDataSource,
    private val booksLocalDataSource: BooksLocalDataSource
) : BooksRepository {

    override fun getBooks(query: String?): Flow<List<Book>> = flow {
        booksLocalDataSource.getAccessToken().collect { token ->
            booksRemoteDataSource.getBooks(token, query).collect { bookList ->
                emit(bookList)
            }
        }

    }


}