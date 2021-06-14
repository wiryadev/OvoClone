package com.wiryadev.ovoclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.LayoutDirection
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_X7
import com.wiryadev.ovoclone.ui.home.HomeSection
import com.wiryadev.ovoclone.ui.home.RavierBottomBar
import com.wiryadev.ovoclone.ui.home.RavierNavGraph
import com.wiryadev.ovoclone.ui.theme.OvoCloneTheme

@ExperimentalPagerApi
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val items = remember { HomeSection.values() }
            val navController = rememberNavController()

            OvoCloneTheme {
                Scaffold(
                    bottomBar = {
                        RavierBottomBar(
                            navController = navController,
                            items = items,
                        )
                    },
                ) { paddingValues ->
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
                            bottom = SPACE_X7,
                        ),
                    )
                }
            }
        }
    }
}