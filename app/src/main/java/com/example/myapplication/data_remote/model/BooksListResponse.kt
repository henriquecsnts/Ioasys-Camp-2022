package com.example.myapplication.data_remote.model

import com.google.gson.annotations.SerializedName

data class BooksListResponse(
    @SerializedName("data")
    val data: List<BookResponse>
)