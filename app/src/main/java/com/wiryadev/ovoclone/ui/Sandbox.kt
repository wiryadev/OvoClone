package com.wiryadev.ovoclone.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.google.accompanist.insets.statusBarsHeight
import com.google.accompanist.insets.statusBarsPadding
import com.wiryadev.ovoclone.R
import com.wiryadev.ovoclone.ui.components.*
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_HALF
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_X2
import com.wiryadev.ovoclone.ui.home.*
import com.wiryadev.ovoclone.ui.home.ProfileScreen
import com.wiryadev.ovoclone.ui.theme.*
import me.onebone.toolbar.AppBarContainer
import me.onebone.toolbar.CollapsingToolbar
import me.onebone.toolbar.ScrollStrategy
import me.onebone.toolbar.rememberCollapsingToolbarState
import kotlin.math.roundToInt

@Composable
private fun TestCollapsing() {
    val state = rememberCollapsingToolbarState()
    val textSize = (18 + (30 - 18) * state.progress).sp

    AppBarContainer(
        scrollStrategy = ScrollStrategy.ExitUntilCollapsed,
        collapsingToolbarState = state,
    ) {
        CollapsingToolbar(collapsingToolbarState = state) {
//            Row(
//                modifier = Modifier.fillMaxSize(),
//                verticalAlignment = Alignment.CenterVertically,
//                horizontalArrangement = Arrangement.SpaceBetween,
//            ) {
//                Text(
//                    text = "Profile",
//                    color = ShallotDarkest,
//                    style = MaterialTheme.typography.h4,
//                    fontSize = textSize,
//                    modifier = Modifier
//                        .padding(start = Dimens.SPACE_X2),
//                )
//                IconButton(
//                    onClick = {  },
//                    modifier = Modifier.align(Alignment.CenterVertically)
//                ) {
//                    Icon(
//                        painter = painterResource(id = R.drawable.ic_notification_dark_normal),
//                        contentDescription = "Notification",
//                    )
//                }
//            }
            Box(
                modifier = Modifier
                    .background(MaterialTheme.colors.primary)
                    .fillMaxWidth()
                    .height(150.dp)
                    .pin()
            )

            Text(
                text = "Title",
                modifier = Modifier
                    .road(Alignment.CenterStart, Alignment.BottomEnd)
                    .padding(60.dp, 16.dp, 16.dp, 16.dp),
                color = Color.White,
                fontSize = textSize
            )
        }

//        ProfileScreenTest(modifier = Modifier.appBarBody())

        LazyColumn(modifier = Modifier.appBarBody()) {
            items(50) { index ->
                Text(
                    "I'm item $index", modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
            }
        }
    }
}

//@Preview
//@Composable
//fun TestSandbox() {
//    OvoCloneTheme {
//        TestCollapsing()
//    }
//}

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