package com.example.jpcinstagram.core.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    fun getRetrofit(): Retrofit {
        return  Retrofit.Builder()
            .baseUrl("https://run.mocky.io/")//pagina web que nos permite dar respuestas falsas debe terminar en barrita
            .addConverterFactory(GsonConverterFactory.create())//CONVERTIR EL GSON EN DATACLASS
            .build()//CREAR EL OBJETO RETROFIT
    }
}