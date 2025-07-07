package com.ecorise.ecorise

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun EcoRiseApp(modifier: Modifier = Modifier) {

    var currentScreen by remember { mutableStateOf("forgot_password") }

    when (currentScreen) {
        "forgot_password" -> ForgotPasswordScreen(
            onBackToLogin = {  },
            onSend = {  }
        )
        "new_password" -> PasswordScreen()

    }
}