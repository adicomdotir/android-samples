package app.aec.myappmvvmcleanarchitecturesample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainViewModel(startValue: Int): ViewModel() {
    private val _counter = MutableLiveData<Int>()
    val counter: LiveData<Int>
        get() = _counter

    init {
        _counter.value = startValue
    }

    fun increaseCounter() {
        _counter.value = _counter.value?.plus(1)
    }
}

class MainViewModelFactory(private val startValue: Int): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            MainViewModel(startValue) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}