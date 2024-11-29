package io.wookoo.statewrappercompose.domain

sealed interface StateWrapper<out T, out E> {

    data object Loading : StateWrapper<Nothing, Nothing>

    data class Success<T>(val data: T) : StateWrapper<T, Nothing>

    data class Failure<E>(val error: E) : StateWrapper<Nothing, E>
}

fun <T, E> StateWrapper<T, E>.getData(): T = (this as StateWrapper.Success).data

fun <E> StateWrapper<*, E>.getErrorOrNull(): E? =
    (this as? StateWrapper.Failure<E>)?.error
