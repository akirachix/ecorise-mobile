package com.ecorise.ecorise

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun EcoRiseApp() {
    var currentScreen by remember { mutableStateOf("first") }

    when (currentScreen) {
        "first" -> TeaserScreen(onGetStarted = { currentScreen = "second" })
        "second" -> CreateAccountScreen(onCreateAccount = { currentScreen = "login" })}}