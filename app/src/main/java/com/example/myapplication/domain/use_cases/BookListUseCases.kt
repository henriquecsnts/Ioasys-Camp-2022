package com.example.myapplication.domain.use_cases

import com.example.myapplication.domain.core.UseCase
import com.example.myapplication.domain.exception.InvalidFieldException
import com.example.myapplication.domain.exception.ServerErrorException
import com.example.myapplication.domain.model.Book
import com.example.myapplication.domain.model.User
import com.example.myapplication.domain.repositories.BooksRepository
import com.example.myapplication.domain.repositories.LoginRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

class BookListUseCases(
    scope: CoroutineScope,
    private val repository: BooksRepository
) : UseCase<List<Book>, BookListUseCases.Params>(scope) {

    override fun run(params: Params?): Flow<List<Book>> =
        params?.let {
            repository.getBooks(query = it.query)
        } ?: throw ServerErrorException()

    data class Params(
        val query: String?
    )

}