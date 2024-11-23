package com.soma.playbytestask.presenation.login_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel:ViewModel() {

    private var _loginstate = MutableStateFlow(LoginState())
    val  loginstate = _loginstate.asStateFlow()

    fun changeUsername(user:String){
        _loginstate.update {
            it.copy(
                username = user
            )
        }
    }

    fun changePassword(pass:String){
        _loginstate.update {
            it.copy(
                passoword = pass
            )
        }
    }

    fun loginuser(onsuccess:()->Unit){
        viewModelScope.launch {
            val userregex = "^[A-Za-z]+$".toRegex()
            if (loginstate.value.username.isNotBlank() && userregex.matches(loginstate.value.username)){
                if(loginstate.value.passoword.length>=8){
                    val passregex = "^(?=.*[A-Z])(?=.*\\d)(?=.*[!@#\$%^&*(),.?\":{}|<>]).*$".toRegex()
                    if(passregex.matches(loginstate.value.passoword))
                    {
                        _loginstate.update {
                            it.copy(
                                error  = ""
                            )
                        }
                        onsuccess()
                    }
                    else{
                        _loginstate.update {
                            it.copy(
                                error = "Password must contain At least one uppercase letter, one number, and one special character"
                            )
                        }
                    }
                }
                else{
                    _loginstate.update {
                        it.copy(
                            error = "Password must contain atleast 8 characters"
                        )
                    }
                }
            }
            else{
                _loginstate.update {
                    it.copy(
                        error = "Username must be non-empty and contain only alphabetic characters"
                    )
                }
            }
        }
    }
}