package com.desafio.userlist.model.api

import com.desafio.userlist.model.dto.UserDTO
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface UserApi {
    @GET("/users")
    suspend fun getUserList(): UserDTO
}

private fun getUserListClient(): Retrofit {
    return Retrofit.Builder()
        .client(OkHttpClient())
        .baseUrl("https://jsonplaceholder.typicode.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}
fun getUserListService():UserApi{
    return getUserListClient().create(UserApi::class.java)
}
