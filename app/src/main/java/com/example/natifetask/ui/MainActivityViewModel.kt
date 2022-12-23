package com.example.natifetask.ui

import com.example.natifetask.navigation.Command
import com.example.natifetask.navigation.Router
import com.example.natifetask.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(val router: Router) : BaseViewModel() {

    fun navigateToSettings() {
        router.execute(Command.Navigate(MainActivityScreen(MainActivityScreen.ToFragment.SettingsFragment)))
    }

    fun navigateToLogin() {
        router.execute(Command.Navigate(MainActivityScreen(MainActivityScreen.ToFragment.LoginFragment)))
    }

    fun navigateToSelected() {
        router.execute(Command.Navigate(MainActivityScreen(MainActivityScreen.ToFragment.SelectedFragment)))
    }

    fun navigateToHomeFragment() {
        router.execute(Command.Navigate(MainActivityScreen(MainActivityScreen.ToFragment.HomeFragment)))
    }

}