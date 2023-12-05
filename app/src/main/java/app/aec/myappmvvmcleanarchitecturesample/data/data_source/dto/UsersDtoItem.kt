package app.aec.myappmvvmcleanarchitecturesample.data.data_source.dto

import app.aec.myappmvvmcleanarchitecturesample.domain.model.User

data class UsersDtoItem(
    val address: Address,
    val company: Company,
    val email: String,
    val id: Int,
    val name: String,
    val phone: String,
    val username: String,
    val website: String
) {
    fun toUser(): User {
        return User(
            address, company, email, id, name, phone, username, website
        )
    }
}