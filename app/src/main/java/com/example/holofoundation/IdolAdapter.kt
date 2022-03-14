package com.example.holofoundation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ListIdolAdapter (private val listIdol: ArrayList<Idols>) : RecyclerView.Adapter<ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_idol, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, bio, image) = listIdol[position]

        Glide.with(holder.itemView.context)
            .load(image)
            .into(holder.img)
        holder.tvName.text = name
        holder.tvDescription.text = bio
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listIdol[holder.adapterPosition])
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Idols)
    }

    override fun getItemCount(): Int = listIdol.size
}



class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    //tv = textview
    var img: ImageView = itemView.findViewById(R.id.img_item_image)
    var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
    var tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
}