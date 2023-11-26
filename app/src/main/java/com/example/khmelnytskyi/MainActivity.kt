package com.example.khmelnytskyi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.khmelnytskyi.ui.theme.KhmelnytskyiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KhmelnytskyiTheme {
                KhmelnytskyiApp()
            }
        }
    }
}