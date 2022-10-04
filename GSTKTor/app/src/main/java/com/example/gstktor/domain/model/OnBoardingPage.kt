package com.example.gstktor.domain.model

import androidx.annotation.DrawableRes
import com.example.gstktor.R

sealed class OnBoardingPage(
    @DrawableRes val image: Int,
    val title: String,
    val description: String
) {
    object First : OnBoardingPage(
        image = R.drawable.logo,
        title = "Greetings",
        description = "Welcome to GWM World"
    )

    object Second : OnBoardingPage(
        image = R.drawable.loupe,
        title = "Explore",
        description = "Amazing complex of entertainment"
    )

    object Third : OnBoardingPage(
        image = R.drawable.play,
        title = "Power",
        description = "Let's gaming with meee right away"
    )
}
