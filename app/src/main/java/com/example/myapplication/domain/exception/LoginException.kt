package com.example.myapplication.domain.exception

sealed class LoginException(message: String= "", title: String? = null) :
    RuntimeException(message, RuntimeException(title))

class InvalidFieldException : LoginException("Usuário ou senha inválida.")