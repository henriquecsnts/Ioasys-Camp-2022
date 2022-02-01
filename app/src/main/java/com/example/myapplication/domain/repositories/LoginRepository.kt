package com.example.myapplication.domain.repositories

import com.example.myapplication.domain.model.User
import kotlinx.coroutines.flow.Flow

interface LoginRepository {

    fun login(email: String, password: String): Flow<User>

}