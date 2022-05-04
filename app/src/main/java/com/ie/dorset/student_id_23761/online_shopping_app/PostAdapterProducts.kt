package com.ie.dorset.student_id_23761.online_shopping_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class PostAdapterProducts(val products: MutableList<Products>): RecyclerView.Adapter<PostViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.products_list, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        return holder.bindView(products[position])
    }

    override fun getItemCount(): Int {
        return products.size
    }

}

class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    private val title : TextView = itemView.findViewById(R.id.title)
    private val price : TextView = itemView.findViewById(R.id.price)
    private val image : ImageView = itemView.findViewById(R.id.image_product)
    private val description : TextView = itemView.findViewById(R.id.description)
    private val category : TextView = itemView.findViewById(R.id.category)

    fun bindView(post: Products) {
        title.text = post.title
        price.text = post.price.toString()
        description.text = post.description
        category.text = post.category

        Glide.with(itemView.context).load(post.image).centerCrop().into(image)




    }

}