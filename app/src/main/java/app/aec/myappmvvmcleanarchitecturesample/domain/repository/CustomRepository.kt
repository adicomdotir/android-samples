package app.aec.myappmvvmcleanarchitecturesample.domain.repository

import app.aec.myappmvvmcleanarchitecturesample.data.data_source.dto.UsersDto

interface CustomRepository {
    suspend fun getUsers(): UsersDto
}