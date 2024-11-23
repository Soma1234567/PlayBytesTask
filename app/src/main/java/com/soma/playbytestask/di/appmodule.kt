package com.soma.playbytestask.di

import com.soma.playbytestask.presenation.login_screen.LoginViewModel
import com.soma.playbytestask.presenation.single_question_screen.SinglequestionViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appmodule = module {
    viewModel<LoginViewModel> {
        LoginViewModel()
    }

    viewModel<SinglequestionViewModel>{
        SinglequestionViewModel()
    }
}