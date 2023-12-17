package app.aec.myappmvvmcleanarchitecturesample.data.datasources

import app.aec.myappmvvmcleanarchitecturesample.data.api.NewsApiService
import app.aec.myappmvvmcleanarchitecturesample.data.models.ApiResponse
import retrofit2.Response

class NewsRemoteDataSourceImpl(
    private val newsApiService: NewsApiService,
) : NewsRemoteDataSource {
    override suspend fun getTopHeadlines(
        country: String,
        page: Int
    ): Response<ApiResponse> {
        return newsApiService.getTopHeadlines(country, page)
    }
}