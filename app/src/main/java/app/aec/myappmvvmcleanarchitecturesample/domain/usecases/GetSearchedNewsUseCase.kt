package app.aec.myappmvvmcleanarchitecturesample.domain.usecases

import app.aec.myappmvvmcleanarchitecturesample.data.models.ApiResponse
import app.aec.myappmvvmcleanarchitecturesample.data.util.Resource
import app.aec.myappmvvmcleanarchitecturesample.domain.repository.NewsRepository

class GetSearchedNewsUseCase(private val newsRepository: NewsRepository) {
    suspend fun execute(searchQuery: String): Resource<ApiResponse> {
        return newsRepository.getSearchedNews(searchQuery)
    }
}