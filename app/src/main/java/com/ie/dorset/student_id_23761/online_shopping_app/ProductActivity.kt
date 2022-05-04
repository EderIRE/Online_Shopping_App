package com.ie.dorset.student_id_23761.online_shopping_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Response

class ProductActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.secBtn)
        val btnCarts = findViewById<Button>(R.id.secCarts)
        val btnMain = findViewById<Button>(R.id.secMain)

        btnMain.setOnClickListener {
            val intent = Intent(this, MainPage::class.java)
            startActivity(intent)
            finish()
        }

        btnCarts.setOnClickListener {
            val intent = Intent(this, CartsActivity::class.java)
            startActivity(intent)
            finish()
        }

        btn.setOnClickListener {
            val intent = Intent(this, UsersActivity::class.java)
            startActivity(intent)
            finish()
        }

        val serviceGenerator = ServiceGenerator.buildService(ApiServiceProducts::class.java)
        val call = serviceGenerator.getProducts()


        val recycleView = findViewById<RecyclerView>(R.id.recycleView)

        call.enqueue(object : retrofit2.Callback<MutableList<Products>> {
            override fun onResponse(
                call: retrofit2.Call<MutableList<Products>>,
                response: Response<MutableList<Products>>
            ) {
                if (response.isSuccessful) {
                   recycleView.apply {
                       layoutManager = LinearLayoutManager(this@ProductActivity)
                       adapter = PostAdapterProducts(response.body()!!)
                   }
                }
            }

            override fun onFailure(call: retrofit2.Call<MutableList<Products>>, t: Throwable) {
                t.printStackTrace()
                Log.e("Error", t.message.toString())

            }

        })


    }
}



