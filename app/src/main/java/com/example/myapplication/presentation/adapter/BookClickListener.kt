package com.example.myapplication.presentation.adapter

import com.example.myapplication.domain.model.Book

interface BookClickListener {

    fun onBookClickListener(book: Book)
}