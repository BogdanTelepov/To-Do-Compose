package ru.btelepov.to_do_compose.navigation

import androidx.navigation.NavHostController
import ru.btelepov.to_do_compose.util.Action
import ru.btelepov.to_do_compose.util.Constants.LIST_SCREEN

class Screens(navHostController: NavHostController) {
    val list: (Action) -> Unit = {
        navHostController.navigate("list/${it.name}") {
            popUpTo(LIST_SCREEN) { inclusive = true }
        }
    }

    val task: (Int) -> Unit = {
        navHostController.navigate("task/$it")
    }
}