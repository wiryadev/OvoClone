package com.wiryadev.ovoclone.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.wiryadev.ovoclone.R
import com.wiryadev.ovoclone.ui.components.*
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_HALF
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_X1
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_X2
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_X3
import com.wiryadev.ovoclone.ui.home.*
import com.wiryadev.ovoclone.ui.theme.*
import me.onebone.toolbar.*
import me.onebone.toolbar.AppBarContainer
import me.onebone.toolbar.CollapsingToolbarScopeInstance.pin
import me.onebone.toolbar.CollapsingToolbarScopeInstance.road

@Composable
fun TransactionSectionSoft(
    modifier: Modifier = Modifier
) {
    val shape = Shapes.medium
    val textColor = TaroDark

    RavierCard(
        modifier = modifier,
    ) {
        Row(
            modifier = Modifier
                .zIndex(SPACE_HALF.value)
                .fillMaxWidth()
                .clip(shape)
                .background(Color.White)
                .padding(
                    vertical = Dimens.SPACE_X1_QUARTER
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround,
        ) {
            transactionCategories.forEach { category ->
                CategoryGridItem(
                    onClick = { },
                    image = category.icon,
                    text = category.title,
                    textColor = textColor,
                )
            }
        }
    }
}

@Composable
private fun TestCollapsing() {
    val state = rememberCollapsingToolbarScaffoldState()
    val progress = state.toolbarState.progress
    val textSize = (16 + 8 * progress).sp

    CollapsingToolbarScaffold(
        modifier = Modifier
            .fillMaxSize(),
        scrollStrategy = ScrollStrategy.ExitUntilCollapsed,
        state = state,
        toolbar = {
            Box(
                modifier = Modifier
                    .background(MaterialTheme.colors.surface)
                    .fillMaxWidth()
                    .height(104.dp)
                    .pin(),
            )

            Text(
                text = "Profile",
                modifier = Modifier
                    .padding(
                        vertical = if (progress > 0f) SPACE_X1 else SPACE_X3,
                        horizontal = SPACE_X2,
                    )
                    .road(
                        whenCollapsed = Alignment.CenterStart,
                        whenExpanded = Alignment.BottomStart,
                    ),
                color = ShallotDarkest,
                style = MaterialTheme.typography.h4,
                fontSize = textSize,
            )
            IconButton(
                onClick = { },
                modifier = Modifier
                    .road(
                        whenCollapsed = Alignment.TopEnd,
                        whenExpanded = Alignment.TopEnd,
                    ),
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_notification_light_normal),
                    contentDescription = "Notification",
                    tint = ShallotDark,
                )
            }
        }
    ) {

        ProfileScreenTest()

//        LazyColumn {
//            items(50) { index ->
//                Text(
//                    "I'm item $index", modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(16.dp)
//                )
//            }
//        }
    }
}

@Preview
@Composable
fun TestSandbox() {
    OvoCloneTheme {

        val sysUiController = rememberSystemUiController()

        SideEffect {
            sysUiController.setStatusBarColor(Color.White)
        }

        ProvideWindowInsets {
            TestCollapsing()
        }
    }
}

@Composable
private fun ProfileScreenTest(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(PepperLighter)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(Dimens.SPACE_X1),
    ) {
//            Spacer(Modifier.statusBarsHeight(additional = Dimens.SPACE_X6))
        OverviewSection()
        OvoIdSection()
        AccountSection()
        SecuritySection()
        AboutSection()
        FooterRow("3.37.0 (330)")
        RavierButton(
            onClick = { },
            text = "Sign Out",
            modifier = Modifier
                .padding(Dimens.SPACE_X2)
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(Dimens.SPACE_X2))
    }
}