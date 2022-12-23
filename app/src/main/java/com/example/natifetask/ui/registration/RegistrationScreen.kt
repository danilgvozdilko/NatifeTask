package com.example.natifetask.ui.registration

import androidx.navigation.NavController
import com.example.natifetask.R
import com.example.natifetask.navigation.NavigationComponentScreen

class RegistrationScreen(private val from: ToFragment) : NavigationComponentScreen {

    override fun execute(navigator: NavController) {
        when (from) {
            ToFragment.LoginFragment -> {
                navigator.navigate(R.id.action_registerFragment_to_loginFragment)
            }
            ToFragment.MainFragment -> {
                navigator.navigate(R.id.action_registerFragment_to_mainFragment)
            }
        }
    }

    enum class ToFragment {
        LoginFragment, MainFragment
    }

}