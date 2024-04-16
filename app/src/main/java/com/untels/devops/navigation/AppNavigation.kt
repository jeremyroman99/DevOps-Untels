package com.untels.devops.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.untels.devops.screens.CollaboratorScreen
import com.untels.devops.screens.HomeScreen
import com.untels.devops.screens.ResourceScreen
import kotlinx.coroutines.selects.select

@Composable
fun AppNavigation(){
    val navController : NavHostController = rememberNavController()
        
    Scaffold(
        bottomBar = {
            NavigationBar (modifier = Modifier
                .height(65.dp)
                ) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                
                lisOfNavItems.forEach{navItem ->
                    NavigationBarItem(
                        selected = currentDestination?.hierarchy?.any{it.route == navItem.route} == true,
                        onClick = {
                                  navController.navigate(navItem.route){
                                      popUpTo(navController.graph.findStartDestination().id){
                                          saveState = true
                                      }
                                      launchSingleTop = true
                                      restoreState = true
                                  }
                        },
                        icon = { 
                               Icon(
                                   imageVector = navItem.icon,
                                   contentDescription = null)
                               },
                        label ={
                            Text(text = navItem.label)
                        })
                }
            }

        }
    ){ paddingValues : PaddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screens.HomeScreen.name,
            modifier = Modifier
                .padding(paddingValues)
        ) {
            composable( route = Screens.CollaboratorScreen.name){
               CollaboratorScreen()
            }
            composable( route = Screens.HomeScreen.name){
                HomeScreen()
            }
            composable( route = Screens.ResourceScreen.name){
                ResourceScreen()
            }
        }
    }
}