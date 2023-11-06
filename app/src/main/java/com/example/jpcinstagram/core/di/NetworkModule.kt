package com.example.jpcinstagram.core.di

import com.example.jpcinstagram.data.LoginClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)//el sccope de esta clase o alcance, cuando la activity termine tambien debe terminar la inyeccion de esas instancias
class NetworkModule {

    @Singleton //aqui si llamamos el patron de diseño singleton
    @Provides //asi se llama el provider
    fun provideRetrofit():Retrofit{ //este sera nuestro proveedor nuevo de retrofit
        return  Retrofit.Builder()
            .baseUrl("https://run.mocky.io/")//pagina web que nos permite dar respuestas falsas debe terminar en barrita
            .addConverterFactory(GsonConverterFactory.create())//CONVERTIR EL GSON EN DATACLASS
            .build()//CREAR EL OBJETO RETROFIT
    }

    @Singleton
    @Provides
    fun provideLoginClient(retrofit: Retrofit):LoginClient{ //llamamos el objeto por constructor que necesitemos
        return retrofit.create(LoginClient::class.java)
    }
}