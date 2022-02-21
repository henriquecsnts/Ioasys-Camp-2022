package com.example.myapplication.di

import com.example.myapplication.domain.core.ThreadContextProvider
import com.example.myapplication.domain.use_cases.BookListUseCases
import com.example.myapplication.domain.use_cases.LoginUseCases
import org.koin.dsl.module

val useCasesModule = module {
    single {
        LoginUseCases(get(), get())
    }

    single {
        BookListUseCases(get(), get())
    }

    single {
        ThreadContextProvider()
    }
}