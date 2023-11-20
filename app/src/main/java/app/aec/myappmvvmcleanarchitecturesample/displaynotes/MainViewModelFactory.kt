package app.aec.myappmvvmcleanarchitecturesample.displaynotes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import app.aec.myappmvvmcleanarchitecturesample.storage.SharedPreferencesHelper
import app.aec.myappmvvmcleanarchitecturesample.storage.Storage
import javax.inject.Inject

class MainViewModelFactory @Inject constructor(
    private val storage: Storage
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(SharedPreferencesHelper::class.java).newInstance(storage)
    }
}