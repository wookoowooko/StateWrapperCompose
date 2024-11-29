package io.wookoo.statewrappercompose.data

import io.wookoo.statewrappercompose.domain.IRepository
import io.wookoo.statewrappercompose.domain.StateWrapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RepositoryImpl : IRepository {
    override fun loadData(): Flow<StateWrapper<String, Any>> = flow {
        emit(StateWrapper.Loading)
//      delay(3000) // add delay to simulate loading
        try {
//          throw IllegalStateException("Error")// Simulate an error
            emit(StateWrapper.Success("Data"))
        } catch (e: Exception) {
            emit(StateWrapper.Failure(e))
        }
    }
}