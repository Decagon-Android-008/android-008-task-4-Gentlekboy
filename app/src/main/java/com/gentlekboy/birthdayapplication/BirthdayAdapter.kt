package com.gentlekboy.birthdayapplication

//Recycler view adapter class
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BirthdayAdapter (var birthdays: ArrayList<Birthdays>): RecyclerView.Adapter<BirthdayAdapter.BirthdayViewHolder>() {
    inner class BirthdayViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val profileImage: ImageView = itemView.findViewById(R.id.profile_image_1)
        val verticalBar: ImageView = itemView.findViewById(R.id.vertical_divider1)
        val personName: TextView = itemView.findViewById(R.id.name_1)
    }

//    Inflates layout to be displayed on recycler view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BirthdayViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.birthday_list, parent, false)
        return BirthdayViewHolder(view)
    }

//    Sets data to view holder
    override fun onBindViewHolder(holder: BirthdayViewHolder, position: Int) {

        holder.personName.text = birthdays[position].name
        holder.profileImage.setImageResource(birthdays[position].profilePicture)
        holder.verticalBar.setImageResource(birthdays[position].verticalBar)
    }

//    Gets the number of items in the arraylist
    override fun getItemCount(): Int {
        return birthdays.size
    }
}