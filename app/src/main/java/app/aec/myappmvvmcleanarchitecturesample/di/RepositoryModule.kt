package app.aec.myappmvvmcleanarchitecturesample.di

import app.aec.myappmvvmcleanarchitecturesample.data.api.NewsApiService
import app.aec.myappmvvmcleanarchitecturesample.data.datasources.NewsRemoteDataSource
import app.aec.myappmvvmcleanarchitecturesample.data.datasources.NewsRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun provideNewsRemoteDataSource(
        newsApiService: NewsApiService,
    ): NewsRemoteDataSource {
        return NewsRemoteDataSourceImpl(newsApiService)
    }
}