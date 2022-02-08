package com.example.myapplication.data_local.mappers

import com.example.myapplication.data_local.database.BookDao
import com.example.myapplication.data_local.model.BookDataLocal
import com.example.myapplication.domain.model.Book

fun Book.toDao(): BookDataLocal = BookDataLocal(
    id = this.id,
    name = this.name,
    author = this.author,
    pages = this.pages,
    editor = this.editor,
    date = this.date,
    language = this.language,
    originName = this.originName,
    isbn10 = this.isbn10,
    isbn13 = this.isbn13,
    review = this.review,
    imageUrl = this.imageUrl
)

fun BookDataLocal.toDomain(): Book = Book(
    id = this.id,
    name = this.name ?: "",
    author = this.author ?: "",
    pages = this.pages ?: "",
    editor = this.editor ?: "",
    date = this.date ?: "",
    language = this.language ?: "",
    originName = this.originName ?: "",
    isbn10 = this.isbn10 ?: "",
    isbn13 = this.isbn13 ?: "",
    review = this.review ?: "",
    imageUrl = this.imageUrl ?: ""
)


