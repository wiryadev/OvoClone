package com.wiryadev.ovoclone.ui.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavDestination
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
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = MainDestinations.MAIN_ROUTE,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        navigation(
            route = startDestination,
            startDestination = HomeSection.HOME.route,
        ) {
            addHomeGraph(navController)
        }
        composable(
            route = "${MainDestinations.DETAIL_ROUTE}/${HomeSection.SCAN.route}",
        ) {
            ScanScreen()
        }
    }
}