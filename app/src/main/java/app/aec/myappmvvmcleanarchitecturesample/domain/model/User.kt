package app.aec.myappmvvmcleanarchitecturesample.domain.model

import app.aec.myappmvvmcleanarchitecturesample.data.data_source.dto.Address
import app.aec.myappmvvmcleanarchitecturesample.data.data_source.dto.Company

data class User(
    val address: Address,
    val company: Company,
    val email: String,
    val id: Int,
    val name: String,
    val phone: String,
    val username: String,
    val website: String
)
