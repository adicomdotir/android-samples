package app.aec.myappmvvmcleanarchitecturesample.domain.usecases

import app.aec.myappmvvmcleanarchitecturesample.data.models.ApiResponse
import app.aec.myappmvvmcleanarchitecturesample.data.util.Resource
import app.aec.myappmvvmcleanarchitecturesample.domain.repository.NewsRepository

class GetNewsHeadlinesUseCase(private val newsRepository: NewsRepository) {
    suspend fun execute(): Resource<ApiResponse> {
        return newsRepository.getNewsHeadlines()
    }
}