package com.example.myapplication.activity

import android.app.Application
import com.example.myapplication.di.dataLocalModule
import com.example.myapplication.di.dataModule
import com.example.myapplication.di.dataRemoteModule
import com.example.myapplication.di.presentationModule
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
                dataLocalModule
            ).androidContext(applicationContext)
        }
    }
}