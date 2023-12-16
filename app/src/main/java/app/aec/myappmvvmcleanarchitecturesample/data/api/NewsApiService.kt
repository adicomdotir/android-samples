package app.aec.myappmvvmcleanarchitecturesample.data.api

import app.aec.myappmvvmcleanarchitecturesample.BuildConfig
import app.aec.myappmvvmcleanarchitecturesample.data.models.ApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {
    @GET("v2/top-headlines")
    suspend fun getTopHeadlines(
        @Query("country")
        country: String,
        @Query("page")
        page: Int,
        @Query("country")
        apiKey: String = BuildConfig.API_KEY,
    ): Response<ApiResponse>
}