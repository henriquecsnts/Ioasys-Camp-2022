package com.example.myapplication.data_local.data_source

import android.app.backup.SharedPreferencesBackupHelper
import com.example.myapplication.data.data_source.local.BooksLocalDataSource
import com.example.myapplication.data_local.database.BookDao
import com.example.myapplication.data_local.mappers.toDao
import com.example.myapplication.data_local.utils.LocalConstants.ACCESS_TOKEN_KEY
import com.example.myapplication.data_local.utils.SharedPreferencesHelper
import com.example.myapplication.domain.model.Book
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class BooksLocalDataSourceImpl(
    private val sharedPreferencesHelper: SharedPreferencesHelper,
    private val bookDao: BookDao
) : BooksLocalDataSource {

    override fun getAccessToken(): Flow<String> = flow {
        emit(sharedPreferencesHelper.getString(ACCESS_TOKEN_KEY))
    }

    override fun saveBooks(bookList: List<Book>) = bookDao.addBooks(
        bookList = bookList.map {
            it.toDao()
        }
    )
}

