package com.aditya.bsptechnopracticaltask.common.di

import com.aditya.bsptechnopracticaltask.common.utils.Constants
import com.aditya.bsptechnopracticaltask.data.remote.BookService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun getBookService(retrofit: Retrofit): BookService {
        return retrofit.create(BookService::class.java)
    }


    @Provides
    @Singleton
    fun getRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).client(client).build()
    }

    @Provides
    @Singleton
    fun providesOkhttpClient(loggingInterceptor: Interceptor): OkHttpClient {
        return OkHttpClient.Builder().apply {
            connectTimeout(30, TimeUnit.SECONDS)
            writeTimeout(600, TimeUnit.SECONDS)
            readTimeout(1, TimeUnit.MINUTES)
            retryOnConnectionFailure(true)
            addNetworkInterceptor(loggingInterceptor)
        }.build()
    }

    @Provides
    @Singleton
    fun logInterceptor(): Interceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return loggingInterceptor
    }

}