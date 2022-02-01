package com.example.myapplication.di

import com.example.myapplication.data.repositories.BooksRepositoryImpl
import com.example.myapplication.data.repositories.LoginRepositoryImpl
import com.example.myapplication.domain.repositories.BooksRepository
import com.example.myapplication.domain.repositories.LoginRepository
import org.koin.dsl.module

val dataModule = module {

    single <BooksRepository> {
        BooksRepositoryImpl(get())
    }

    single <LoginRepository> {
        LoginRepositoryImpl(get())
    }

}