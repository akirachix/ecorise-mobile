package com.ecorise.ecorise

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PasswordScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 10.dp, vertical = 76.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Enter New Password",
            fontSize = 24.sp,
            color = Color(0xFF800000), 
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth(0.7f)
                .padding(start = 16.dp)
        )

        Spacer(modifier = Modifier.height(35.dp))


        Text(
            text = "New Password",
            fontSize = 20.sp,
            color = Color.Black,
            modifier = Modifier.align(Alignment.Start)
                .padding(14.dp)
        )

        Spacer(modifier = Modifier.height(1.dp))

        var newPassword by remember { mutableStateOf("") }
        OutlinedTextField(
            value = newPassword,
            onValueChange = { newPassword = it },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        
        Text(
            text = "Confirm Password",
            fontSize = 20.sp,
            color = Color.Black,
            modifier = Modifier.align(Alignment.Start)
                .padding(14.dp)
        )

        Spacer(modifier = Modifier.height(1.dp))

        var confirmPassword by remember { mutableStateOf("") }
        OutlinedTextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
        )

        Spacer(modifier = Modifier.height(84.dp))


        Button(
            onClick = {  },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF800000),
                contentColor = Color.White
            ),
            modifier = Modifier
                .fillMaxWidth(0.6f)
                .height(48.dp)
        ) {
            Text(
                text = "Submit",
                fontSize = 20.sp
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun PasswordScreenPreview() {
    com.ecorise.ecorise.PasswordScreen()
}
