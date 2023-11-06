package com.example.jpcinstagram.Login

import android.util.Log
import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jpcinstagram.Login.domain.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel //preparamos el viewmodel para ser inyectado en el activity , pero hasta este punto no puede recibir nada
class LoginViewModel @Inject constructor(private val loginUseCase: LoginUseCase) : ViewModel() {//ahora esta preparado para recibir

    //val loginUseCase = LoginUseCase() //creando una instancia

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password


    private val _isLoginEnable = MutableLiveData<Boolean>()
    val isLoginEnable: LiveData<Boolean> = _isLoginEnable

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun onLoginChanged(email: String, password: String) {
        _email.value = email
        _password.value = password
        _isLoginEnable.value = enableLogin(email, password) //esta variable tendra el estado real del boton si se habilita o no

    }

    fun enableLogin(email: String, password: String) =
        //esto es logica no puede ir en una actividad, solo en viewmodel
        Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length > 6

    fun onLoginSelected(){ //esta funcion se va a llamar cuando la el boton login se presione, osea que cuando este habilitado
        viewModelScope.launch {
            _isLoading.value = true //llamada dentro de la corrutina se muestre
            val result = loginUseCase(email.value!!, password.value!!)
            if(result){
                Log.i("Ivette","resultado OK")
            }
            _isLoading.value = false//y cuando termine la llamada se vuelve a false
        }
    }

}