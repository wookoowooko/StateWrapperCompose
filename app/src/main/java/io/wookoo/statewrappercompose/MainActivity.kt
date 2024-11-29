package io.wookoo.statewrappercompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.Crossfade
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import io.wookoo.statewrappercompose.crossfade.CrossFade
import io.wookoo.statewrappercompose.screens.ContentScreen
import io.wookoo.statewrappercompose.screens.ErrorScreen
import io.wookoo.statewrappercompose.screens.LoadingScreen
import io.wookoo.statewrappercompose.screens.SuccessScreen
import io.wookoo.statewrappercompose.ui.theme.StateWrapperComposeTheme
import io.wookoo.statewrappercompose.viewmodel.AppViewModel
import org.koin.androidx.compose.KoinAndroidContext
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val appViewModel = koinViewModel<AppViewModel>()

            KoinAndroidContext {
                StateWrapperComposeTheme {
                    val state by appViewModel.state.collectAsStateWithLifecycle()
                    val isLoading = state.isLoading
                    val isError = state.error
                    val isSuccess = state.isSuccess
                    val data = state.data

                    Crossfade(
                        targetState = when {
                            isError.first -> CrossFade.ERROR
                            isLoading -> CrossFade.LOADING
                            isSuccess -> CrossFade.SUCCESS
                            else -> CrossFade.CONTENT
                        },
                        label = ""
                    ) { screenState ->
                        when (screenState) {
                            CrossFade.LOADING -> LoadingScreen()
                            CrossFade.CONTENT -> ContentScreen(data)
                            CrossFade.SUCCESS -> SuccessScreen()
                            CrossFade.ERROR -> ErrorScreen(isError = isError)
                        }
                    }
                }
            }
        }
    }
}






