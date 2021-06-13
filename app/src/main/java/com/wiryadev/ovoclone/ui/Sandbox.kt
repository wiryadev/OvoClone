package com.wiryadev.ovoclone.ui

//import androidx.annotation.DrawableRes
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.interaction.MutableInteractionSource
//import androidx.compose.foundation.layout.*
//import androidx.compose.material.IconButton
//import androidx.compose.material.Surface
//import androidx.compose.material.Text
//import androidx.compose.material.contentColorFor
//import androidx.compose.material.ripple.rememberRipple
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.remember
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.semantics.Role
//import androidx.compose.ui.text.TextStyle
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.Dp
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.compose.ui.zIndex
//import com.wiryadev.ovoclone.R
//import com.wiryadev.ovoclone.ui.components.Dimens
//import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_X1
//import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_X6
//import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_X7
//import com.wiryadev.ovoclone.ui.theme.Gray700
//import com.wiryadev.ovoclone.ui.theme.OvoCloneTheme
//
//@Composable
//private fun RavierBottomNavigation(
//    modifier: Modifier = Modifier,
//    backgroundColor: Color = Color.White,
//    contentColor: Color = contentColorFor(backgroundColor),
//    elevation: Dp = SPACE_X1,
//    content: @Composable RowScope.() -> Unit
//) {
//    Surface(
//        color = backgroundColor,
//        contentColor = contentColor,
//        elevation = elevation,
//        modifier = modifier
//    ) {
//        Row(
//            Modifier
//                .zIndex(SPACE_X6.value)
//                .fillMaxWidth()
//                .height(SPACE_X7)
//                .selectableGroup(),
//            horizontalArrangement = Arrangement.SpaceBetween,
//            content = content
//        )
//    }
//}
//
//@Composable
//fun RavierBottomBar(
//    navController: NavController,
//    items: Array<HomeSection>,
//) {
//    val navBackStackEntry by navController.currentBackStackEntryAsState()
//    val currentRoute = navBackStackEntry?.destination?.route
//
//    val sections = remember { HomeSection.values() }
//    val routes = remember { sections.map { it.route } }
//
//    if (currentRoute in routes) {
//
//        val currentSection = sections.first { it.route == currentRoute }
//
//        RavierBottomNavigation(
//            modifier = Modifier
//                .fillMaxWidth(),
//            backgroundColor = Color.White,
//            elevation = 0.dp
//        ) {
//            items.forEach { item ->
//                val selected = item == currentSection
//
//                BottomNavigationItem(
//                    selected = selected,
//                    alwaysShowLabel = true,
//                    icon = {
//                        if (item != HomeSection.SCAN) {
//                            ImageBottomBar(
//                                icon = if (selected) item.iconOnSelected else item.icon,
//                                description = stringResource(id = item.title)
//                            )
//                        } else {
//                            Box(
//                                modifier = Modifier
//                                    .background(Color.White)
//                                    .padding(Dimens.SPACE_HALF)
//                            ) {
//                                Box(
//                                    modifier = Modifier
//                                        .clip(CircleShape)
//                                        .background(
//                                            brush = Brush.horizontalGradient(
//                                                colors = listOf(
//                                                    Color(0xffa056e9),
//                                                    Color(0xff361dc0)
//                                                )
//                                            )
//                                        )
//                                        .padding(SPACE_X1)
//                                        .align(Alignment.Center),
//                                    contentAlignment = Alignment.Center,
//                                ) {
//                                    ImageBottomBar(
//                                        icon = item.icon,
//                                        description = stringResource(id = item.title)
//                                    )
//                                }
//                            }
//                        }
//                    },
//                    label = {
//                        Text(
//                            text = stringResource(item.title),
//                            color = if (selected) Color(0xFF361DC0) else LocalContentColor.current.copy(
//                                alpha = LocalContentAlpha.current
//                            ),
//                            style = TextStyle(
//                                fontFamily = RavierFont,
//                                fontWeight = if (selected) FontWeight.Bold else FontWeight.Normal
//                            ),
//                            maxLines = 1,
//                        )
//                    },
//                    onClick = {
//                        if (item.route != currentRoute) {
//                            navController.navigate(item.route) {
//                                launchSingleTop = true
//                                restoreState = true
//                                popUpTo(findStartDestination(navController.graph).id) {
//                                    saveState = true
//                                }
//                            }
//                        }
//                    },
//                    modifier = if (item == HomeSection.SCAN) {
//                        Modifier
//                            .zIndex(SPACE_X6.value)
//                    } else {
//                        Modifier
//                    }
//                )
//            }
//        }
//    }
//}
