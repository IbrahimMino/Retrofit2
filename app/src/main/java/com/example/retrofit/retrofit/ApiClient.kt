package com.example.retrofit.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    val BASE_URL = "https://jsonplaceholder.typicode.com/"
 fun getRetrofit(): Retrofit{
  val retrofit = Retrofit.Builder()
      .baseUrl(BASE_URL)
      .addConverterFactory(GsonConverterFactory.create())
      .build()
     return retrofit
 }
}