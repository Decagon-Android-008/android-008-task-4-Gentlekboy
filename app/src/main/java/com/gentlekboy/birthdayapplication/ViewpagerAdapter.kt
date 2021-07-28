package com.gentlekboy.birthdayapplication

//Recycler view adapter class
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ViewpagerAdapter(val sliderList: ArrayList<Images>): RecyclerView.Adapter<ViewpagerAdapter.ViewpagerViewHolder>() {
    inner class ViewpagerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val sliderImage: ImageView = itemView.findViewById(R.id.slider_1)
        val sliderText: TextView = itemView.findViewById(R.id.sliderText)
    }

    //    Inflates layout to be displayed on view pager
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewpagerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewpager_slider, parent, false)
        return ViewpagerViewHolder(view)
    }

    //    Sets data to view holder
    override fun onBindViewHolder(holder: ViewpagerViewHolder, position: Int) {
        val currentSliderList = sliderList[position]
        holder.sliderImage.setImageResource(currentSliderList.sliderImage)
        holder.sliderText.text = currentSliderList.sliderText
    }

    //    Gets the number of items in the arraylist
    override fun getItemCount(): Int {
        return sliderList.size
    }
}