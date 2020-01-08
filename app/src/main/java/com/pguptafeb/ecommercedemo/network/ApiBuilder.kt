package com.pguptafeb.ecommercedemo.network

import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit


/**
 * Created by Prashant G. Gupta on 08, Jan 2020
 */

const val BASE_URL: String = "https://stark-spire-93433.herokuapp.com/"

object ApiBuilder {

    val moshi: Moshi = Moshi.Builder().build()

    private val httpLoggingInterceptor =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    private val httpClientBuilder: OkHttpClient.Builder = OkHttpClient.Builder()
        .addInterceptor(httpLoggingInterceptor)
        .readTimeout(60, TimeUnit.SECONDS)
        .connectTimeout(30, TimeUnit.SECONDS)

    private val retrofitBuilder: Retrofit.Builder =
        Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create(moshi))

    fun create(): ApiService {
        retrofitBuilder.baseUrl(BASE_URL)
        retrofitBuilder.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        retrofitBuilder.client(httpClientBuilder.build())
        return retrofitBuilder.build().create(ApiService::class.java)
    }
}