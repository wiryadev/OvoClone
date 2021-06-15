package com.wiryadev.ovoclone.ui.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.google.accompanist.pager.ExperimentalPagerApi

object MainDestinations {
    const val MAIN_ROUTE = "main"
    const val DETAIL_ROUTE = "detail"
    const val ITEM_ID_KEY = "item_id"
}

@ExperimentalPagerApi
@Composable
fun RavierNavGraph(
    paddingValues: PaddingValues,
    navController: NavHostController = rememberNavController(),
    startDestination: String = MainDestinations.MAIN_ROUTE,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = Modifier.fillMaxSize()
            .padding(paddingValues = paddingValues)
    ) {
        navigation(
            route = startDestination,
            startDestination = HomeSection.HOME.route,
        ) {
            addHomeGraph()
        }
        composable(
            route = HomeSection.SCAN.route,
        ) {
            ScanScreen()
        }
    }
}