
package io.wookoo.statewrappercompose.domain

import kotlinx.coroutines.flow.Flow

interface IRepository {
    fun loadData(): Flow<StateWrapper<String, Any>>
}