package com.soma.playbytestask.presenation.single_question_screen

import android.graphics.BitmapFactory
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.NavigateBefore
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.soma.playbytestask.R
import com.soma.playbytestask.UserDetails
import com.soma.playbytestask.data.ChatMessage
import com.soma.playbytestask.data.questions
import org.koin.androidx.compose.getViewModel

@Composable
fun SingleQuestionScreen(
    navController: NavHostController,
    ind: Int,
    viewModel: SinglequestionViewModel = getViewModel()
) {
    val state by viewModel.state.collectAsState()
    val isLandscapeMode = isLandscape()
    BackHandler {
        navController.popBackStack()
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .verticalScroll(rememberScrollState())
            .padding(top = 8.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 8.dp)
        ) {
            Icon(
                imageVector = Icons.Default.NavigateBefore,
                contentDescription = null,
                tint = Color(0xFF3D3D3D),
                modifier = Modifier
                    .size(30.dp)
                    .align(Alignment.CenterStart)
                    .clickable { navController.popBackStack() }
            )
            Text(
                text = "QUESTIONS",
                color = Color(0xFF6E6E6E),
                fontSize = 22.sp,
                modifier = Modifier.align(Alignment.Center),
                fontFamily = FontFamily(Font(R.font.roboto_medium))
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .then(
                    if (isLandscapeMode) Modifier.height(240.dp)
                    else Modifier.weight(0.22f)
                )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.94f)
                    .background(color = Color(0xFFACD3FF))
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier
                        .weight(0.5f)
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = questions[ind].text,
                        fontSize = 21.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_bold)),
                        fontWeight = FontWeight(700),
                        lineHeight = TextUnit(27f, TextUnitType.Sp),
                        color = Color(0xFF002B5E)
                    )
                }

                Column(
                    modifier = Modifier
                        .weight(0.5f)
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.both_image_quality),
                        contentDescription = null,
                        modifier = Modifier.size(190.dp)
                    )
                }
            }

            Row(
                modifier = Modifier
                    .padding(horizontal = 30.dp)
                    .fillMaxWidth()
                    .height(35.dp)
                    .padding(horizontal = 8.dp)
                    .border(
                        width = 1.dp,
                        color = Color(0xFF81B9FA),
                        shape = RoundedCornerShape(10.dp)
                    )
                    .background(color = Color(0xFFEAF4FF), shape = RoundedCornerShape(10.dp))
                    .padding(horizontal = 8.dp)
                    .align(Alignment.BottomCenter),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "View more questions on this topic",
                    color = Color(0xFF394452),
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_regular))
                )
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null,
                    modifier = Modifier.size(20.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .then(
                    if (isLandscapeMode) Modifier.height(350.dp)
                    else Modifier.weight(0.4f)
                )
        ) {
            ChatScreen(messages = state.messages)
        }

        Spacer(modifier = Modifier.height(4.dp))

        Divider(
            thickness = 2.dp,
            color = Color.LightGray,
            modifier = Modifier.padding(4.dp)
        )

        MessageInputBar(
            messageText = state.inputmessage,
            onMessageChange = viewModel::changeMessage
        ) {
            viewModel.addmessage()
        }
    }
}


@Composable
fun ChatScreen(messages: List<ChatMessage>) {
    Column(
        modifier = Modifier
            .height(395.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        for(message in messages){
            ChatMessageItem(message, isProfileVisible = isProfileVisible(messages, message),UserDetails.username)

        }

    }
}

@Composable
fun ChatMessageItem(
    message: ChatMessage,
    isProfileVisible: Boolean,
    currUsername: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        horizontalArrangement = if (message.username == currUsername) Arrangement.End else Arrangement.Start,
        verticalAlignment = Alignment.Top
    ) {
        if (message.username != currUsername && isProfileVisible) {
            ProfileImage(message.profilePhoto)
            Spacer(modifier = Modifier.width(4.dp))
        } else if (message.username != currUsername) {
            Spacer(modifier = Modifier.width(44.dp))
        }

        Column(
            horizontalAlignment = if (message.username == currUsername) Alignment.End else Alignment.Start,
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 8.dp)
        ) {
            Box(
                modifier = Modifier
                    .background(
                        color = if (message.username == currUsername) Color(0xFF4592EC) else Color(
                            0xFFEFEFEF
                        ),
                        shape = MaterialTheme.shapes.medium
                    )
                    .padding(8.dp)
            ) {
                Column(
                ) {
                    if (isProfileVisible) {
                        Text(
                            text = message.username,
                            fontSize = 12.sp,
                            color = if (message.username == currUsername) Color.White.copy(alpha = 0.7f) else Color(0xFFFF6363),
                            modifier = Modifier.padding(bottom = 4.dp),
                            fontFamily = FontFamily(Font(R.font.roboto_bold))
                        )
                    }

                    Text(
                        text = message.message,
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_regular)),
                        color = if (message.username == currUsername) Color.White else Color(0xFF505050)
                    )
                }
            }
        }

        if (message.username == currUsername && isProfileVisible) {
            Spacer(modifier = Modifier.width(8.dp))
            ProfileImage(message.profilePhoto)
        } else if (message.username == currUsername) {
            Spacer(modifier = Modifier.width(48.dp))
        }
    }
}


@Composable
fun ProfileImage(imageRes: Int) {
    Image(
        painter = painterResource(imageRes),
        contentDescription = "Profile Picture",
        modifier = Modifier
            .size(40.dp)
            .clip(CircleShape)
    )
}

fun isProfileVisible(messages: List<ChatMessage>, currentMessage: ChatMessage): Boolean {
    val index = messages.indexOf(currentMessage)
    if (index == 0) return true
    val previousMessage = messages[index - 1]
    return currentMessage.username != previousMessage.username
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MessageInputBar(
    messageText: String,
    onMessageChange: (String) -> Unit,
    onSendClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // TextField without border
        TextField(
            value = messageText,
            onValueChange = onMessageChange,
            placeholder = { Text(text = "Type a message", color = Color.Gray, fontFamily = FontFamily(Font(R.font.roboto_regular))) },
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color(0xFFEDF2F7),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                cursorColor = MaterialTheme.colorScheme.primary
            ),
            modifier = Modifier
                .weight(1f)
                .padding(end = 8.dp)

        )


        // Circular send button with icon
        Button(
            onClick = onSendClick,
            shape = CircleShape,
            contentPadding = PaddingValues(12.dp),
            modifier = Modifier.size(42.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF4592EC)
            )
        ) {
            Icon(
                imageVector = Icons.Default.ArrowForwardIos,
                contentDescription = "Send Message",
                tint = Color.White
            )
        }
    }
}




@Composable
fun isLandscape(): Boolean {
    val configuration = LocalConfiguration.current
    return configuration.orientation == android.content.res.Configuration.ORIENTATION_LANDSCAPE
}