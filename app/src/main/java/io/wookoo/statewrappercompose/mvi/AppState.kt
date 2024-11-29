package io.wookoo.statewrappercompose.mvi

data class AppState(
    val isSuccess: Boolean = false,
    val isLoading: Boolean = false,
    val error: Pair<Boolean, String?> = false to null,
    val data: String = ""
)
