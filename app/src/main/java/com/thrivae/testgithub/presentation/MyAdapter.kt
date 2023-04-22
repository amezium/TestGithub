package com.thrivae.testgithub.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.squareup.picasso.Picasso
import com.thrivae.testgithub.R
import com.thrivae.testgithub.domain.UserMainDto

class MyAdapter: RecyclerView.Adapter<MyAdapter.MyHolder>() {
    var onItemClick: OnUserClickListener? = null
    var users: List<UserMainDto> = listOf()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    class MyHolder(view: View) : ViewHolder(view) {
        val avatar = view.findViewById<ImageView>(R.id.imAvatar)
        val name = view.findViewById<TextView>(R.id.tvName)
        val id = view.findViewById<TextView>(R.id.tvId)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.users_item_list, parent, false)
        return MyHolder(view)
    }

    override fun getItemCount(): Int {
        return users.size
    }



    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        Picasso.get()
            .load(users[position].avatarUrl)
            .into(holder.avatar)
        holder.name.text = users[position].login
        holder.id.text = users[position].id.toString()
        holder.itemView.setOnClickListener {
            onItemClick?.onUserClick(users[position])
        }
    }

    interface OnUserClickListener {
        fun onUserClick(user: UserMainDto)
    }

}