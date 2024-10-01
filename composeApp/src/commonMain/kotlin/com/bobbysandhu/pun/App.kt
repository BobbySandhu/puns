package com.bobbysandhu.pun

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bobbysandhu.pun.modules.HomeScreen
import com.bobbysandhu.pun.modules.SavedScreen
import com.bobbysandhu.pun.modules.SearchScreen
import kotlinproject.composeapp.generated.resources.Res
import kotlinproject.composeapp.generated.resources.ic_home
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        val navController = rememberNavController()

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            bottomBar = {
                BottomNavigation(
                    backgroundColor = Color.White
                ) {
                    BottomNavigationItem(
                        selected = false,
                        onClick = {
                            navController.navigate("home")
                        },
                        label = { Text(text = "Home") },
                        icon = {
                            Icon(
                                painter = painterResource(
                                    Res.drawable.ic_home
                                ),
                                ""
                            )
                        }
                    )
                    BottomNavigationItem(
                        selected = false,
                        onClick = {
                            navController.navigate("search")
                        },
                        label = { Text(text = "Search") },
                        icon = {
                            Icon(
                                painter = painterResource(
                                    Res.drawable.ic_home
                                ),
                                ""
                            )
                        }
                    )
                    BottomNavigationItem(
                        selected = false,
                        onClick = {
                            navController.navigate("saved")
                        },
                        label = { Text(text = "Saved") },
                        icon = {
                            Icon(
                                painter = painterResource(
                                    Res.drawable.ic_home
                                ),
                                ""
                            )
                        }
                    )
                }
            }
        ) {
            NavHost(
                modifier = Modifier.fillMaxSize(),
                navController = navController,
                startDestination = "home"
            ) {
                composable("home") {
                    HomeScreen()
                }
                composable("search") {
                    SearchScreen()
                }
                composable("saved") {
                    SavedScreen()
                }
            }
        }
    }
}