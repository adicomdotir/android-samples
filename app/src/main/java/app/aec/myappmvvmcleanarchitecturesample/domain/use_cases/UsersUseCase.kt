package app.aec.myappmvvmcleanarchitecturesample.domain.use_cases

import app.aec.myappmvvmcleanarchitecturesample.domain.model.User
import app.aec.myappmvvmcleanarchitecturesample.domain.repository.CustomRepository
import app.aec.myappmvvmcleanarchitecturesample.utils.Response
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class UsersUseCase(private val repository: CustomRepository) {
    operator fun  invoke(): Flow<Response<List<User>>> = flow {
        try {
            emit(Response.Loading())
            val list = repository.getUsers().map {
                it.toUser()
            }
            emit(Response.Success(list))
        } catch (e: HttpException) {
            emit(Response.Error(e.printStackTrace().toString()))
        } catch (e: IOException) {
            emit(Response.Error(e.printStackTrace().toString()))
        }
    }
}