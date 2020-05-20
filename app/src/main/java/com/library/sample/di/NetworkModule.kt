package com.library.sample.di

import com.library.sample.BuildConfig
import com.library.sample.endpoint.SampleEndpoint
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class NetworkModule {
    @Singleton
    @Provides
    fun provideCoinBaseEndpoint(retrofit: Retrofit): SampleEndpoint =
        retrofit.newBuilder().baseUrl(BuildConfig.REST_URL).build()
            .create(SampleEndpoint::class.java)
}