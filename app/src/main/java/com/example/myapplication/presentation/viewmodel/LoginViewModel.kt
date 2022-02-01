package com.example.myapplication.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domain.exception.LoginException
import com.example.myapplication.domain.repositories.LoginRepository
import com.example.myapplication.util.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class LoginViewModel(
    private val loginRepository: LoginRepository
) : ViewModel() {

    private val _loggedUserViewState = MutableLiveData<ViewState<Boolean>>()
    val loggedUserViewState = _loggedUserViewState as LiveData<ViewState<Boolean>>

    fun login(email: String, password: String) {

        viewModelScope.launch {

            _loggedUserViewState.postLoading()

            try {
                loginRepository.login(email, password).collect {
                    if (it.name.isEmpty().not()) {
                        _loggedUserViewState.postSuccess(true)
                    } else {
                        _loggedUserViewState.postError(java.lang.Exception("Algo deu errado."))
                    }
                }
            } catch (err: Exception) {
                _loggedUserViewState.postError(err)
            }
        }
    }

    fun resetViewState() {
        _loggedUserViewState.postNeutral()
    }
}