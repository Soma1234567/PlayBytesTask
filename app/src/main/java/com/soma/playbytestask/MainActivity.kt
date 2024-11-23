package com.soma.playbytestask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.soma.playbytestask.navigation.NavGraph
import com.soma.playbytestask.presenation.login_screen.LoginScreen
import com.soma.playbytestask.ui.theme.PlayBytesTaskTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlayBytesTaskTheme {
                val navController = rememberNavController()
                NavGraph(navController = navController)

            }

        }
    }
}

