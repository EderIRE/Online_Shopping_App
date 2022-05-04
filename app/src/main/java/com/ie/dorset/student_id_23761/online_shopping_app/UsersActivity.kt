package com.ie.dorset.student_id_23761.online_shopping_app

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Response

class UsersActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)

        val btn = findViewById<Button>(R.id.btnBack)

        btn.setOnClickListener {
            val intent = Intent(this, MainPage::class.java)
            startActivity(intent)
            finish()
        }


        val serviceGenerator = ServiceGenerator.buildService(ApiServiceUsers::class.java)
        val call = serviceGenerator.getUsers()


        val recycleView = findViewById<RecyclerView>(R.id.recycleView2)

        call.enqueue(object : retrofit2.Callback<MutableList<Users>> {
            override fun onResponse(
                call: Call<MutableList<Users>>,
                response: Response<MutableList<Users>>
            ) {
                if (response.isSuccessful) {
                    recycleView.apply {
                        layoutManager = LinearLayoutManager(this@UsersActivity)
                        adapter = PostAdapterUsers(response.body()!!)
                    }
                }
            }

            override fun onFailure(call: Call<MutableList<Users>>, t: Throwable) {
                Log.e("Error", t.message.toString())
            }

        })


    }

}