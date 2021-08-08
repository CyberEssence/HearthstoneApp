package com.example.hearthstoneapp.presentation.di.core

import com.example.hearthstoneapp.presentation.di.allcards.AllCardsSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    NetModule::class,
    DataBaseModule::class,
    UseCaseModule::class,
    RepositoryModule::class,
    RemoteDataModule::class,
    LocalDataModule::class,
    CacheDataModule::class
])
interface AppComponent {
    fun allCardsSubComponent(): AllCardsSubComponent.Factory
}