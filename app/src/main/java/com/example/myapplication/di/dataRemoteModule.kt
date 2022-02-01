package com.example.myapplication.di

import com.example.myapplication.data.data_source.BooksDataSource
import com.example.myapplication.data.data_source.LoginDataSource
import com.example.myapplication.data_remote.data_source.BooksDataSourceImpl
import com.example.myapplication.data_remote.data_source.LoginDataSourceImpl
import org.koin.dsl.module

val dataRemoteModule = module {

    single<BooksDataSource> {
        BooksDataSourceImpl()
    }

    single<LoginDataSource> {
        LoginDataSourceImpl()
    }
}