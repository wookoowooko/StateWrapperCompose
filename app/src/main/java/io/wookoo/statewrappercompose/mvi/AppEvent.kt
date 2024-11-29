package io.wookoo.statewrappercompose.mvi

sealed interface AppEvent {
    data object LoadData : AppEvent
}
