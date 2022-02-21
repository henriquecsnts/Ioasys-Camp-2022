package com.example.myapplication.data_remote.mappers

import com.example.myapplication.data_remote.model.BookResponse
import com.example.myapplication.domain.model.Book

fun List<BookResponse>.toDomain(): List<Book> {
    return this.map {
        Book(
            id = it.id ?: "",
            name = it.name ?: "",
            author = it.author.first() ?: "",
            pages = it.pages ?: "",
            editor = it.editor ?: "",
            date = it.date ?: "",
            language = it.language ?: "",
            originName = it.originName ?: "",
            isbn10 = it.isbn10 ?: "",
            isbn13 = it.isbn13 ?: "",
            review = it.review ?: "",
            imageUrl = it.imageUrl ?: ""
        )
    }
}