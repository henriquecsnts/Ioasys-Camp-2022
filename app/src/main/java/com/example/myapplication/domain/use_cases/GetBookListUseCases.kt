package com.example.myapplication.domain.use_cases

import com.example.myapplication.domain.core.UseCase
import com.example.myapplication.domain.model.Book
import com.example.myapplication.domain.repositories.BooksRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

class GetBookListUseCases(
    private val booksRepository: BooksRepository,
    scope: CoroutineScope
) : UseCase<List<Book>, GetBookListUseCases.Params>(scope = scope) {

    override fun run(params: Params?): Flow<List<Book>> = booksRepository.getBooks(query = params?.input)

    data class Params(
        val input: String
    )
}
