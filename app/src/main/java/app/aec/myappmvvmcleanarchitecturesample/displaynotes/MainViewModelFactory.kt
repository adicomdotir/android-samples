package app.aec.myappmvvmcleanarchitecturesample.displaynotes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import app.aec.myappmvvmcleanarchitecturesample.storage.SharedPreferencesHelper

class MainViewModelFactory(
    private val storage: SharedPreferencesHelper
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(SharedPreferencesHelper::class.java).newInstance(storage)
    }
}