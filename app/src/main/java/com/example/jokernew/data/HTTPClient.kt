package com.example.jokernew.data

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object HTTPClient {
    private const val BASE_URL = "https://api.tiagoaguiar.co/jokerapp/"
    const val API_KEY = "5b9bcf18-26cb-4367-b2aa-7b90384736a3"



        private fun httpClient() : OkHttpClient {
            val loggin = HttpLoggingInterceptor()

            loggin.level =  HttpLoggingInterceptor.Level.BODY

            return OkHttpClient.Builder()
                .addInterceptor(loggin)
                .build()
        }

    fun retrofit(): Retrofit{

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient())
            .build()
    }
}