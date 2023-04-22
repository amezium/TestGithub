package com.thrivae.testgithub.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.squareup.picasso.Picasso
import com.thrivae.testgithub.data.db.HistoryUserDbModel
import com.thrivae.testgithub.R
import com.thrivae.testgithub.domain.DetailsInfUserDto

class HistoryAdapter  : RecyclerView.Adapter<HistoryAdapter.MyHolder>() {

    var users: List<DetailsInfUserDto> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    class MyHolder(view: View) : ViewHolder(view) {
        val avatar = view.findViewById<ImageView>(R.id.imAvatar)
        val name = view.findViewById<TextView>(R.id.tvName)
        val email = view.findViewById<TextView>(R.id.tvEmail)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.history_item_list, parent, false)
        return MyHolder(view)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        Picasso.get()
            .load(users[position].avatarUrl)
            .into(holder.avatar)
        holder.name.text = users[position].name
        holder.email.text = users[position].email ?: "Empty"
    }


}