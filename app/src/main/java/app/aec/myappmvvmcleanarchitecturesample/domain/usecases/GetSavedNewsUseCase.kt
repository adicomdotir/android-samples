package app.aec.myappmvvmcleanarchitecturesample.domain.usecases

import app.aec.myappmvvmcleanarchitecturesample.data.models.Article
import app.aec.myappmvvmcleanarchitecturesample.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetSavedNewsUseCase(private val newsRepository: NewsRepository) {
    suspend fun execute(): Flow<List<Article>> {
        return newsRepository.getSavedNews()
    }
}