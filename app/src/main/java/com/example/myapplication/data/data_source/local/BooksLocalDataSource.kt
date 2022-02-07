package com.example.myapplication.data.data_source.local

import kotlinx.coroutines.flow.Flow

interface BooksLocalDataSource {

    fun getAccessToken(): Flow<String>
}