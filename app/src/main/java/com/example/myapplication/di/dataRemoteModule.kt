package com.example.myapplication.di

import com.example.myapplication.data.data_source.remote.BooksRemoteDataSource
import com.example.myapplication.data.data_source.remote.LoginRemoteDataSource
import com.example.myapplication.data_remote.data_source.BooksRemoteDataSourceImpl
import com.example.myapplication.data_remote.data_source.LoginRemoteDataSourceImpl
import com.example.myapplication.data_remote.service.AuthService
import com.example.myapplication.data_remote.service.BookService
import com.example.myapplication.data_remote.utils.ApiConstants
import com.example.myapplication.data_remote.utils.WebServiceFactory
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

    single<BooksRemoteDataSource> {
        BooksRemoteDataSourceImpl(get())
    }

    single<LoginRemoteDataSource> {
        LoginRemoteDataSourceImpl(get())
    }
}