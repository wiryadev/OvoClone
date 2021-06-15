package com.wiryadev.ovoclone.ui.home

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.LocalContentColor
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.google.accompanist.pager.ExperimentalPagerApi
import com.wiryadev.ovoclone.R
import com.wiryadev.ovoclone.ui.components.Dimens
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_X1
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_X10_HALF
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_X7
import com.wiryadev.ovoclone.ui.components.RavierBottomNavigation
import com.wiryadev.ovoclone.ui.components.RavierBottomNavigationItem

enum class HomeSection(
    @StringRes val title: Int,
    @DrawableRes val icon: Int,
    @DrawableRes val iconOnSelected: Int,
    val route: String,
) {
    HOME(
        title = R.string.home,
        icon = R.drawable.ic_nav_home_inactive,
        iconOnSelected = R.drawable.ic_nav_home_active,
        route = "main/home",
    ),
    DEALS(
        title = R.string.deals,
        icon = R.drawable.ic_nav_deals_inactive,
        iconOnSelected = R.drawable.ic_nav_deals_active,
        route = "main/deals",
    ),
    SCAN(
        title = R.string.scan,
        icon = R.drawable.ic_qris,
        iconOnSelected = R.drawable.ic_qris,
        route = "main/scan",
    ),
    FINANCE(
        title = R.string.finance,
        icon = R.drawable.ic_nav_finance_inactive,
        iconOnSelected = R.drawable.ic_nav_finance_active,
        route = "main/finance",
    ),
    PROFILE(
        title = R.string.profile,
        icon = R.drawable.ic_nav_profile_inactive,
        iconOnSelected = R.drawable.ic_nav_profile_active,
        route = "main/profile",
    ),
}

@ExperimentalPagerApi
fun NavGraphBuilder.addHomeGraph() {
    composable(HomeSection.HOME.route) {
        HomeScreen()
    }
    composable(HomeSection.DEALS.route) {
        DealsScreen()
    }
    composable(HomeSection.FINANCE.route) {
        FinanceScreen()
    }
    composable(HomeSection.PROFILE.route) {
        ProfileScreen()
    }
}

@Composable
fun RavierBottomBar(
    navController: NavController,
    items: Array<HomeSection>,
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val sections = remember { HomeSection.values() }
    val routes = remember {
        sections.filter {
            it != HomeSection.SCAN
        }.map {
            it.route
        }
    }

    if (currentRoute in routes) {

        val currentSection = sections.first { it.route == currentRoute }

        RavierBottomNavigation {
            items.forEach { item ->
                val selected = item == currentSection

                RavierBottomNavigationItem(
                    modifier = Modifier
                        .align(Alignment.Bottom)
                        .then(
                            Modifier.height(
                                if (item == HomeSection.SCAN) SPACE_X10_HALF else SPACE_X7
                            )
                        ),
                    selected = selected,
                    icon = {
                        if (item == HomeSection.SCAN) {
                            ScanButton(navController = navController, visible = true)
                        } else {
                            ImageBottomBar(
                                icon = if (selected) item.iconOnSelected else item.icon,
                                description = stringResource(id = item.title)
                            )
                        }
                    },
                    label = {
                        Text(
                            text = stringResource(item.title),
                            color = if (selected) Color(0xFF361DC0) else LocalContentColor.current.copy(
                                alpha = LocalContentAlpha.current
                            ),
                            style = MaterialTheme.typography.caption.copy(
                                fontWeight = if (selected) FontWeight.Bold else FontWeight.Normal,
                            ),
                            maxLines = 1,
                        )
                    },
                    onSelected = {
                        if (item.route != currentRoute) {
                            navController.navigate(item.route) {
                                launchSingleTop = true
                                restoreState = true
                                popUpTo(findStartDestination(navController.graph).id) {
                                    saveState = true
                                }
                            }
                        }
                    }
                )
            }
        }
    }
}

@Composable
fun ImageBottomBar(
    @DrawableRes icon: Int,
    description: String,
) {
    Image(
        painter = painterResource(id = icon),
        contentDescription = description,
    )
}

@Composable
fun ScanButton(
    navController: NavController,
    visible: Boolean,
    modifier: Modifier = Modifier,
) {
    if (visible) {
        Box(
            modifier = modifier
                .clip(CircleShape)
                .background(Color.White)
                .padding(Dimens.SPACE_HALF)
        ) {
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                Color(0xffa056e9),
                                Color(0xff361dc0)
                            )
                        )
                    )
                    .clickable(
                        indication = null,
                        onClick = {
                            navController.navigate(HomeSection.SCAN.route)
                        },
                        role = Role.Button,
                        interactionSource = remember { MutableInteractionSource() },
                    )
                    .padding(SPACE_X1)
                    .align(Alignment.Center),
                contentAlignment = Alignment.Center,
            ) {
                ImageBottomBar(
                    icon = HomeSection.SCAN.icon,
                    description = stringResource(id = HomeSection.SCAN.title)
                )
            }
        }
    }
}

private val NavGraph.startDestination: NavDestination?
    get() = findNode(startDestinationId)

tailrec fun findStartDestination(graph: NavDestination): NavDestination {
    return if (graph is NavGraph) findStartDestination(graph.startDestination!!) else graph
}