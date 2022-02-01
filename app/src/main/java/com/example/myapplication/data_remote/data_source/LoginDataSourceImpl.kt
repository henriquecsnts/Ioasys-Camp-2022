package com.example.myapplication.data_remote.data_source

import com.example.myapplication.data.data_source.LoginDataSource
import com.example.myapplication.domain.model.User
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LoginDataSourceImpl: LoginDataSource {

    override fun login(email: String, password: String): Flow<User> = flow {
        delay(3_000)
        emit(User(
            name = "Henrique",
            birthdate = "18/04/1998",
            gender = "Male",
            accessToken = "123456"
        ))
    }

}