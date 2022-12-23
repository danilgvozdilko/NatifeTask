package com.example.natifetask.ui.registration

import com.example.natifetask.navigation.Command
import com.example.natifetask.navigation.Router
import com.example.natifetask.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(private val router: Router) : BaseViewModel() {

    fun navigateToLogin() {
        router.execute(Command.Navigate(RegistrationScreen(RegistrationScreen.ToFragment.LoginFragment)))
    }

    fun navigateToMain() {
        router.execute(Command.Navigate(RegistrationScreen(RegistrationScreen.ToFragment.MainFragment)))
    }

}