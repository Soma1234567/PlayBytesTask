package com.soma.playbytestask.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.soma.playbytestask.presenation.login_screen.LoginScreen
import com.soma.playbytestask.presenation.questions_screen.QuestionsScreen
import com.soma.playbytestask.presenation.single_question_screen.SingleQuestionScreen
//
//@Composable
//fun NavGraph(navController:NavHostController){
//    NavHost(navController = navController, startDestination = Screens.LoginScreen.route){
//        composable(
//            Screens.LoginScreen.route,
//        ) {
//            LoginScreen(navController)
//        }
//
//        composable(
//            Screens.QuestionsScreen.route
//        ) {
//            QuestionsScreen(navController)
//        }
//
//        composable(
//            Screens.SingleQuestionScreen.route,
//            arguments = listOf(
//                navArgument(
//                    name = "q_id"
//                ){
//                    type = NavType.IntType
//                }
//            )
//        ) {
//            val ind = it.arguments?.getInt("q_id")!!
//            SingleQuestionScreen(navController,ind)
//        }
//    }
//}


@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screens.LoginScreen.route
    ) {
        composable(
            Screens.LoginScreen.route,
        ) {
            AnimatedScreenTransition {
                LoginScreen(navController)
            }
        }

        composable(
            Screens.QuestionsScreen.route
        ) {
            AnimatedScreenTransition {
                QuestionsScreen(navController)
            }
        }

        composable(
            Screens.SingleQuestionScreen.route,
            arguments = listOf(
                navArgument(
                    name = "q_id"
                ) {
                    type = NavType.IntType
                }
            )
        ) {
            val ind = it.arguments?.getInt("q_id")!!
            AnimatedScreenTransition {
                SingleQuestionScreen(navController, ind)
            }
        }
    }
}

@Composable
fun AnimatedScreenTransition(
    content: @Composable () -> Unit
) {
    val transitionState = remember {
        MutableTransitionState(false).apply { targetState = true }
    }

    AnimatedVisibility(
        visibleState = transitionState,
        enter = slideInHorizontally(
            initialOffsetX = { fullWidth -> fullWidth } // Enter from the right
        ),
        exit = slideOutHorizontally(
            targetOffsetX = { fullWidth -> -fullWidth } // Exit to the left
        )
    ) {
        content()
    }
}