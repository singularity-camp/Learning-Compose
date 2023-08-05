package kz.singularity.learningcompose.ui.users

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.singularity.domain.models.Todo
import kz.singularity.domain.models.User
import kz.singularity.domain.use_cases.GetTodosUseCase
import kz.singularity.domain.use_cases.GetUsersUseCase
import org.koin.core.KoinApplication.Companion.init

class UserPageViewModel(
    private val getUsersUseCase: GetUsersUseCase,
) : ViewModel() {
    private val _users = mutableStateListOf<User>()
    val user: SnapshotStateList<User> = _users

    private val _isLoading = mutableStateOf(true)
    val isLoading: State<Boolean> get() = _isLoading

    init {
        fetchData()
    }
    private fun fetchData() {
        viewModelScope.launch {
            try {
                _users.addAll(getUsersUseCase())

                _isLoading.value = false
            } catch (e: Exception) {
                Log.e("MainViewModel", "Error fetching data: ${e.message}")
                _isLoading.value = false // Set isLoading to false on error as well
            }
        }
    }


}