package com.example.myapplication.data_remote.service

import com.example.myapplication.data_remote.model.LoginRequest
import com.example.myapplication.data_remote.model.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {

    @POST("auth/sign-in")
     suspend fun signIn(
         @Body loginRequest: LoginRequest
     ): retrofit2.Response<LoginResponse>
}