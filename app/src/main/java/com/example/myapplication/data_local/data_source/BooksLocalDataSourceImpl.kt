package com.example.myapplication.data_local.data_source

import android.app.backup.SharedPreferencesBackupHelper
import com.example.myapplication.data.data_source.local.BooksLocalDataSource
import com.example.myapplication.data_local.utils.LocalConstants.ACCESS_TOKEN_KEY
import com.example.myapplication.data_local.utils.SharedPreferencesHelper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class BooksLocalDataSourceImpl(
    private val sharedPreferencesHelper: SharedPreferencesHelper
) : BooksLocalDataSource {

    override fun getAccessToken(): Flow<String> = flow {
        emit(sharedPreferencesHelper.getString(ACCESS_TOKEN_KEY))
    }
}