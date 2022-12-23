package com.example.natifetask.ui.splash

import androidx.navigation.NavController
import com.example.natifetask.R
import com.example.natifetask.navigation.NavigationComponentScreen

class SplashScreen : NavigationComponentScreen {

    override fun execute(navigator: NavController) {
        navigator.navigate(R.id.action_splashFragment_to_registrationFragment)
    }

}