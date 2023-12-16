package app.aec.myappmvvmcleanarchitecturesample.domain.usecases

import app.aec.myappmvvmcleanarchitecturesample.data.models.Article
import app.aec.myappmvvmcleanarchitecturesample.domain.repository.NewsRepository

class DeleteSavedNewsUseCase(private val newsRepository: NewsRepository) {
    suspend fun execute(article: Article) = newsRepository.deleteNews(article)
}