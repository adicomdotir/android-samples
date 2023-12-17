package app.aec.myappmvvmcleanarchitecturesample.domain.repository

import app.aec.myappmvvmcleanarchitecturesample.data.models.ApiResponse
import app.aec.myappmvvmcleanarchitecturesample.data.models.Article
import app.aec.myappmvvmcleanarchitecturesample.data.util.Resource
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    suspend fun getNewsHeadlines(
        country: String,
        page: Int
    ): Resource<ApiResponse>

    suspend fun getSearchedNews(searchQuery: String): Resource<ApiResponse>
    suspend fun saveNews(article: Article)
    suspend fun deleteNews(article: Article)
    fun getSavedNews(): Flow<List<Article>>
}