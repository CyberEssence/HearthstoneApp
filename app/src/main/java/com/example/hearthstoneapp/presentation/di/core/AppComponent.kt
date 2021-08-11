package com.example.hearthstoneapp.presentation.di.core

import com.example.hearthstoneapp.presentation.di.basic.AllCardsBasicSubComponent
import com.example.hearthstoneapp.presentation.di.classic.AllCardsClassicSubComponent
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
    fun allCardsBasicSubComponent(): AllCardsBasicSubComponent.Factory
    fun allCardsClassicSubComponent(): AllCardsClassicSubComponent.Factory
}