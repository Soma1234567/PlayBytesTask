package com.soma.playbytestask.navigation

sealed class Screens(val route:String) {
    object LoginScreen:Screens("login_screen")

    object QuestionsScreen:Screens("questions_screen")

    object SingleQuestionScreen:Screens("single_question/{q_id}"){
        fun passData(id:Int):String{
            return "single_question/$id"
        }
    }
}