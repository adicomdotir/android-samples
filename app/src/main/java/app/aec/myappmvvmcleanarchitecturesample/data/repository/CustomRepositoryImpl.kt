package app.aec.myappmvvmcleanarchitecturesample.data.repository

import app.aec.myappmvvmcleanarchitecturesample.data.data_source.CustomApi
import app.aec.myappmvvmcleanarchitecturesample.data.data_source.dto.UsersDto
import app.aec.myappmvvmcleanarchitecturesample.domain.repository.CustomRepository

class CustomRepositoryImpl(
    private val api: CustomApi
) : CustomRepository {
    override suspend fun getUsers(): UsersDto {
        return api.getAllUsers()
    }
}