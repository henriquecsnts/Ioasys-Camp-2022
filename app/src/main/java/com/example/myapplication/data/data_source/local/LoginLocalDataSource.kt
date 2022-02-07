package com.example.myapplication.data.data_source.local

interface LoginLocalDataSource {

    fun saveAccessToken(accessToken: String)
}