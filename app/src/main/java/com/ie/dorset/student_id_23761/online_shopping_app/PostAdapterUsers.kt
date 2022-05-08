package com.ie.dorset.student_id_23761.online_shopping_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView


class PostAdapterUsers (val users: MutableList<Users>): RecyclerView.Adapter<PostViewHolders>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolders {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.users_list, parent, false)
        return PostViewHolders(view)
    }

    override fun onBindViewHolder(holder: PostViewHolders, position: Int) {
        return holder.bindView(users[position])
    }

    override fun getItemCount(): Int {
        return users.size
    }

}

class PostViewHolders(itemView: View) : RecyclerView.ViewHolder(itemView){
    private val email : TextView = itemView.findViewById(R.id.email)
    private val username : TextView = itemView.findViewById(R.id.username)
    private val password : TextView = itemView.findViewById(R.id.password)




    fun bindView(post: Users) {
        email.text = "Email: ${post.email}"
        username.text = "Username: ${post.username}"
        password.text = "Password: ${post.password}"

        itemView.setOnClickListener {

            Toast.makeText(itemView.context, "${post.email}", Toast.LENGTH_LONG).show()

        }

    }

}

