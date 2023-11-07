package com.example.jpcinstagram.Login.domain

import com.example.jpcinstagram.data.LoginRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val repository: LoginRepository) { //preparado para ser inyectado

    suspend operator fun invoke(user: String, password:String): Boolean{ //todo ira en la misma corrutina
        return repository.doLogin(user, password) //
    }
}