package com.lysenko.data.remote.helpers

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.lysenko.data.remote.services.ApiService
import kotlinx.serialization.UnstableDefault
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Inject

class RetrofitFactory @Inject constructor() {
    companion object {
        val baseUrl = "https://api.opendota.com/api/"

        private fun getOkHttpInstance(): OkHttpClient {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            return OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build()
        }
    }

    @UnstableDefault
    private fun getRetrofitClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
//            .client(getOkHttpInstance())
            .addConverterFactory(Json.nonstrict.asConverterFactory("application/json".toMediaType()))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }

    @UnstableDefault
    fun getHeroesService() = getRetrofitClient().create(ApiService::class.java)
}