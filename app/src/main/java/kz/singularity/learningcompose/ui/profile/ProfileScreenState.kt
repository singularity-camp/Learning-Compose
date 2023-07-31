package kz.singularity.learningcompose.ui.profile

import kz.singularity.domain.models.User

sealed class ProfileScreenState{
    object Initial : ProfileScreenState()
    object Loading : ProfileScreenState()
    object Error : ProfileScreenState()
    data class Profile(val user: User) : ProfileScreenState()
}
