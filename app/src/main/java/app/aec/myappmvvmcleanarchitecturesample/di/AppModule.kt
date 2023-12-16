package app.aec.myappmvvmcleanarchitecturesample.di

import app.aec.myappmvvmcleanarchitecturesample.data.datasources.CustomApi
import app.aec.myappmvvmcleanarchitecturesample.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class, )
object AppModule {
    @Provides
    @Singleton
    fun provideCustomApi(): CustomApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CustomApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCustomRepository(api: CustomApi): CustomRepository {
        return CustomRepositoryImpl(api)
    }
}