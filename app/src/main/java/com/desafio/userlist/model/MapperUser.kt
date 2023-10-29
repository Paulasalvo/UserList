package com.desafio.userlist.model

import com.desafio.userlist.model.dto.UserDTO
import com.desafio.userlist.model.dto.UserDTOItem

class MapperUser {
    fun userDtoToUser(userDTO:UserDTOItem): User{
        return User(
            id = userDTO.id,
            email = userDTO.email,
            name = userDTO.name,
            phone = userDTO.phone
        )
    }
}