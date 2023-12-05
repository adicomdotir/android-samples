package app.aec.myappmvvmcleanarchitecturesample.ui.users_list

import app.aec.myappmvvmcleanarchitecturesample.domain.model.User

data class UserListState(
    val isLoading: Boolean = false,
    val userList: List<User> = emptyList(),
    val error: String = ""
)