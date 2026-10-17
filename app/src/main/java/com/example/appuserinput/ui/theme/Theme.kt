package com.example.appuserinput.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import com.example.appuserinput.R

@Composable
fun QuestTheme(content: @Composable () -> Unit) {
    val colors = lightColorScheme(
        primary = colorResource(R.color.purple_button),
        onPrimary = colorResource(R.color.white),
        background = colorResource(R.color.screen_background),
        surface = colorResource(R.color.white),
        onSurface = colorResource(R.color.text_primary)
    )
    MaterialTheme(colorScheme = colors, content = content)
}