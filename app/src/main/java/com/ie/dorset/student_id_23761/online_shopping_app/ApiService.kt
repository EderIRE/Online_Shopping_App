package com.ie.dorset.student_id_23761.online_shopping_app

import android.icu.util.ULocale
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.http.*
import java.util.*

interface ApiServiceProducts {
    @GET("/products")
    fun getProducts() : Call<MutableList<Products>>
}

interface ApiServiceUsers {
    @GET("/users")
    fun getUsers() : Call<MutableList<Users>>
}

interface ApiServiceCarts {
    @GET("/carts")
    fun getCarts() : Call<MutableList<Carts>>
}

interface ApiServiceSignIn {
    @FormUrlEncoded
    @POST("/auth/login")
    fun signIn(@Field("username") string: String, @Field("password") storing: String) : Call<MutableList<SignIn>>
}