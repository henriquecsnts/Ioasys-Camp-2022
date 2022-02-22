package com.example.myapplication.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.domain.model.Book
import com.example.myapplication.domain.use_cases.GetBookListUseCases
import com.example.myapplication.domain.use_cases.SaveBookListUseCases
import com.example.myapplication.util.*
import org.koin.core.component.KoinComponent

class BookListViewModel : ViewModel(), KoinComponent {

    private val getBookListUseCases: GetBookListUseCases by useCase()
    private val saveBookListUseCases: SaveBookListUseCases by useCase()
    private val _bookListViewState = MutableLiveData<ViewState<List<Book>>>()
    val bookListViewState = _bookListViewState as LiveData<ViewState<List<Book>>>

    fun search(input: String = "") {
        _bookListViewState.postLoading()
        getBookListUseCases(params = GetBookListUseCases.Params(
            input = input
        ),
            onSuccess = {
                saveBooks(bookList = it)
                _bookListViewState.postSuccess(it)
            },
            onError = {
                _bookListViewState.postError(it)
            }
        )
    }

    private fun saveBooks(bookList: List<Book>) {
        saveBookListUseCases(
            params = SaveBookListUseCases.Params(
                bookList = bookList
            )
        )
    }
}

