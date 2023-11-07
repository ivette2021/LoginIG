package com.example.jpcinstagram.data.network

import com.example.jpcinstagram.data.LoginClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import javax.inject.Inject

class LoginService @Inject constructor(private val loginClient: LoginClient) { //aac no es tan simple usamos la cuarta forma con los provider
  //  private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun doLogin(user:String , password:String):Boolean{
        return withContext(Dispatchers.IO){
            val response = loginClient.doLogin() //recortamos la parte del codigo y lo enviamos a network module //implementamos la interfaz de login client
            response.body()?.success?: false
        }
    }
}