package com.example.natifetask.ui.splash

import androidx.lifecycle.viewModelScope
import com.example.natifetask.data.state.SplashState
import com.example.natifetask.navigation.Command
import com.example.natifetask.navigation.Router
import com.example.natifetask.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(private val router: Router) : BaseViewModel() {
    val splash = MutableStateFlow(0)
    val state = MutableStateFlow(SplashState())

    fun loadData() {
        viewModelScope.launch {
            while (splash.value < 9) {
                splash.value = splash.value.plus(1)
                delay(200)
            }
            state.value = state.value.copy(dataLoaded = true)
        }
    }

    fun navigateToRegistration() {
        router.execute(Command.Navigate(SplashScreen()))
    }

}