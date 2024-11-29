package io.wookoo.statewrappercompose.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.wookoo.statewrappercompose.domain.IRepository
import io.wookoo.statewrappercompose.domain.StateWrapper
import io.wookoo.statewrappercompose.domain.getData
import io.wookoo.statewrappercompose.domain.getErrorOrNull
import io.wookoo.statewrappercompose.mvi.AppEvent
import io.wookoo.statewrappercompose.mvi.AppState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AppViewModel(
    private val repository: IRepository
) : ViewModel() {

    private val _state = MutableStateFlow(AppState())
    val state = _state.asStateFlow()

    init {
        onEvent(AppEvent.LoadData)
    }

    private fun onEvent(event: AppEvent) {
        when (event) {
            AppEvent.LoadData -> {
                viewModelScope.launch {
                    repository.loadData().collect { stateWrapper ->
                        when (stateWrapper) {
                            StateWrapper.Loading -> {
                                _state.update {
                                    it.copy(isLoading = true)
                                }
                            }

                            is StateWrapper.Failure -> {
                                _state.update {
                                    it.copy(
                                        error = Pair(
                                            true,
                                            stateWrapper.getErrorOrNull().toString()
                                        )
                                    )
                                }
                            }

                            is StateWrapper.Success -> {
                                _state.update {
                                    it.copy(
                                        isLoading = false,
                                        isSuccess = true,
                                        data = stateWrapper.getData()
                                    )
                                }
                                /**
                                 * Simulate showing an animation
                                 * */
                                delay(2000)

                                /**
                                 * Reset the success state after the animation
                                 * */
                                _state.update {
                                    it.copy(isSuccess = false)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}







