package com.example.myapplication.domain.use_cases

import com.example.myapplication.domain.core.UseCase
import com.example.myapplication.domain.model.Book
import com.example.myapplication.domain.repositories.BooksRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class SaveBookListUseCases(
    private val booksRepository: BooksRepository,
    scope: CoroutineScope
) : UseCase<Unit, SaveBookListUseCases.Params>(scope = scope) {

    override fun run(params: Params?): Flow<Unit> = flowOf(
        booksRepository.saveBooks(bookList = params?.bookList ?: listOf())
    )

    data class Params(
        val bookList: List<Book>
    )
}
