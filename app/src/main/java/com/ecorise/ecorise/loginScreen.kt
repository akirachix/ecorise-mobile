package com.ecorise.ecorise

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.Composable

@Composable
fun LoginScreen(
    onLoginClick: () -> Unit = {},
    onSignUpClick: () -> Unit = {},
    onForgotPasswordClick: () -> Unit = {}
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFFFFF))
            .padding(horizontal = 24.dp, vertical = 170.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Login",
            color = Color(0xFf942222),
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 48.dp)
        )


        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Email",
                fontWeight = FontWeight.Medium,
                fontSize = 15.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                leadingIcon = { Icon(Icons.Default.Email, contentDescription = "Email") },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp)

            )
        }
        Spacer(modifier = Modifier.height(18.dp))


        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Password",
                fontWeight = FontWeight.Medium,
                fontSize = 15.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                leadingIcon = { Icon(Icons.Default.Lock, contentDescription = "Password") },
                singleLine = true,
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp),

                )
        }
        Spacer(modifier = Modifier.height(8.dp))

        Row(
            Modifier
                .fillMaxWidth()
                .padding(top = 30.dp, bottom = 40.dp),
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = "Forgot password?",
                fontSize = 14.sp,
                modifier = Modifier.clickable { onForgotPasswordClick() }
            )
        }


        Button(
            onClick = onLoginClick,
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFf942222)),
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp)
                .align(Alignment.CenterHorizontally),
            shape = RoundedCornerShape(5.dp)
        ) {
            Text("Login", color = Color.White, fontWeight = FontWeight.Bold)
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 28.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Don't have an account?",
                color = Color(0xFF232323),
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = "Sign Up",
                color = Color(0xFf942222),
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                modifier = Modifier.clickable { onSignUpClick() }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLoginScreen() {
    LoginScreen()
}