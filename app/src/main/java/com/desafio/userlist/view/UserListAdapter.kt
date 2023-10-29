package com.desafio.userlist.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.desafio.userlist.databinding.UsersListItemBinding
import com.desafio.userlist.model.User

class UserListAdapter: RecyclerView.Adapter<UserListAdapter.UserItemViewHolder>() {
    var userList:List<User> = mutableListOf()
    class UserItemViewHolder(val binding: UsersListItemBinding): RecyclerView.ViewHolder(binding.root){
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UserListAdapter.UserItemViewHolder {
        val binding = UsersListItemBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return UserItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: UserListAdapter.UserItemViewHolder, position: Int) {
        val user = userList[position]
        holder.binding.textName.text= user.name
        holder.binding.textEmail.text= user.email
        holder.binding.textPhone.text=user.phone
        }






}