package app.aec.myappmvvmcleanarchitecturesample.domain.usecases

import app.aec.myappmvvmcleanarchitecturesample.data.models.Article
import app.aec.myappmvvmcleanarchitecturesample.domain.repository.NewsRepository

class SaveNewsUseCase(private val newsRepository: NewsRepository) {
    suspend fun execute(article: Article) = newsRepository.saveNews(article)
}