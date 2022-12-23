package com.example.natifetask.ui.settings

import androidx.navigation.NavController
import com.example.natifetask.navigation.NavigationComponentScreen

class SettingScreen : NavigationComponentScreen {

    override fun execute(navigator: NavController) {
        navigator.navigate(SettingsFragmentDirections.actionSettingsFragmentToPersonalData())
    }

}