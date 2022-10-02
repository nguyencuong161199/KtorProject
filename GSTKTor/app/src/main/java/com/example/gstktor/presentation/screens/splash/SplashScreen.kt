package com.example.gstktor.presentation.screens.splash

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.* // ktlint-disable no-wildcard-imports
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.gstktor.R
import com.example.gstktor.navigation.Screen
import com.example.gstktor.ui.theme.splashScreenBackground

@Composable
fun SplashScreen(
    navController: NavHostController,
    splashViewModel: SplashViewModel = hiltViewModel()
) {
    val onBoardingCompleted by splashViewModel.onBoardingCompleted.collectAsState()

    val degrees = remember { Animatable(0f) }

    LaunchedEffect(key1 = true) {
        degrees.animateTo(
            targetValue = 360f,
            animationSpec = tween(
                durationMillis = 1000,
                delayMillis = 200
            )
        )

        navController.popBackStack()
        if (onBoardingCompleted) navController.navigate(Screen.Home.route)
        else navController.navigate(Screen.Welcome.route)
    }

    Splash(degrees = degrees.value)
}

@Composable
fun Splash(degrees: Float) {
    Box(
        modifier = Modifier
            .background(MaterialTheme.colors.splashScreenBackground)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier.rotate(degrees = degrees),
            painter = painterResource(id = R.drawable.gear1),
            contentDescription = stringResource(R.string.app_logo)
        )
    }
}

@Composable
@Preview
fun SplashScreenPreview() {
    Splash(degrees = 0f)
}
