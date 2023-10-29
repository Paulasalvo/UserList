package com.desafio.userlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.desafio.userlist.databinding.ActivityMainBinding
import com.desafio.userlist.view.UserListAdapter
import com.desafio.userlist.view.UserListViewModel

class MainActivity : AppCompatActivity() {

    val userListViewModel: UserListViewModel = UserListViewModel()
    lateinit var binding: ActivityMainBinding
    val adapter = UserListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userListViewModel.fetchUserList()

        userListViewModel.userListLiveData.observe(this){
            adapter.userList = it
            adapter.notifyDataSetChanged()

        }

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }

}