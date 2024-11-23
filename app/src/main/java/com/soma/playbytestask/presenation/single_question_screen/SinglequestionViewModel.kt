package com.soma.playbytestask.presenation.single_question_screen

import android.content.Context
import android.media.MediaPlayer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.soma.playbytestask.R
import com.soma.playbytestask.UserDetails
import com.soma.playbytestask.data.ChatMessage
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SinglequestionViewModel():ViewModel() {

    private var _state = MutableStateFlow(SinglequestionState())
    val state = _state.asStateFlow()



    fun addmessage(){
            _state.update {
                it.copy(
                    messages = state.value.messages+ChatMessage(UserDetails.username,state.value.inputmessage,R.drawable.avatar2),
                    inputmessage = ""
                )
            }
    }

    fun changeMessage(newmessage:String){
        _state.update {
            it.copy(
                inputmessage = newmessage
            )
        }
    }


}