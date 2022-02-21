package com.example.myapplication.domain.use_cases

import com.example.myapplication.domain.core.UseCase
import com.example.myapplication.domain.exception.InvalidFieldException
import com.example.myapplication.domain.model.User
import com.example.myapplication.domain.repositories.LoginRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

class LoginUseCases(
    scope: CoroutineScope,
    private val repository: LoginRepository
) : UseCase<User, LoginUseCases.Params>(scope) {

    override fun run(params: Params?): Flow<User> =
        params?.let {
            repository.login(email = it.email, password = it.password)
        } ?: throw InvalidFieldException()

    data class Params(
        val email: String,
        val password: String
    )

}