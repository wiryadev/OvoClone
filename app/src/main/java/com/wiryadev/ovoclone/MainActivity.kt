package com.wiryadev.ovoclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FabPosition
import androidx.compose.material.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.wiryadev.ovoclone.ui.home.*
import com.wiryadev.ovoclone.ui.theme.OvoCloneTheme

@ExperimentalPagerApi
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val items = remember { HomeSection.values() }
            val navController = rememberNavController()
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route

            OvoCloneTheme {
                Scaffold(
                    bottomBar = {
                        RavierBottomBar(
                            navController = navController,
                            items = items,
                        )
                    },
                    floatingActionButton = {
                        ScanButton(
                            navController = navController,
                            visible = currentRoute != "${MainDestinations.DETAIL_ROUTE}/${HomeSection.SCAN.route}"
                        )
                    },
                    floatingActionButtonPosition = FabPosition.Center,
                    isFloatingActionButtonDocked = true,
                ) { paddingValues ->
                    RavierNavGraph(
                        navController = navController,
                        modifier = Modifier.padding(paddingValues),
                    )
                }
            }
        }
    }
}