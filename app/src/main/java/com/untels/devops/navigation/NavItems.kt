package com.untels.devops.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.untels.devops.R

data class NavItem(
    val label: String,
    val icon: ImageVector,
    val route: String
)

val lisOfNavItems = listOf(
    NavItem(
        label = "Inicio",
        icon = Icons.Default.Home,
        route = Screens.HomeScreen.name
    ),
    NavItem(
        label = "Recursos",
        icon = Icons.Default.Search,
        route = Screens.ResourceScreen.name
    ),
    NavItem(
        label = "Colaboradores",
        icon = Icons.Default.Person,
        route = Screens.CollaboratorScreen.name
    )
)