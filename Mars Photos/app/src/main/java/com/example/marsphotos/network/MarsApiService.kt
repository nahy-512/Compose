package com.example.marsphotos.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

object MarsApi {
    private val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com"
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(ScalarsConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    val retrofitService : MarsApiService by lazy {
        retrofit.create(MarsApiService::class.java)
    }

    interface MarsApiService {
        @GET("photos")
        suspend fun getPhotos(): String
    }
}