package com.example.myapplication.data.data_source

import com.example.myapplication.domain.model.User
import kotlinx.coroutines.flow.Flow

interface LoginDataSource {

    fun login(email: String, password: String): Flow<User>

}