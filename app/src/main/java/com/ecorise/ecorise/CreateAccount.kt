package com.ecorise.ecorise

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CreateAccountScreen(onCreateAccount: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp, vertical = 0.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(206.dp))
        Image(
            painter = painterResource(id = R.drawable.piles),
            contentDescription = "Recycle Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(Modifier.height(48.dp))
        Text(
            text = "We connect you to recycling company",
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp,
            textAlign = TextAlign.Center,
            color = Color(0xFF800000)
        )
        Spacer(Modifier.height(64.dp))
        Button(
            onClick = onCreateAccount,
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF800000)),
            modifier = Modifier
                .fillMaxWidth(0.7f)
                .height(64.dp)
                .clip(RoundedCornerShape(24.dp)),
            shape = RoundedCornerShape(24.dp)
        ) {
            Text(
                "Create Account",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun SecondScreenPreview() {
    com.ecorise.ecorise.CreateAccountScreen(onCreateAccount = {})
}