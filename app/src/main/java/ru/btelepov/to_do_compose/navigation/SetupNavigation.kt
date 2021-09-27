package ru.btelepov.to_do_compose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import ru.btelepov.to_do_compose.navigation.destinations.listComposable
import ru.btelepov.to_do_compose.navigation.destinations.taskComposable

import ru.btelepov.to_do_compose.util.Constants.LIST_SCREEN

@Composable
fun SetupNavigation(navHostController: NavHostController) {
    val screen = remember(navHostController) {
        Screens(navHostController)
    }
    NavHost(navController = navHostController, startDestination = LIST_SCREEN) {
        listComposable(navigateToTaskScreen = screen.task)
        taskComposable(
            navigateToTaskScreen = screen.list
        )
    }
}