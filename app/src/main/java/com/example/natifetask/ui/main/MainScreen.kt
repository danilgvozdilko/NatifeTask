package com.example.natifetask.ui.main

import androidx.navigation.NavController
import com.example.natifetask.data.GifDTO
import com.example.natifetask.navigation.NavigationComponentScreen

class MainScreen(private val gifDTO: GifDTO) :
    NavigationComponentScreen {

    override fun execute(navigator: NavController) {
        navigator.navigate(MainFragmentDirections.actionMainFragmentToSelected(gifDTO))
    }

}