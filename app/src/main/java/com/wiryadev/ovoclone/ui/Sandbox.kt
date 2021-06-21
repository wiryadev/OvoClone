package com.wiryadev.ovoclone.ui

import androidx.compose.foundation.background
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
import com.google.accompanist.insets.statusBarsHeight
import com.google.accompanist.insets.statusBarsPadding
import com.wiryadev.ovoclone.R
import com.wiryadev.ovoclone.ui.components.ActionBar
import com.wiryadev.ovoclone.ui.components.Dimens
import com.wiryadev.ovoclone.ui.components.RavierButton
import com.wiryadev.ovoclone.ui.home.*
import com.wiryadev.ovoclone.ui.home.ProfileScreen
import com.wiryadev.ovoclone.ui.theme.OvoCloneTheme
import com.wiryadev.ovoclone.ui.theme.PepperLighter
import com.wiryadev.ovoclone.ui.theme.ShallotDarker
import com.wiryadev.ovoclone.ui.theme.ShallotDarkest
import me.onebone.toolbar.AppBarContainer
import me.onebone.toolbar.CollapsingToolbar
import me.onebone.toolbar.ScrollStrategy
import me.onebone.toolbar.rememberCollapsingToolbarState
import kotlin.math.roundToInt

@Composable
fun TestToolbar() {
// here we use LazyColumn that has build-in nested scroll, but we want to act like a
// parent for this LazyColumn and participate in its nested scroll.
// Let's make a collapsing toolbar for LazyColumn
    val toolbarHeight = 56.dp
    val toolbarHeightPx = with(LocalDensity.current) { toolbarHeight.roundToPx().toFloat() }
// our offset to collapse toolbar
    val toolbarOffsetHeightPx = remember { mutableStateOf(0f) }
// now, let's create connection to the nested scroll system and listen to the scroll
// happening inside child LazyColumn
    val nestedScrollConnection = remember {
        object : NestedScrollConnection {
            override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
                // try to consume before LazyColumn to collapse toolbar if needed, hence pre-scroll
                val delta = available.y
                val newOffset = toolbarOffsetHeightPx.value + delta
                toolbarOffsetHeightPx.value = newOffset.coerceIn(-toolbarHeightPx, 0f)
                // here's the catch: let's pretend we consumed 0 in any case, since we want
                // LazyColumn to scroll anyway for good UX
                // We're basically watching scroll without taking it
                return Offset.Zero
            }
        }
    }
    Box(
        Modifier
            .fillMaxSize()
// attach as a parent to the nested scroll system
            .nestedScroll(nestedScrollConnection)
    ) {
        // our list with build in nested scroll support that will notify us about its scroll

//        LazyColumn(contentPadding = PaddingValues(top = toolbarHeight)) {
//            items(50) { index ->
//                Text(
//                    "I'm item $index", modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(16.dp)
//                )
//            }
//        }
        ProfileScreen(modifier = Modifier.padding(PaddingValues(top = toolbarHeight)))
        TopAppBar(
            modifier = Modifier
                .height(toolbarHeight)
//                .background(Color.Blue)
                .offset { IntOffset(x = 0, y = toolbarOffsetHeightPx.value.roundToInt()) },
            title = { Text("toolbar offset is ${toolbarOffsetHeightPx.value}") }
        )
    }
}

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

@Preview
@Composable
fun TestSandbox() {
    OvoCloneTheme {
        TestCollapsing()
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