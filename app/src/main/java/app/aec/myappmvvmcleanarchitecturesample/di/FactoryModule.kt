package app.aec.myappmvvmcleanarchitecturesample.di

import android.app.Application
import app.aec.myappmvvmcleanarchitecturesample.domain.usecases.GetNewsHeadlinesUseCase
import app.aec.myappmvvmcleanarchitecturesample.presentation.viewmodel.NewsViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FactoryModule {
    @Singleton
    @Provides
    fun provideNewsViewModelFactory(
        application: Application,
        getNewsHeadlinesUseCase: GetNewsHeadlinesUseCase
    ): NewsViewModelFactory {
        return NewsViewModelFactory(application, getNewsHeadlinesUseCase)
    }
}