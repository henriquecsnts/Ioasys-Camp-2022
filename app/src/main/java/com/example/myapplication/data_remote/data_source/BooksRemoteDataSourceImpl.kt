package com.example.myapplication.data_remote.data_source

import com.example.myapplication.data.data_source.remote.BooksRemoteDataSource
import com.example.myapplication.data_remote.mappers.toDomain
import com.example.myapplication.data_remote.service.BookService
import com.example.myapplication.domain.model.Book
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class BooksRemoteDataSourceImpl(
    private val bookService: BookService
) : BooksRemoteDataSource {

    override fun getBooks(accessToken: String, query: String?): Flow<List<Book>> = flow {

        val response = bookService.getBooks(accessToken = "Bearer $accessToken", 1 /*, ""*/)
        if (response.isSuccessful) {
            response.body()?.data?.let { bookList ->
                query?.let {
                    emit(bookList.filter { book ->
                        book.name?.trim()?.contains(it, ignoreCase = true) ?: false
                    }.toDomain())
                } ?: run {
                    emit(bookList.toDomain())
                }
            }
        }

    }

}