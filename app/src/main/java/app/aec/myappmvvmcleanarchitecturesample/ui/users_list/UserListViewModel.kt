package app.aec.myappmvvmcleanarchitecturesample.ui.users_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.aec.myappmvvmcleanarchitecturesample.domain.use_cases.UsersUseCase
import app.aec.myappmvvmcleanarchitecturesample.utils.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(
    private val usersUseCase: UsersUseCase
) : ViewModel() {
    private val _usersValue = MutableStateFlow(UserListState())
    var usersValue: StateFlow<UserListState> = _usersValue

    fun getUsers() = viewModelScope.launch(Dispatchers.IO) {
        usersUseCase().collect {
            when (it) {
                is Response.Error -> {
                    _usersValue.value = UserListState(userList = it.data ?: emptyList())
                }

                is Response.Loading -> {
                    _usersValue.value = UserListState(isLoading = true)
                }

                is Response.Success -> {
                    _usersValue.value = UserListState(error = it.message ?: "An Unexpected Error")
                }
            }
        }
    }
}