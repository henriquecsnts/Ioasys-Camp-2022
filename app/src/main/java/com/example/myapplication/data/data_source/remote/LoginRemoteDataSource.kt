package com.example.myapplication.data.data_source.remote

import com.example.myapplication.domain.model.User
import kotlinx.coroutines.flow.Flow

interface LoginRemoteDataSource {

    fun login(email: String, password: String): Flow<User>

}