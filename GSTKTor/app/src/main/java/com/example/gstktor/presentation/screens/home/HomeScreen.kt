package com.example.gstktor.presentation.screens.home

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import coil.annotation.ExperimentalCoilApi
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.example.gstktor.navigation.Screen
import com.example.gstktor.presentation.common.ListContent
import com.example.gstktor.ui.theme.statusBarColor

@ExperimentalCoilApi
@Composable
fun HomeScreen(
    navController: NavHostController,
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    val allHeroes = homeViewModel.getAllHeroes.collectAsLazyPagingItems()
    Log.d(TAG,"allheroes = ${homeViewModel.getAllHeroes}")
    val systemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(
        color = MaterialTheme.colors.statusBarColor
    )

    Scaffold(
        topBar = {
            HomeTopBar(onSearchClicked = { navController.navigate(Screen.Search.route) })
        },
        content = { ListContent(heroes = allHeroes, navController = navController) }
    )
}