package com.example.myapplication.util

import androidx.lifecycle.MutableLiveData
import com.example.myapplication.domain.exception.LoginException

fun <T> MutableLiveData<ViewState<T>>.postSuccess(data: T) {
    postValue(ViewState.Success(data))
}

fun <T> MutableLiveData<ViewState<T>>.postError(error: Throwable) {
    postValue(ViewState.Error(error))
}

fun <T> MutableLiveData<ViewState<T>>.postLoading() {
    postValue(ViewState.Loading)
}

fun <T> MutableLiveData<ViewState<T>>.postNeutral() {
    postValue(ViewState.Neutral)
}
