package com.example.myapplication.di

import com.example.myapplication.data.data_source.local.BooksLocalDataSource
import com.example.myapplication.data.data_source.local.LoginLocalDataSource
import com.example.myapplication.data_local.data_source.BooksLocalDataSourceImpl
import com.example.myapplication.data_local.data_source.LoginLocalDataSourceImpl
import com.example.myapplication.data_local.utils.SharedPreferencesHelper
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataLocalModule = module {

    single {
        SharedPreferencesHelper(androidContext())
    }

    single<LoginLocalDataSource> {
        LoginLocalDataSourceImpl(get())
    }

    single<BooksLocalDataSource> {
        BooksLocalDataSourceImpl(get(), get())
    }
}