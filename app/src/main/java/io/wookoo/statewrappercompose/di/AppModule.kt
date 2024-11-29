package io.wookoo.statewrappercompose.di

import io.wookoo.statewrappercompose.data.RepositoryImpl
import io.wookoo.statewrappercompose.domain.IRepository
import io.wookoo.statewrappercompose.viewmodel.AppViewModel
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    singleOf(::RepositoryImpl) { bind<IRepository>() }
    viewModelOf(::AppViewModel)
}