package com.lysenko.domain.di

import com.lysenko.data.remote.providers.IDotaProvider
import com.lysenko.domain.repositories.implementations.RepositoryImpl
import dagger.Component

@Component(modules = arrayOf(DomainModule::class))
interface DomainComponent {

    fun inject (repositoryImpl: RepositoryImpl)
}

