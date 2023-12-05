package app.aec.myappmvvmcleanarchitecturesample.data.data_source

import app.aec.myappmvvmcleanarchitecturesample.data.data_source.dto.UsersDto
import retrofit2.http.GET

interface CustomApi {
    @GET("/users")
    suspend fun getAllUsers(): UsersDto
}