package com.github.alexeygorovoy.picturesque.ui.splash

import androidx.lifecycle.viewModelScope
import com.github.alexeygorovoy.picturesque.navigation.Router
import com.github.alexeygorovoy.picturesque.ui.common.viewModel.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashViewModel(
    private val router: Router
) : BaseViewModel() {

    fun waitAndOpenNextScreen() {
        viewModelScope.launch {
            delay(500)
            router.openSinglePhotoScreen()
        }
    }
}