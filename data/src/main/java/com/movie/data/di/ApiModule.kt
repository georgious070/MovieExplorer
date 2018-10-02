package com.movie.data.di

import com.movie.data.Const
import com.movie.data.TheMovieApi
import okhttp3.OkHttpClient
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val apiModule = module {
    single { provideOkHttpClient() }
    single { provideRetrofitBuilder(get()) }
    single { provideApi(get()) }
}

fun provideOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
                .build()

fun provideRetrofitBuilder(client: OkHttpClient): Retrofit =
        Retrofit.Builder()
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(Const.BASE_URL)
                .build()

fun provideApi(retrofit: Retrofit): TheMovieApi =
        retrofit.create(TheMovieApi::class.java)