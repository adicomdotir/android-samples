package app.aec.myappmvvmcleanarchitecturesample.di

import app.aec.myappmvvmcleanarchitecturesample.storage.SharedPreferencesHelper
import app.aec.myappmvvmcleanarchitecturesample.storage.Storage
import dagger.Module
import dagger.Provides

@Module
class StorageModule {
    @Provides
    fun providesStorage(sharedPreferencesHelper: SharedPreferencesHelper): Storage {
        return sharedPreferencesHelper
    }
}