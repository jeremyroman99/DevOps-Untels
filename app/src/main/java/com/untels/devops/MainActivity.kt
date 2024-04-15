package com.untels.devops

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.untels.devops.navigation.AppNavigation
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material3.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.untels.devops.ui.theme.ScreenA
import com.untels.devops.ui.theme.ScreenB
import com.untels.devops.ui.theme.ScreenC


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Thread.sleep(3000)
        setTheme(R.style.Theme_DevOpsUntels)
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.main_activity)
        setContent {
            MainScreen()
            //AppNavigation()
        }
    }

    @Composable
    fun MainScreen() {
        val navController = rememberNavController()
        Scaffold(
            topBar = {  },
            bottomBar = { BottomNavigationBar(navController) },
            content = { padding ->
                Box(modifier = Modifier.padding(padding)) {
                    Navigation(navController = navController)
                }
            },
            backgroundColor = colorResource(R.color.colorPrimaryDark) // Set background color to avoid the white flashing when you switch between screens
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun MainScreenPreview() {
        MainScreen()
    }

    //it NavBackStackEntryに宛先の画面を渡す
    @Composable
    fun Navigation(navController: NavHostController) {
        NavHost(
            navController,
            startDestination = NavigationItem.ScreenAo.route
        ) {
            composable(NavigationItem.ScreenAo.route) {
                ScreenA()
            }
            composable(NavigationItem.ScreenBo.route) {
                ScreenB()
            }
            composable(NavigationItem.ScreenCo.route) {
                ScreenC()
            }
        }
    }

    @Composable
    fun TopBar() {
        TopAppBar(
            title = { Text (text = stringResource(R.string.app_name), fontSize = 18.sp) },
            backgroundColor = colorResource(id = R.color.colorPrimary),
            contentColor = Color.White
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun TopBarPreview() {
        TopBar()
    }

    @Composable
    fun BottomNavigationBar(navController: NavController) {
        val items = listOf(
            NavigationItem.ScreenAo,
            NavigationItem.ScreenBo,
            NavigationItem.ScreenCo,
        )
        BottomNavigation(
            backgroundColor = colorResource(id = R.color.colorPrimary),
            contentColor = Color.White
        ) {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route
            items.forEach { item ->
                BottomNavigationItem(
                    icon = { Icon(painterResource(id = item.icon), contentDescription = item.title) },
                    label = { Text(text = item.title) },
                    selectedContentColor = Color.White,
                    unselectedContentColor = Color.White.copy(0.4f),
                    alwaysShowLabel = true,
                    selected = currentRoute == item.route,
                    onClick = {
                        navController.navigate(item.route) {

                            navController.graph.startDestinationRoute?.let { route ->
                                popUpTo(route) {
                                    saveState = true
                                }
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun BottomNavigationBarPreview() {
        // BottomNavigationBar()
    }
    fun openUrl(url: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }

    fun openLinkedIn1(view: View?) {
        openUrl("https://www.linkedin.com/in/jeremyroman99/")
    }

    fun openLinkedIn2(view: View?) {
        openUrl("https://www.linkedin.com/in/carloscosme99/")
    }

    fun openyoutube1(view: View?) {
        openUrl("https://www.youtube.com/watch?v=xvFZjo5PgG0")
    }

    fun openyoutube2(view: View?) {
        openUrl("https://www.youtube.com/watch?v=xvFZjo5PgG0")
    }

    fun openinstagram1(view: View?) {
        openUrl("https://www.instagram.com/jeremy.roman99/")
    }

    fun openinstagram2(view: View?) {
        openUrl("https://www.instagram.com/carlosc.0199/")
    }

}


