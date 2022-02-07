package com.example.myapplication.data_remote.data_source

import com.example.myapplication.data.data_source.remote.LoginRemoteDataSource
import com.example.myapplication.data_remote.mappers.toDomain
import com.example.myapplication.data_remote.model.LoginRequest
import com.example.myapplication.data_remote.service.AuthService
import com.example.myapplication.domain.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LoginRemoteDataSourceImpl(
    private val authService: AuthService
) : LoginRemoteDataSource {

    override fun login(email: String, password: String): Flow<User> = flow {
        val response = authService.signIn(LoginRequest(email, password))
        val accessToken = response.headers()["authorization"]
        if (response.isSuccessful) {
            response.body()?.let { loginResponse ->
                emit(loginResponse.toDomain(accessToken ?: ""))
            }
        }
    }

}