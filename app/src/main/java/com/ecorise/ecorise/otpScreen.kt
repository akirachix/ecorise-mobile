package com.ecorise.ecorise

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController

@Composable
fun OtpScreen(
    onSubmit: () -> Unit = {}
) {
    val otpLength = 4
    var otp by remember { mutableStateOf("") }
    var isKeypadVisible by remember { mutableStateOf(false) }
    var countdown by remember { mutableStateOf(59) }
    val maroon = Color(0xFF8B0000)
    LaunchedEffect(countdown) {
        if (countdown > 0) {
            delay(1000)
            countdown--
        }
    }
    val isSubmitEnabled = otp.length == otpLength
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
                .padding(top = 113.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("OTP Verification", fontSize = 38.sp, fontWeight = FontWeight.Bold, color =Color(0xFF8B0000))
            Spacer(modifier = Modifier.height(20.dp))
            Text("Enter the code from the sms we sent to", fontSize = 19.sp)
            Text("+254700000000", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Spacer(modifier = Modifier.height(30.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                repeat(otpLength) { index ->
                    Box(
                        modifier = Modifier
                            .size(60.dp)
                            .border(
                                width = 2.dp,
                                color = Color(0xFFDA6304),
                                shape = RoundedCornerShape(5.dp)
                            )
                            .clickable { isKeypadVisible = true },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = otp.getOrNull(index)?.toString() ?: "",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "Don't receive the OTP? RESEND", fontSize = 23.sp,
                modifier = Modifier.clickable {
                    if (countdown == 0) countdown = 59
                },
                fontWeight = FontWeight.Bold,
                color = if (countdown == 0) Color(0xFF8B0000) else Color(0xFF8B0000).copy(alpha = 0.8f)
            )
            Text("resend code in 00:${countdown.toString().padStart(2, '0')} sec", fontSize = 21.sp)
        }
        val submitButton = @Composable {
            Button(
                onClick = {  },
                enabled = isSubmitEnabled,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 12.dp),

                shape = RoundedCornerShape(5.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF8B0000),
                    disabledContainerColor = Color(0xFF8B0000).copy(alpha = 0.8f)
                )
            ) {
                Text(
                    text = "Submit",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize =  20.sp
                )
            }
        }
        if (!isKeypadVisible) {
            Box(modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 50.dp)) {
                submitButton()
            }
        }
        if (isKeypadVisible) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .background(Color.White)
                    .padding(bottom = 50.dp , top = 16.dp, start = 16.dp, end = 16.dp)
            ) {
                val keypad = listOf(
                    listOf("1", "2", "3"),
                    listOf("4", "5", "6"),
                    listOf("7", "8", "9"),
                    listOf("X", "0", "✓")
                )
                keypad.forEach { row ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        row.forEach { key ->
                            Button(
                                onClick = {
                                    when (key) {
                                        "X" -> if (otp.isNotEmpty()) otp = otp.dropLast(1)
                                        "✓" -> isKeypadVisible = false
                                        else -> if (otp.length < otpLength) otp += key
                                    }
                                },
                                modifier = Modifier
                                    .width(60.dp)
                                    .height(50.dp)
                                    .border(
                                        2.dp,
                                        Color(0xFFDA6304),
                                        RoundedCornerShape(20)
                                    ),
                                shape = RoundedCornerShape(10),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.White
                                ),
                                contentPadding = PaddingValues(0.dp)
                            ) {
                                Text(
                                    text = key,
                                    fontSize = 30.sp,
                                    fontWeight = FontWeight.Black,
                                    color = if (key == "✓")  Color(0xFF8B0000) else Color.Black
                                )
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
                submitButton()
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun OtpScreenPreview() {
    OtpScreen()
}