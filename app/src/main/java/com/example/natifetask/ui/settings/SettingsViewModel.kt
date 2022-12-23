package com.example.natifetask.ui.settings

import com.example.natifetask.navigation.Command
import com.example.natifetask.navigation.Router
import com.example.natifetask.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(val router: Router) : BaseViewModel() {

    fun navigateToPersonalData() {
        router.execute(Command.Navigate(SettingScreen()))
    }

}
