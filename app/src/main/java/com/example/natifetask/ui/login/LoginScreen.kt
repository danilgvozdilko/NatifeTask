package com.example.natifetask.ui.login

import androidx.navigation.NavController
import com.example.natifetask.R
import com.example.natifetask.navigation.NavigationComponentScreen

class LoginScreen(private val from: ToFragment) : NavigationComponentScreen {

    override fun execute(navigator: NavController) {
        when (from) {
            ToFragment.RegistrateFragment -> {
                navigator.navigate(R.id.action_loginFragment_to_RegistrateFragment)
            }
            ToFragment.MainFragment -> {
                navigator.navigate(R.id.action_loginFragment_to_MainFragment)
            }
        }
    }

    enum class ToFragment {
        RegistrateFragment, MainFragment
    }

}