package com.example.natifetask.ui

import androidx.navigation.NavController
import com.example.natifetask.R
import com.example.natifetask.navigation.NavigationComponentScreen

class MainActivityScreen(val to: ToFragment) : NavigationComponentScreen {
    override fun execute(navigator: NavController) {
        when (to) {
            ToFragment.SettingsFragment -> {
                navigator.navigate(R.id.settingsFragment)
            }
            ToFragment.LoginFragment -> {
                navigator.navigate(R.id.loginFragment)
            }
            ToFragment.HomeFragment -> {
                navigator.navigate(R.id.mainFragment)
            }
            ToFragment.SelectedFragment -> {
                navigator.navigate(R.id.selectedFragment)
            }
        }

    }

    enum class ToFragment {
        LoginFragment, SettingsFragment, HomeFragment, SelectedFragment
    }

}