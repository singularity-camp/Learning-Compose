package kz.singularity.learningcompose.ui.user_profile

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.snapshots.SnapshotStateMap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.singularity.domain.models.User
import kz.singularity.domain.use_cases.GetUsersUseCase

class ProfileViewModel(
    private val getUsersUseCase: GetUsersUseCase,
) : ViewModel() {
    private val _users = mutableStateListOf<User>()

    private val _userIdToUserMap = mutableStateMapOf<Long, User>()
    val userIdToUserMap: SnapshotStateMap<Long, User> = _userIdToUserMap

    init {
        viewModelScope.launch {
            val users = getUsersUseCase()
            _users.addAll(users)

            users.forEach{
                _userIdToUserMap[it.id.toLong()] = it
            }
        }
    }
}