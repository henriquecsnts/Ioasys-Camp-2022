package com.example.myapplication.data.repositories

import com.example.myapplication.data.data_source.local.LoginLocalDataSource
import com.example.myapplication.data.data_source.remote.LoginRemoteDataSource
import com.example.myapplication.domain.model.User
import com.example.myapplication.domain.repositories.LoginRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import okhttp3.internal.userAgent

class LoginRepositoryImpl(
    private val loginRemoteDataSource: LoginRemoteDataSource,
    private val loginLocalDataSource: LoginLocalDataSource
): LoginRepository {

    override fun login(email: String, password: String): Flow<User> = flow {
        loginRemoteDataSource.login(email, password).collect { userData ->
            loginLocalDataSource.saveAccessToken(accessToken = userData.accessToken)
            emit(userData)
        }
    }

}