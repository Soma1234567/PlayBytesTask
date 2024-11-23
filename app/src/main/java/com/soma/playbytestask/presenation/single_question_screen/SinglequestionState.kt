package com.soma.playbytestask.presenation.single_question_screen

import com.soma.playbytestask.R
import com.soma.playbytestask.UserDetails
import com.soma.playbytestask.data.ChatMessage

data class SinglequestionState(
    val messages:List<ChatMessage> = listOf(
        ChatMessage("John Smith","I'd love to have Mr. Bean as my roommate!",
            R.drawable.avatar1),
        ChatMessage("John Smith","He's hilarious and always finds a way to make everyday life an adventure.",
            R.drawable.avatar1),
        ChatMessage(UserDetails.username,"I'd choose to room with Tony Stark, a.k.a. Iron Man. Imagine the perks! A high-tech apartment, a personal AI assistant (Jarvis) and endless tech gadgets to play with.",
            R.drawable.avatar2),
    ),
    val inputmessage:String = ""
)
