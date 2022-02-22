package com.example.myapplication.di

import LoginUseCases
import com.example.myapplication.domain.use_cases.GetBookListUseCases
import com.example.myapplication.domain.use_cases.SaveBookListUseCases
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val useCasesModule = module {
    factory {
        LoginUseCases(get(), get())
    }

    factory {
        GetBookListUseCases(get(), get())
    }

    factory {
        SaveBookListUseCases(get(), get())
    }

    single {
        CoroutineScope(Dispatchers.IO)
    }

}