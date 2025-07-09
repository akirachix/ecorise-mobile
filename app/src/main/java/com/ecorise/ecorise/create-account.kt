package com.ecorise.ecorise

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CreateAccountScreen() {
    var username by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp).padding(bottom = 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Create Account",
            fontWeight = FontWeight.Bold,
            color = Color(0xFf942222),
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 56.dp, top = 20.dp)
        )
        Column (
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Username",
                fontSize = 17.sp,
            )
            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                label = { Text("") },
                leadingIcon = { Icon(Icons.Default.Person, contentDescription = null) },
                modifier = Modifier.fillMaxWidth().padding(bottom = 15.dp)
            )
        }
        Column (
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Phone number",
                fontSize = 17.sp,
            )
            OutlinedTextField(
                value = phoneNumber,
                onValueChange = { input ->
                    phoneNumber = input.filter { it.isDigit() }
                },
                label = { Text("") },
                leadingIcon = { Icon(Icons.Default.Phone, contentDescription = null) },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number
                ),
                modifier = Modifier.fillMaxWidth().padding(bottom = 15.dp)
            )
        }
            Column (
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Email",
                    fontSize = 17.sp,
                )
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("") },
                    leadingIcon = { Icon(Icons.Default.Email, contentDescription = null) },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Email
                    ),
                    modifier = Modifier.fillMaxWidth().padding(bottom = 15.dp)
                )
            }
                Column (
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Password",
                        fontSize = 17.sp,
                    )
                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        label = { Text("") },
                        leadingIcon = { Icon(Icons.Default.Lock, contentDescription = null) },
                        modifier = Modifier.fillMaxWidth().padding(bottom = 15.dp),
                        visualTransformation = PasswordVisualTransformation()
                    )
                }
                    Column (
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "Confirm Password",
                            fontSize = 17.sp,
                        )
                        OutlinedTextField(
                            value = confirmPassword,
                            onValueChange = { confirmPassword = it },
                            label = { Text("") },
                            leadingIcon = { Icon(Icons.Default.Lock, contentDescription = null) },
                            modifier = Modifier.fillMaxWidth().padding(bottom = 15.dp),
                            visualTransformation = PasswordVisualTransformation()
                        )
                    }
        Button(
            onClick = {  },
            modifier = Modifier
                .fillMaxWidth()
                .height(72.dp)
                .padding(top = 16.dp),
            shape = RoundedCornerShape(5.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF800020))
        ) {
            Text(text = "Submit", color = Color.White)
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Already have an account?")
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = "Login",
                color = Color(0xFF800020),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable { /* Navigate to Login */ }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CreateAccountPreview(){
    CreateAccountScreen()
}
