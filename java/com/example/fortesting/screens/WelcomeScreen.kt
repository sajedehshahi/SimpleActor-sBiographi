package com.example.fortesting.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fortesting.R
import com.example.fortesting.ui.theme.GrayDark
import com.example.fortesting.ui.theme.GrayLight
import kotlinx.coroutines.delay


@Composable
fun WelcomeScreen(
    modifier: Modifier = Modifier,
   navController: NavController
    ) {
    LaunchedEffect(key1 = true) {
        delay(3000)
        navController.navigate("MainScreen") {
            popUpTo("WelcomeScreen") {
                inclusive = true
            }
        }
    }


    Box(
        modifier = modifier
            .fillMaxSize()
            .systemBarsPadding()
            .background(
                Color(0xFF3D3D3D)
            )
    )
    {
        Image(
            painter = painterResource(id = R.drawable.p12), contentDescription = "",
            modifier.fillMaxSize(), contentScale = ContentScale.Crop
            )
        Text(text = "Welcome", modifier.align(Alignment.TopCenter)
            .padding(top = 70.dp)
            , fontWeight = FontWeight.Bold,fontSize = 40.sp
        ,
            fontFamily = FontFamily(Font(R.font.berkshire_swash))
        )
        Text(text = "Actor's Biographies",
            modifier.align(Alignment.TopCenter)
                .padding(top = 110.dp),
            fontFamily = FontFamily(Font(R.font.bonheur_royale)),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF949494)

            )
    }
}

@Composable
@Preview
fun WelcomeScreenPreview() {
    WelcomeScreen(modifier = Modifier, navController = NavController(LocalContext.current))
}

