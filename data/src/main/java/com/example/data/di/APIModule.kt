package com.example.data.di

import com.example.data.api.WebService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.logging.HttpLoggingInterceptor

@Module
@InstallIn(SingletonComponent::class)
object APIModule {

    @Provides
    fun provideHttpLoggingInterceptor():HttpLoggingInterceptor{

        return HttpLoggingInterceptor{

        }.apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Provides
    fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {

        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }


    @Provides
    fun  provideGsonConverter(): GsonConverterFactory {

        return GsonConverterFactory.create()
    }

    @Provides
    fun provideRetrofit(gsonConverterFactory: GsonConverterFactory, okHttpClient: OkHttpClient): Retrofit {

        return Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .client(okHttpClient)
            .addConverterFactory(gsonConverterFactory)
            .build()

    }

    @Provides
    fun provideWebService(retrofit: Retrofit): WebService {

        return retrofit.create( WebService::class.java)

    }
}