package com.wiryadev.ovoclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.LayoutDirection
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.wiryadev.ovoclone.ui.components.Dimens.BottomNavigationHeight
import com.wiryadev.ovoclone.ui.home.HomeSection
import com.wiryadev.ovoclone.ui.home.RavierBottomBar
import com.wiryadev.ovoclone.ui.home.RavierNavGraph
import com.wiryadev.ovoclone.ui.theme.OvoCloneTheme
import com.wiryadev.ovoclone.ui.theme.TaroDark

@ExperimentalPagerApi
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val items = remember { HomeSection.values() }
            val navController = rememberNavController()

            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route

            val routes = remember {
                items.filter {
                    it != HomeSection.SCAN
                }.map {
                    it.route
                }
            }

            // Filter the only routes that need [TaroDark] color for statusBar
            val taroStatusBarRoute = remember {
                routes.filter {
                    it != HomeSection.PROFILE.route
                }.map {
                    it
                }
            }

            // Make statusBar color only set to [TaroDark] when in Home, Deals, and Finance
            // For other screen set statusBar color to white
            val systemUiController = rememberSystemUiController()
            systemUiController.setStatusBarColor(
                color = if (currentRoute in taroStatusBarRoute) TaroDark else Color.White,
                darkIcons = currentRoute !in taroStatusBarRoute,
            )

            OvoCloneTheme {
                Scaffold(
                    bottomBar = {
                        RavierBottomBar(
                            navController = navController,
                            items = items,
                        )
                    },
                ) { paddingValues ->

                    /**
                     * paddingBottom should be set to [BottomNavigationHeight] when showing MainScreen
                     * if use the default paddingValues, it will left additional space
                     * that make transparency of the bottomBar does not work
                     */
                    RavierNavGraph(
                        navController = navController,
                        paddingValues = PaddingValues(
                            start = paddingValues.calculateStartPadding(
                                layoutDirection = LayoutDirection.Ltr
                            ),
                            end = paddingValues.calculateEndPadding(
                                layoutDirection = LayoutDirection.Ltr
                            ),
                            top = paddingValues.calculateTopPadding(),
                            bottom = if (currentRoute in routes) {
                                BottomNavigationHeight
                            } else {
                                paddingValues.calculateBottomPadding()
                            },
                        ),
                    )
                }
            }
        }
    }
}