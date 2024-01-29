package com.example.businesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardApp()
        }
    }
}

@Composable
fun BusinessCardApp() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFD2E8D4)),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        PersonalInfo(
            fullName = stringResource(id = R.string.full_name_text),
            title = stringResource(id = R.string.title_text)

        )


        ContactInfo(
            phoneNumber = stringResource(id = R.string.phone_number_text),
            userName = stringResource(id = R.string.user_name_text),
            emailAddress = stringResource(id = R.string.email_address_text)
        )

    }

}


@Composable
fun PersonalInfo(fullName: String, title: String) {
    val image = painterResource(id = R.drawable.android_logo_2)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = image,
            contentDescription = null,
            Modifier
                .background(Color.Black)
                .size(130.dp)
        )
        Text(text = fullName, fontSize = 45.sp)
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            fontSize = 17.sp,
            color = Color(0xFF348659)
        )
    }

}

@Composable
fun ContactInfo(phoneNumber: String, userName: String, emailAddress: String) {
    Column(horizontalAlignment = Alignment.Start) {
        Row {
            Icon(imageVector = Icons.Default.Phone, contentDescription = null)
            Spacer(modifier = Modifier.width(20.dp))
            Text(text = phoneNumber)
        }
        Row {
            Icon(imageVector = Icons.Default.AccountBox, contentDescription = null)
            Spacer(modifier = Modifier.width(20.dp))
            Text(text = userName)
        }
        Row {
            Icon(imageVector = Icons.Default.Email, contentDescription = null)
            Spacer(modifier = Modifier.width(20.dp))
            Text(text = emailAddress)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardApp()

}