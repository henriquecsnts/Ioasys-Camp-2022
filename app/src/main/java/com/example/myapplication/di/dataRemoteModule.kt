package com.example.myapplication.di

import com.example.myapplication.data.data_source.BooksDataSource
import com.example.myapplication.data.data_source.LoginDataSource
import com.example.myapplication.data_remote.data_source.BooksDataSourceImpl
import com.example.myapplication.data_remote.data_source.LoginDataSourceImpl
import com.example.myapplication.data_remote.service.AuthService
import com.example.myapplication.data_remote.service.BookService
import com.example.myapplication.data_remote.utils.ApiConstants
import com.example.myapplication.data_remote.utils.WebServiceFactory
import okhttp3.OkHttpClient
import org.koin.dsl.module

val dataRemoteModule = module {

    single<AuthService> {
        WebServiceFactory.createWebService(
            okHttpClient = get(),
            url = ApiConstants.BASE_URL
        )
    }

    single<BookService> {
        WebServiceFactory.createWebService(
            okHttpClient = get(),
            url = ApiConstants.BASE_URL
        )
    }

    single { WebServiceFactory.providerHttpClient() }

    single<BooksDataSource> {
        BooksDataSourceImpl(get())
    }

    single<LoginDataSource> {
        LoginDataSourceImpl(get())
    }
}