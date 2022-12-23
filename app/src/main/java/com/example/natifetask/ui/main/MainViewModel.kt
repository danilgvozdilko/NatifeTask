package com.example.natifetask.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.natifetask.data.GifDTO
import com.example.natifetask.data.GifData
import com.example.natifetask.navigation.Command
import com.example.natifetask.navigation.Router
import com.example.natifetask.ui.base.BaseViewModel
import com.example.natifetask.usecase.GetGifUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getGifApiUseCase: GetGifUseCase,
    private val router: Router
) : BaseViewModel() {

    val listImage = MutableLiveData<GifData?>()

    fun getGifs(limit: String) {
        viewModelScope.launch {
            val gifs = getGifApiUseCase.getGif(limit.toInt())
            listImage.value = gifs
        }
    }

    fun navigateToSelected(gifDTO: GifDTO) {
        router.execute(Command.Navigate(MainScreen(gifDTO)))
    }

}