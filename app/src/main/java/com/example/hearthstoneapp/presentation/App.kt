package com.example.hearthstoneapp.presentation

import android.app.Application
import com.example.hearthstoneapp.BuildConfig
import com.example.hearthstoneapp.presentation.di.Injector
import com.example.hearthstoneapp.presentation.di.allcards.AllCardsSubComponent
import com.example.hearthstoneapp.presentation.di.core.*

class App : Application(), Injector {
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule())
            .build()

    }

    override fun createAllCardsSubComponent(): AllCardsSubComponent {
        return appComponent.allCardsSubComponent().create()
    }
}