package com.lysenko.domain.di

import com.lysenko.data.remote.helpers.RetrofitFactory
import com.lysenko.data.remote.providers.DotaProviderImpl
import dagger.Module
import dagger.Provides

@Module
class DomainModule() {

    @Provides
    fun provideIRepository(): DotaProviderImpl{
        return DotaProviderImpl()
    }
}