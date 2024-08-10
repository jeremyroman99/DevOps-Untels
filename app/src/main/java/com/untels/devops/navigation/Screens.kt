package com.untels.devops.navigation

sealed class Screens(
    val route: String,
) {
    object HomeScreen : Screens("homeScreen")
    object ResourceScreen : Screens("resourceScreen")
    object CollaboratorScreen : Screens("collaboratorScreen")
}