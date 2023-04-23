package com.example.quotesapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class QuotesAdapter(private val listener : QuotesItemClicked, private val context : Context, private val quotesAr : ArrayList<QuotesModal>) : RecyclerView.Adapter<QuotesAdapter.viewHolder>() {
    class viewHolder(itemview : View) : RecyclerView.ViewHolder(itemview){

        val categoryImage = itemview.findViewById<ImageView>(R.id.categoryImage)
        val categoryName = itemview.findViewById<TextView>(R.id.categoryName)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.categoty, parent, false)
        val viewHolder = viewHolder(view)
        view.setOnClickListener {
            listener.onItemClicked(quotesAr[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun getItemCount(): Int {
        return quotesAr.size
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val currentItem = quotesAr[position]
        holder.categoryName.text = currentItem.category
        holder.categoryImage.setImageResource(currentItem.img)
    }
}

interface QuotesItemClicked{
    fun onItemClicked(item : QuotesModal)
}