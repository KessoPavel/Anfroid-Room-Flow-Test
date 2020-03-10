package com.radiance.roomFlow.ui

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.radiance.roomFlow.R
import com.radiance.roomFlow.db.enity.User
import com.radiance.roomFlow.inflate
import kotlinx.android.synthetic.main.user_item.view.*

class UserAdapter(var data: List<User>): RecyclerView.Adapter<UserAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(parent.inflate(R.layout.user_item, false))
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(data[position])
    }

    class Holder(view: View): RecyclerView.ViewHolder(view) {

        fun bind(user: User) {
            itemView.name.text = "${user.firstName} ${user.lastName}"
        }
    }
}