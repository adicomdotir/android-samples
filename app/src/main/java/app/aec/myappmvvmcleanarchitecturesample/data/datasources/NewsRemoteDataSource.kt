package app.aec.myappmvvmcleanarchitecturesample.data.datasources

import app.aec.myappmvvmcleanarchitecturesample.data.models.ApiResponse
import retrofit2.Response

interface NewsRemoteDataSource {
    suspend fun getTopHeadlines(): Response<ApiResponse>
}