package com.ie.dorset.student_id_23761.online_shopping_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class PostAdapterCarts (val carts: MutableList<Carts>): RecyclerView.Adapter<PostViewHolderCarts>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolderCarts {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cart_list, parent, false)
        return PostViewHolderCarts(view)
    }

    override fun onBindViewHolder(holder: PostViewHolderCarts, position: Int) {
        return holder.bindView(carts[position])

    }

    override fun getItemCount(): Int {
        return carts.size
    }

}

class PostViewHolderCarts(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val id: TextView = itemView.findViewById(R.id.id)
    private val userId : TextView = itemView.findViewById(R.id.userId)
    private val date : TextView = itemView.findViewById(R.id.date)





    fun bindView(post: Carts) {
        id.text = "Id: ${post.id.toString()}"
        userId.text = "User ID: ${post.userId.toString()}"
        date.text = "Date: ${post.date.toString()}"





    }
}