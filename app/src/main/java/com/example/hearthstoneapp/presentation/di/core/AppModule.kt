package com.example.hearthstoneapp.presentation.di.core

import android.content.Context
import com.example.hearthstoneapp.presentation.di.allcards.AllCardsSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [AllCardsSubComponent::class])
class AppModule(private val context: Context) {
    @Singleton
    @Provides
    fun provideApplicationContext():Context{
        return context.applicationContext
    }
}