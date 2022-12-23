package com.example.natifetask.navigation

import androidx.navigation.NavController
import javax.inject.Inject

interface Router {
    fun attachNavController(navController: NavController)
    fun execute(command: Command)
}

sealed class Command {
    data class Navigate(val screen: NavigationComponentScreen) : Command()
    object PopUp : Command()
}

interface Screen<T> {

    fun execute(navigator: T)
}

interface NavigationComponentScreen : Screen<NavController>

class NavigationComponentRouter @Inject constructor() : Router {

    lateinit var navController: NavController

    override fun attachNavController(navController: NavController) {
        this.navController = navController
    }

    override fun execute(command: Command) {
        when (command) {
            is Command.Navigate -> command.screen.execute(navController)
            Command.PopUp -> navController.popBackStack()
        }
    }

}