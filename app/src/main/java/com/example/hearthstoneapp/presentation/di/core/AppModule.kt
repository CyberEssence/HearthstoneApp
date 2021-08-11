package com.example.hearthstoneapp.presentation.di.core

import android.content.Context
import com.example.hearthstoneapp.presentation.di.basic.AllCardsBasicSubComponent
import com.example.hearthstoneapp.presentation.di.classic.AllCardsClassicSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [AllCardsBasicSubComponent::class, AllCardsClassicSubComponent::class])
class AppModule(private val context: Context) {
    @Singleton
    @Provides
    fun provideApplicationContext():Context{
        return context.applicationContext
    }
}