package com.ie.dorset.student_id_23761.online_shopping_app

import java.util.*


data class Products (
    val title : String? = null,
    val price : Double? = null,
    val description : String? = null,
    val image : String? = null,
    val category : String? = null
)

data class Users (
    val email : String? = null,
    val username : String? = null,
    val password : String? = null
)

data class Carts(
    val id: Int? = null,
    val userId: Int? = null,
    val date: Date? = null

)

data class SignIn (
    val username : String? = null,
    val password : String? = null
)

