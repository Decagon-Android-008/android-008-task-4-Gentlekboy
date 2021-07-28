package com.gentlekboy.birthdayapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ViewpagerAdapter(val images: ArrayList<Images>): RecyclerView.Adapter<ViewpagerAdapter.ViewpagerViewHolder>() {
    inner class ViewpagerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val slider1: ImageView = itemView.findViewById(R.id.slider_1)
//        val slider2: ImageView = itemView.findViewById(R.id.slider_2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewpagerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewpager_slider, parent, false)
        return ViewpagerViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewpagerViewHolder, position: Int) {
        val currentImage = images[position]
        holder.slider1.setImageResource(currentImage.firstImage)
//        holder.slider2.setImageResource(currentImage.nextImage)
    }

    override fun getItemCount(): Int {
        return images.size
    }
}