package app.aec.myappmvvmcleanarchitecturesample.data.datasources

import app.aec.myappmvvmcleanarchitecturesample.data.api.NewsApiService
import app.aec.myappmvvmcleanarchitecturesample.data.models.ApiResponse
import retrofit2.Response

class NewsRemoteDataSourceImpl(
    private val newsApiService: NewsApiService,
    private val country: String,
    private val page: Int
) : NewsRemoteDataSource {
    override suspend fun getTopHeadlines(): Response<ApiResponse> {
        return newsApiService.getTopHeadlines(country, page)
    }
}