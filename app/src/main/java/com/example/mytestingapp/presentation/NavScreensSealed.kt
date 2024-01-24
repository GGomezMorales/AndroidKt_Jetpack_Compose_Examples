package com.example.mytestingapp.presentation

sealed class Screens(val route: String) {
    object MainScreen : Screens("MainScreen")
    object DetailsScreen : Screens("DetailsScreen")
}