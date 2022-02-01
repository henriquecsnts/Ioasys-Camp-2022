package com.example.myapplication.data_remote.data_source

import com.example.myapplication.data.data_source.BooksDataSource
import com.example.myapplication.domain.model.Book
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class BooksDataSourceImpl : BooksDataSource {

    override fun getBooks(accessToken: String, query: String?): Flow<List<Book>> = flow {
        val books: List<Book> = listOf(
            Book(
                id = 1,
                name = "Crossing The Chase"
            ),
            Book(
                id = 2,
                name = "Change By Design"
            ),
            Book(
                id = 3,
                name = "The Making Of a Manager"
            ),
            Book(
                id = 4,
                name = "Don't Make Me Think"
            ),
            Book(
                id = 5,
                name = "Web Design 101"
            )
        )

        query?.let {
            emit((books.filter { book ->
                book.name.trim().contains(it, true)
            }))
        } ?: run {
            emit(books)
        }
    }

}