package com.example.myapplication.data.repositories

import com.example.myapplication.data.data_source.LoginDataSource
import com.example.myapplication.domain.model.User
import com.example.myapplication.domain.repositories.LoginRepository
import kotlinx.coroutines.flow.Flow

class LoginRepositoryImpl(
    private val loginDataSource: LoginDataSource
): LoginRepository {

    override fun login(email: String, password: String): Flow<User> =
        loginDataSource.login(email, password)
}