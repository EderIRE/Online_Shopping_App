package com.ie.dorset.student_id_23761.online_shopping_app

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CartsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.carts_activity)


        val mainPage = findViewById<Button>(R.id.main_page)
        mainPage.setOnClickListener{
            startActivity(Intent(this@CartsActivity, MainPage::class.java))
            finish()
        }



        val serviceGenerator = ServiceGenerator.buildService(ApiServiceCarts::class.java)
        val call = serviceGenerator.getCarts()


        val recycleView = findViewById<RecyclerView>(R.id.recycleViewCarts)

        call.enqueue(object : Callback<MutableList<Carts>> {
            override fun onResponse(
                call: Call<MutableList<Carts>>,
                response: Response<MutableList<Carts>>
            ) {
                if (response.isSuccessful) {
                    recycleView.apply {
                        layoutManager = LinearLayoutManager(this@CartsActivity)
                        adapter = PostAdapterCarts(response.body()!!)
                    }
                }
            }

            override fun onFailure(call: Call<MutableList<Carts>>, t: Throwable) {
                Log.e("Error", t.message.toString())
            }

        })





    }
}