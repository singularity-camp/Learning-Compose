package kz.singularity.learningcompose.ui.user_profile

import kz.singularity.domain.models.User

sealed class UserProfileScreenState {
    object Initial : UserProfileScreenState()
    object Loading : UserProfileScreenState()
    object Error : UserProfileScreenState()
    data class Profile(val user: User) : UserProfileScreenState()
}
