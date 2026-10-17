package com.example.appuserinput

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.appuserinput.ui.screen.BiodataScreen
import com.example.appuserinput.ui.theme.QuestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuestTheme {
                BiodataScreen()
            }
        }
    }
}
