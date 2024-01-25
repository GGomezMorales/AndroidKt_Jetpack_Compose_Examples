package com.example.jetpackcomposeexamples.presentation

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jetpackcomposeexamples.presentation.ui.screens.DetailsScreen
import com.example.jetpackcomposeexamples.presentation.ui.screens.MainScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screens.MainScreen.route,
    ) {
        composable(
            route = Screens.MainScreen.route,
        ) {
            MainScreen(navController = navController)
        }
        composable(
            route = Screens.DetailsScreen.route + "/{name}",
            enterTransition = {
                slideInVertically(
                    initialOffsetY = { fullHeight -> fullHeight },
                    animationSpec = tween(1000)
                )
            },
            exitTransition = {
                slideOutVertically(
                    targetOffsetY = { fullHeight -> fullHeight },
                    animationSpec = tween(1000)
                )
            },
            arguments = listOf(
                navArgument(name = "name") {
                    type = NavType.StringType
                }
            )
        ) { entry ->
            DetailsScreen(entry.arguments?.getString("name"))
        }
    }
}