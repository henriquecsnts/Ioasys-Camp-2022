package com.example.myapplication.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domain.model.Book
import com.example.myapplication.domain.repositories.BooksRepository
import com.example.myapplication.util.ViewState
import com.example.myapplication.util.postError
import com.example.myapplication.util.postLoading
import com.example.myapplication.util.postSuccess
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class BookListViewModel(
    private val booksRepository: BooksRepository
) : ViewModel() {

    private val _bookListViewState = MutableLiveData<ViewState<List<Book>>>()
    val bookListViewState = _bookListViewState as LiveData<ViewState<List<Book>>>
    
    fun search(input: String = "") {
        viewModelScope.launch {
            _bookListViewState.postLoading()
            try {
                booksRepository.getBooks(input).collect {
                    if (it.isNotEmpty()) {
                        saveBooks(bookList = it)
                        _bookListViewState.postSuccess(it)
                    } else {
                        _bookListViewState.postError(Exception("Algo deu errado."))
                    }
                }
            } catch (err: Exception) {
                _bookListViewState.postError(err)
            }
        }
    }

    private fun saveBooks(bookList: List<Book>) {
        viewModelScope.launch {

            try {
                withContext(Dispatchers.IO) {
                    booksRepository.saveBooks(bookList = bookList)
                }
                print("Success!")
            } catch (err: Exception) {
                print(err)
            }
        }
    }
}