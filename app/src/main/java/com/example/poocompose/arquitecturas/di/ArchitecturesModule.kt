package com.example.poocompose.arquitecturas.di

import com.example.poocompose.arquitecturas.data.BasketballTeamBuilderImpl
import com.example.poocompose.arquitecturas.data.BasketballTeamsManager
import com.example.poocompose.arquitecturas.domain.BasketballTeamBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ArchitecturesModule {

    @Singleton
    @Provides
    fun provideBasketballBuilder() : BasketballTeamBuilderImpl{
        return BasketballTeamBuilderImpl()
    }

    @Singleton
    @Provides
    fun provideBasketballTeamManager() : BasketballTeamsManager{
        return BasketballTeamsManager()
    }

}