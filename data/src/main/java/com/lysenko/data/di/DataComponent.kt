package com.lysenko.data.di

import com.lysenko.data.remote.helpers.RetrofitFactory
import dagger.Component

@Component
interface DataComponent {

    fun getRetrofit():RetrofitFactory

}

