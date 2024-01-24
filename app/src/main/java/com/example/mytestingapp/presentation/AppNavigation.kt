package com.example.mytestingapp.presentation

import androidx.compose.animation.core.tween
import androidx.compose.animation.expandIn
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mytestingapp.presentation.ui.screens.DetailsScreen
import com.example.mytestingapp.presentation.ui.screens.MainScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screens.MainScreen.route,
    ) {
        composable(route = Screens.MainScreen.route,
            enterTransition = { expandIn( expandFrom = Alignment.Center, animationSpec = tween(3000)) },
        ) {
            MainScreen(navController = navController)
        }
        composable(
            route = Screens.DetailsScreen.route + "/{name}",
            arguments = listOf(
                navArgument(name = "name") {
                    type = NavType.StringType
                }
            ),
            enterTransition = { expandIn( expandFrom = Alignment.TopCenter, animationSpec = tween(3000))},
            ) { entry ->
            DetailsScreen(entry.arguments?.getString("name"))
        }
    }
}