package com.soma.playbytestask.presenation.login_screen

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.soma.playbytestask.R
import com.soma.playbytestask.UserDetails
import com.soma.playbytestask.navigation.Screens
import org.koin.androidx.compose.getViewModel

@Composable
fun LoginScreen(navController:NavHostController,viewModel: LoginViewModel = getViewModel()) {
    val state by viewModel.loginstate.collectAsState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .then(
                if (isLandscape()) {
                    Modifier.verticalScroll(rememberScrollState())
                } else {
                    Modifier
                }
            )
            .padding(bottom = 5.dp)
            ,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .then(
                    if (isLandscape()) {
                        Modifier.height(480.dp)
                    } else {
                        Modifier.weight(0.64f)
                    }
                )
        ){
                Image(painter = painterResource(id = R.drawable.ellipse), contentDescription = null, modifier = Modifier.fillMaxSize(), contentScale = ContentScale.FillBounds)
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(vertical = 32.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Know Your", fontSize = 20.sp, color = Color.White, fontFamily = FontFamily(
                        Font(R.font.poppins_regular)
                    ), fontWeight = FontWeight(400)
                    )
                    Text(text = "Friends Better", fontSize = 24.sp, color = Color.White, fontWeight = FontWeight(600), fontFamily = FontFamily(
                        Font(R.font.poppins_regular)
                    ))
                    Spacer(modifier = Modifier.weight(0.05f))
                    Image(painter = painterResource(id = R.drawable.img), contentDescription = null, modifier = Modifier.size(350.dp))

                }


        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
                .then(
                    if (isLandscape()) {
                        Modifier.fillMaxHeight()
                    } else {
                        Modifier.weight(0.4f)
                    }
                ),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Join The Fun", color = Color(0xFF2A4D76), fontSize = 22.sp, modifier = Modifier
                .fillMaxWidth(), textAlign = TextAlign.Center, fontWeight = FontWeight(600), fontFamily = FontFamily(
                Font(R.font.roboto_bold)
            ))
            Spacer(modifier = Modifier.then(
                if(isLandscape()){
                    Modifier.height(8.dp)
                }
                else{
                    Modifier.weight(0.04f)
                }
            ))
            CustomTextFieldWithHint(state.username){
                viewModel.changeUsername(it)
            }
            Spacer(modifier = Modifier.then(
                if(isLandscape()){
                    Modifier.height(8.dp)
                }
                else{
                    Modifier.weight(0.04f)
                }
            ))
            PasswordTextField(state.passoword){
                viewModel.changePassword(it)
            }
            Spacer(modifier = Modifier.then(
                if(isLandscape()){
                    Modifier.height(8.dp)
                }
                else{
                    Modifier.weight(0.02f)
                }
            ))
            Row(
                modifier = Modifier.then(
                    if(isLandscape()){
                        Modifier.height(30.dp)
                    }
                    else{
                        Modifier.weight(0.13f)
                    }
                ),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(text = state.error, fontSize = 15.sp, color = Color(0xFFFF3333), textAlign = TextAlign.Center, fontFamily = FontFamily(Font(R.font.roboto_regular)))

            }
            Spacer(modifier = Modifier.then(
                if(isLandscape()){
                    Modifier.height(8.dp)
                }
                else{
                    Modifier.weight(0.02f)
                }
            ))
            Box(
                modifier = Modifier
                    .width(160.dp)
                    .then(
                        if (isLandscape()) {
                            Modifier.height(50.dp)
                        } else {
                            Modifier.weight(0.13f)
                        }
                    )
                    .clickable {
                        viewModel.loginuser() {
                            UserDetails.username = state.username
                            navController.navigate(Screens.QuestionsScreen.route)
                        }
                    }
                    .background(color = Color(0xFF4A90E2), shape = RoundedCornerShape(16.dp)),
                contentAlignment = Alignment.Center
            ){
                Text(text = "Login", fontSize = 23.sp, color = Color.White, fontFamily = FontFamily(Font(R.font.roboto_medium)))
            }
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextFieldWithHint(username:String,onupdate:(new:String)->Unit) {
    OutlinedTextField(
        value = username,
        onValueChange = {
                        onupdate(it)
        },
        placeholder = { Text(text = "Username", color = Color(0xFFB6B6B6), fontFamily = FontFamily(Font(R.font.roboto_regular))) }, // Hint text
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        shape = RoundedCornerShape(30.dp), // Corner radius
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color(0xFF4A90E2),
            unfocusedBorderColor =  Color(0xFF4A90E2), // Custom border color when not focused
            cursorColor = Color(0xFF4A90E2) // Cursor color
        ),
        singleLine = true
    )
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordTextField(password:String,onupdate:(pass:String)->Unit) {
    var passwordVisible by remember { mutableStateOf(false) }

    val visualTransformation: VisualTransformation = if (passwordVisible) {
        VisualTransformation.None
    } else {
        PasswordAsteriskTransformation()  // Custom transformation to show asterisks
    }

    OutlinedTextField(
        value = password,
        onValueChange = { onupdate(it)},
        placeholder = { Text(text = "Password", color = Color(0xFFB6B6B6), fontFamily = FontFamily(Font(R.font.roboto_regular))) },
        visualTransformation = visualTransformation,
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions.Default,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        shape = RoundedCornerShape(30.dp),
        trailingIcon = {
            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                Icon(
                    imageVector = if (passwordVisible) Icons.Filled.VisibilityOff else Icons.Filled.Visibility,
                    contentDescription = if (passwordVisible) "Hide password" else "Show password",
                    tint = Color(0xFF4A90E2)
                )
            }
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color(0xFF4A90E2),
            unfocusedBorderColor = Color(0xFF4A90E2),
            cursorColor = Color(0xFF4A90E2)
        )
    )
}

class PasswordAsteriskTransformation : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        val transformedText = "*".repeat(text.length) // Convert each character to *
        return TransformedText(AnnotatedString(transformedText), OffsetMapping.Identity)
    }
}

@Composable
fun isLandscape(): Boolean {
    val configuration = LocalConfiguration.current
    return configuration.orientation == android.content.res.Configuration.ORIENTATION_LANDSCAPE
}








