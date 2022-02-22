package com.example.myapplication.domain.exception

sealed class BookListException(message: String= "", cause: Throwable? = null) :
    RuntimeException(message, RuntimeException(cause))

class ServerErrorException : BookListException("Infelizmente, algo deu errado.", Throwable())
class MissingParamsException : BookListException("Faltam parâmetros.")



