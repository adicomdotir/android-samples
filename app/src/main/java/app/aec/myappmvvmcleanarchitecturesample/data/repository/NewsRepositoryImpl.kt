package app.aec.myappmvvmcleanarchitecturesample.data.repository

import app.aec.myappmvvmcleanarchitecturesample.data.datasources.NewsRemoteDataSource
import app.aec.myappmvvmcleanarchitecturesample.data.models.ApiResponse
import app.aec.myappmvvmcleanarchitecturesample.data.models.Article
import app.aec.myappmvvmcleanarchitecturesample.data.util.Resource
import app.aec.myappmvvmcleanarchitecturesample.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class NewsRepositoryImpl(
    private val newsRemoteDataSource: NewsRemoteDataSource
) : NewsRepository {

    private fun responseToResource(response: Response<ApiResponse>): Resource<ApiResponse> {
        if (response.isSuccessful) {
            response.body()?.let { res ->
                return Resource.Success(res)
            }
        }
        return Resource.Error(response.message())
    }

    override suspend fun getNewsHeadlines(): Resource<ApiResponse> {
        return responseToResource(newsRemoteDataSource.getTopHeadlines())
    }

    override suspend fun getSearchedNews(searchQuery: String): Resource<ApiResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun saveNews(article: Article) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteNews(article: Article) {
        TODO("Not yet implemented")
    }

    override fun getSavedNews(): Flow<List<Article>> {
        TODO("Not yet implemented")
    }
}