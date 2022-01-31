package com.example.myapplication.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domain.exception.LoginException
import com.example.myapplication.util.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private val _loggedUserViewState = MutableLiveData<ViewState<Boolean>>()
    val loggedUserViewState = _loggedUserViewState as LiveData<ViewState<Boolean>>

    fun login(email: String, password: String) {

        viewModelScope.launch {

            _loggedUserViewState.postLoading()

            delay(2)

            if (email.isNotEmpty() && password.isNotEmpty()) {
                _loggedUserViewState.postSuccess(true)
            } else {
                _loggedUserViewState.postError(LoginException())
            }
        }
    }

    fun resetViewState() {
        _loggedUserViewState.postNeutral()
    }
}