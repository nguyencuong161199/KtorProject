package com.example.gstktor.domain.model

import androidx.annotation.DrawableRes
import com.example.gstktor.R

sealed class OnBoardingPage(
    @DrawableRes val image: Int,
    val title: String,
    val description: String
) {
    object First : OnBoardingPage(
        image = R.drawable.greetings,
        title = "Greetings",
        description = "Chào mừng bạn đến với thế giới của GWM-CORP"
    )

    object Second : OnBoardingPage(
        image = R.drawable.search,
        title = "Explore",
        description = "Tìm cho mình một con tướng tủ và đem lên đấu trường thôi 😁"
    )

    object Third : OnBoardingPage(
        image = R.drawable.power,
        title = "Let's play",
        description = "Và đừng quên =))) \n Gaming With Meee \n 🎮"
    )
}
