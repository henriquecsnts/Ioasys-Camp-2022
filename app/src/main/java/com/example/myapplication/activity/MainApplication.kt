package com.example.myapplication.activity

import android.app.Application
import com.example.myapplication.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                presentationModule,
                dataModule,
                dataRemoteModule,
                dataLocalModule,
                databaseModule,
                useCasesModule
            ).androidContext(applicationContext)
        }
    }
}