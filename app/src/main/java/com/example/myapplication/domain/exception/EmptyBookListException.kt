package com.example.myapplication.domain.exception

sealed class EmptyBookListException(message: String= "", cause: Throwable? = null) :
    RuntimeException(message, RuntimeException(cause))

class ServerErrorException : EmptyBookListException("Infelizmente, algo deu errado.")
