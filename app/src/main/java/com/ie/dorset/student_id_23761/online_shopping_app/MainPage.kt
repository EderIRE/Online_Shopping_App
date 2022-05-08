package com.ie.dorset.student_id_23761.online_shopping_app

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.system.exitProcess


class MainPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_page)



        val btn = findViewById<Button>(R.id.start)
        val btnExit = findViewById<FloatingActionButton>(R.id.btnExit)
        val username = findViewById<EditText>(R.id.username)
        val password = findViewById<EditText>(R.id.password)


        val serviceGenerator = ServiceGenerator.buildService(ApiServiceUsers::class.java)
        val call = serviceGenerator.getUsers()


        val recycleView = findViewById<RecyclerView>(R.id.recycleView2)





        /*
        val serviceGenerator = ServiceGenerator.buildService(ApiServiceSignIn::class.java)
        val call = serviceGenerator.signIn("johnd", "m38rmF$")




        call.enqueue(object : Callback<MutableList<SignIn>> {
            override fun onResponse(
                call: Call<MutableList<SignIn>>,
                response: Response<MutableList<SignIn>>
            ) {
                if (response.isSuccessful) {
                    Log.i("Success", response.body()!!.toString())

                    }
                }

            override fun onFailure(call: Call<MutableList<SignIn>>, t: Throwable) {
                Log.e("Error", "Your API failed")
            }
        })
         */




        btn.setOnClickListener {
            val user = username.text.toString()
            val pass = password.text.toString()

            if (user.isEmpty() || pass.isEmpty()) {
                Toast.makeText(
                    this@MainPage,
                    "User or password is empty",
                    Toast.LENGTH_SHORT
                ).show()
            }
            if((user == "johnd" && pass == "m38rmF$")
                    || (user == "mor_2314" && pass == "83r5^_")
                    || (user == "kevinryan" && pass == "kev02937@")
                    || (user == "donero" && pass == "ewedon")
                    || (user == "derek" && pass == "jklg*_56")
                    || (user == "david_r" && pass == "3478*#54")
                    || (user == "snyder" && pass == "f238&@*$")
                    || (user == "hopkins" && pass == "William56\$hj")
                    || (user == "kate_h" && pass == "kfejk@*_")
                    || (user == "jimmie_k" && pass == "klein*#%*")) {

                    val intent = Intent(this@MainPage, ProductActivity::class.java)
                    startActivity(intent)
                    finish()

            }
            else Toast.makeText(this@MainPage, "User Invalid", Toast.LENGTH_SHORT).show()


        }




        btnExit.setOnClickListener {
            finish()
            exitProcess(0)
        }

















    }


}


