package com.example.retrofit.retrofit

import com.example.retrofit.data.User
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    //Barchasi korsatish
    @GET("users")
    fun getAllUsers(): Call<List<User>>

    //Barcha userni ma'lum bit shartga kora olib keladi
    @GET("users")
    fun getAllUsersWithParam(
        @Query("id") userId: Int,
        @Query("_sort") sort: String,
        @Query("_order") order: String
    ): Call<List<User>>

    //Malum bir userni olib keladi
    @GET("users")
    fun getUser(@Query("email") email: String): Call<List<User>>
}