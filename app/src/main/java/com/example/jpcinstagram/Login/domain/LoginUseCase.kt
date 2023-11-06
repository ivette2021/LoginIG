package com.example.jpcinstagram.Login.domain

import com.example.jpcinstagram.data.LoginRepository

class LoginUseCase { //llamamos en VM
    private val repository = LoginRepository()//ingresar el repo aqui

    suspend operator fun invoke(user: String, password:String): Boolean{ //todo ira en la misma corrutina
        return repository.doLogin(user, password) //
    }
}