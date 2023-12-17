package app.aec.myappmvvmcleanarchitecturesample.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.aec.myappmvvmcleanarchitecturesample.data.models.ApiResponse
import app.aec.myappmvvmcleanarchitecturesample.data.util.Resource
import app.aec.myappmvvmcleanarchitecturesample.domain.usecases.GetNewsHeadlinesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsViewModel(val getNewsHeadlinesUseCase: GetNewsHeadlinesUseCase) : ViewModel() {
    val newsHeadlines: MutableLiveData<Resource<ApiResponse>> = MutableLiveData()

    fun getNewsHeadlines(country: String, page: Int) = viewModelScope.launch(Dispatchers.IO) {
        newsHeadlines.postValue(Resource.Loading())
        val apiResult = getNewsHeadlinesUseCase.execute(country, page)
        newsHeadlines.postValue(apiResult)
    }
}