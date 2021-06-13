package com.wiryadev.ovoclone.ui.home

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.constraintlayout.compose.ConstraintLayout
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
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_X6
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_X7
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
private fun RavierBottomNavigation(
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color.White,
    contentColor: Color = contentColorFor(backgroundColor),
    elevation: Dp = SPACE_X1,
    content: @Composable RowScope.() -> Unit
) {
    Surface(
        color = backgroundColor,
        contentColor = contentColor,
        elevation = elevation,
        modifier = modifier
    ) {
        Row(
            Modifier
                .zIndex(SPACE_X6.value)
                .fillMaxWidth()
                .height(SPACE_X7)
                .selectableGroup(),
            horizontalArrangement = Arrangement.SpaceBetween,
            content = content
        )
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

        ConstraintLayout(
            modifier = Modifier.fillMaxWidth()
                .background(MaterialTheme.colors.surface.copy(alpha = 0.5f))
        ) {
            val (bottomNavigation, scanButton) = createRefs()

            RavierBottomNavigation(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colors.surface.copy(alpha = 0.5f))
                    .constrainAs(bottomNavigation) {
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                backgroundColor = Color.White,
            ) {
                items.forEach { item ->
                    val selected = item == currentSection

                    BottomNavigationItem(
                        selected = selected,
                        alwaysShowLabel = true,
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
                        onClick = {
                            if (item.route != currentRoute) {
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
            ScanButton(
                modifier = Modifier.constrainAs(scanButton) {
                    top.linkTo(bottomNavigation.top)
                    bottom.linkTo(bottomNavigation.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
            )
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