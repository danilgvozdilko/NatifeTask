package com.example.natifetask.ui.main

import androidx.navigation.NavController
import com.example.natifetask.data.GifItem
import com.example.natifetask.navigation.NavigationComponentScreen

class MainScreen(private val gifItem: GifItem) :
    NavigationComponentScreen {

    override fun execute(navigator: NavController) {
        navigator.navigate(MainFragmentDirections.actionMainFragmentToSelected(gifItem))
    }

}