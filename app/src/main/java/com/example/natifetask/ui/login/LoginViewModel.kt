package com.example.natifetask.ui.login

import com.example.natifetask.navigation.Command
import com.example.natifetask.navigation.Router
import com.example.natifetask.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val router: Router) : BaseViewModel() {

    fun navigateToRegistrate() {
        router.execute(Command.Navigate(LoginScreen(LoginScreen.ToFragment.RegistrateFragment)))
    }

    fun navigateToMain() {
        router.execute(Command.Navigate(LoginScreen(LoginScreen.ToFragment.MainFragment)))
    }

}