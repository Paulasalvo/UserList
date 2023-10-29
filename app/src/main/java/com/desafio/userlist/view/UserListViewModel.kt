package com.desafio.userlist.view

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.desafio.userlist.model.MapperUser
import com.desafio.userlist.model.User
import com.desafio.userlist.model.api.UserApi
import com.desafio.userlist.model.api.getUserListService
import com.desafio.userlist.model.dto.UserDTO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserListViewModel:ViewModel() {

    private val userApi:UserApi = getUserListService()
    val userListLiveData: MutableLiveData<List<User>> = MutableLiveData()

    fun fetchUserList(){
        viewModelScope.launch {
            val userListDTO = userApi.getUserList()
            val userList:List<User> = userListDTO.map {
                MapperUser().userDtoToUser(it)
            }

            userListLiveData.postValue(userList)
        }

    }


}