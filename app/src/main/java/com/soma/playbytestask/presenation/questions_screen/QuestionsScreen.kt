package com.soma.playbytestask.presenation.questions_screen

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.soma.playbytestask.R
import com.soma.playbytestask.data.QuestionItem
import com.soma.playbytestask.data.questions
import com.soma.playbytestask.navigation.Screens

@Composable
fun QuestionsScreen(navController:NavHostController) {
    BackHandler {
        navController.popBackStack()
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Heading
        Text(
            text = "QUESTIONS",
            color = Color(0xFF6E6E6E),
            fontSize = 22.sp,
            modifier = Modifier.padding(vertical = 16.dp),
            fontFamily = FontFamily(Font(R.font.roboto_medium))
        )
        Divider(
            color = Color.LightGray,
            thickness = 1.dp,
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, top = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "PREVIOUS QUESTIONS",
                fontSize = 14.sp,
                color = Color(0xFF6E6E6E),
                fontFamily = FontFamily(Font(R.font.roboto_bold))
            )
            Spacer(modifier = Modifier.width(5.dp))
            Divider(
                color = Color.LightGray,
                thickness = 1.dp,
            )
        }


        Column(
            modifier = Modifier
                .padding(12.dp)
                .verticalScroll(rememberScrollState())
        ){
            for(ind in 0 until questions.size){
                QuestionCard(questions[ind]){
                    navController.navigate(Screens.SingleQuestionScreen.passData(ind))
                }
                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    }
}

@Composable
fun QuestionCard(question: QuestionItem, onclick:()->Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, shape = RoundedCornerShape(8.dp))
            .clickable {
                onclick()
            }
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(8.dp)
            )
            .padding(8.dp)
            .padding(vertical = 8.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.both_image),
            contentDescription = null,
            modifier = Modifier
                .size(60.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Color(0xFFACD3FF))
        )
        Column {
            Text(
                text = question.text,
                color = Color(0xFF383838),
                fontWeight = FontWeight(700),
                fontSize = 18.sp,
                fontFamily = FontFamily(Font(R.font.roboto_bold)),
                modifier = Modifier
                    .heightIn(80.dp, 450.dp)
                    .padding(start = 10.dp)
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 4.dp)
            ) {
                Text(text = buildAnnotatedString{
                    withStyle(
                        style = SpanStyle(
                            fontSize = 13.sp,
                            color = Color(0xFF4A90E2),
                            fontWeight = FontWeight(500)
                        )
                    ){
                        append("${question.answers} of your friends")
                    }
                    withStyle(style = SpanStyle(
                        fontSize = 13.sp,
                        color = Color.Gray
                    )
                    ){
                        append(" answered this question")
                    }
                }, fontFamily = FontFamily(Font(R.font.roboto_regular)))
                Spacer(modifier = Modifier.width(4.dp))
                Image(painter = if (question.answers>=50) painterResource(id = R.drawable.people_three) else painterResource(
                    id = R.drawable.people_two
                ), contentDescription = null, modifier = Modifier
                    .width(24.dp)
                    .height(20.dp))
            }

        }
    }
}



