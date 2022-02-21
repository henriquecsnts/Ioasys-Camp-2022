package com.example.myapplication.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domain.model.User
import com.example.myapplication.domain.use_cases.LoginUseCases
import com.example.myapplication.util.*
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent

class LoginViewModel : ViewModel(), KoinComponent {

    private val loginUseCase: LoginUseCases by useCase()
    private val _loggedUserViewState = MutableLiveData<ViewState<User>>()
    val loggedUserViewState = _loggedUserViewState as LiveData<ViewState<User>>

    fun login(email: String, password: String) {

        viewModelScope.launch {

            _loggedUserViewState.postLoading()

            loginUseCase.invoke(
                LoginUseCases.Params(
                    email = email,
                    password = password
                ),
                onSuccess = {
                    _loggedUserViewState.postSuccess(it)
                },
                onError = {
                    _loggedUserViewState.postError(it)
                }
            )
        }
    }

    fun resetViewState() {
        _loggedUserViewState.postNeutral()
    }
}