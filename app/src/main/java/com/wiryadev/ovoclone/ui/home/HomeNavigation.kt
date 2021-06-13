package com.wiryadev.ovoclone.ui.home

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.LocalContentColor
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
import androidx.compose.ui.text.TextStyle
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
import com.wiryadev.ovoclone.ui.components.RavierBottomNavigation
import com.wiryadev.ovoclone.ui.components.RavierBottomNavigationItem
import com.wiryadev.ovoclone.ui.theme.RavierFont

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
        route = "home",
    ),
    DEALS(
        title = R.string.deals,
        icon = R.drawable.ic_nav_deals_inactive,
        iconOnSelected = R.drawable.ic_nav_deals_active,
        route = "deals",
    ),
    SCAN(
        title = R.string.scan,
        icon = R.drawable.ic_qris,
        iconOnSelected = R.drawable.ic_qris,
        route = "scan",
    ),
    FINANCE(
        title = R.string.finance,
        icon = R.drawable.ic_nav_finance_inactive,
        iconOnSelected = R.drawable.ic_nav_finance_active,
        route = "finance",
    ),
    PROFILE(
        title = R.string.profile,
        icon = R.drawable.ic_nav_profile_inactive,
        iconOnSelected = R.drawable.ic_nav_profile_active,
        route = "profile",
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
    composable(HomeSection.SCAN.route) {
        ScanScreen()
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
    val routes = remember { sections.map { it.route } }

    if (currentRoute in routes) {

        val currentSection = sections.first { it.route == currentRoute }

        RavierBottomNavigation(
            modifier = Modifier
                .fillMaxWidth(),
            backgroundColor = Color.White,
        ) {
            items.forEach { item ->
                val selected = item == currentSection

                RavierBottomNavigationItem(
                    selected = selected,
                    icon = {
                        ImageBottomBar(
                            icon = if (selected) item.iconOnSelected else item.icon,
                            description = stringResource(id = item.title)
                        )
                    },
                    label = {
                        Text(
                            text = stringResource(item.title),
                            color = if (selected) Color(0xFF361DC0) else LocalContentColor.current.copy(
                                alpha = LocalContentAlpha.current
                            ),
                            style = TextStyle(
                                fontFamily = RavierFont,
                                fontWeight = if (selected) FontWeight.Bold else FontWeight.Normal
                            ),
                            maxLines = 1,
                        )
                    },
                    onSelected = {
                        if (item.route != currentRoute && item != HomeSection.SCAN) {
                            navController.navigate(item.route) {
                                launchSingleTop = true
                                restoreState = true
                                popUpTo(findStartDestination(navController.graph).id) {
                                    saveState = true
                                }
                            }
                        }
                    },
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
    modifier: Modifier = Modifier,
) {
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

private val NavGraph.startDestination: NavDestination?
    get() = findNode(startDestinationId)

private tailrec fun findStartDestination(graph: NavDestination): NavDestination {
    return if (graph is NavGraph) findStartDestination(graph.startDestination!!) else graph
}

//@Preview
//@Composable
//fun PreviewBottomBar() {
//    OvoCloneTheme {
//        val navController = rememberNavController()
//        Scaffold {
//            Column(
//                modifier = Modifier.fillMaxSize()
//            ) {
//                RavierBottomBar(
//                    navController = navController,
//                    items = HomeSection.values(),
//                )
//            }
//        }
//    }
//}