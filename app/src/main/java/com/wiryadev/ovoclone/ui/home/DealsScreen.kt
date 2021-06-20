package com.wiryadev.ovoclone.ui.home

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.statusBarsHeight
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.wiryadev.ovoclone.R
import com.wiryadev.ovoclone.data.happinessDeals
import com.wiryadev.ovoclone.ui.components.*
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_HALF
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_X1
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_X14
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_X1_QUARTER
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_X2
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_X4
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_X5
import com.wiryadev.ovoclone.ui.theme.PepperLighter
import com.wiryadev.ovoclone.ui.theme.Taro
import com.wiryadev.ovoclone.ui.theme.TaroLighter

val cashbackImages = listOf(
    "https://images-loyalty.ovo.id/public/deal/62/80/l/28162.jpg?ver=1",
    "https://images-loyalty.ovo.id/public/deal/12/81/l/28349.jpg?ver=1",
    "https://images-loyalty.ovo.id/public/deal/70/80/l/28601.jpg?ver=1",
    "https://images-loyalty.ovo.id/public/deal/04/80/l/28211.jpg?ver=1",
    "https://images-loyalty.ovo.id/public/deal/51/81/l/28214.jpg?ver=1",
    "https://images-loyalty.ovo.id/public/deal/52/80/l/28364.jpg?ver=1",
    "https://images-loyalty.ovo.id/public/deal/20/81/l/28369.jpg?ver=1",
    "https://images-loyalty.ovo.id/public/deal/02/80/l/28446.jpg?ver=1",
    "https://images-loyalty.ovo.id/public/deal/84/78/l/28543.jpg?ver=1",
    "https://images-loyalty.ovo.id/public/deal/08/79/l/28555.jpg?ver=1",
)

@Composable
fun SearchDeals() {
    Row(
        modifier = Modifier
            .background(Color.White)
            .fillMaxWidth()
            .padding(
                vertical = SPACE_X1,
                horizontal = SPACE_X2,
            ),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        BoxWithConstraints {
            val textFieldWidth = this.maxWidth - (SPACE_X5 + SPACE_X2)
            Box(
                modifier = Modifier
                    .width(textFieldWidth)
                    .height(SPACE_X5)
                    .clip(RoundedCornerShape(SPACE_X1_QUARTER))
                    .background(PepperLighter),
                contentAlignment = Alignment.Center,
                propagateMinConstraints = true,
            ) {
                Text(
                    text = "Cari Merchants",
                    color = Color(0xFFC3C3C3),
                    style = MaterialTheme.typography.body2,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .wrapContentHeight()
                )
            }
        }
        Spacer(modifier = Modifier.width(SPACE_X2))
        Image(
            painter = painterResource(id = R.drawable.ic_my_vouchers),
            contentDescription = "My Vouchers",
            modifier = Modifier.size(SPACE_X5),
        )
    }
}

@Composable
fun ViewDealsNearby() {
    Row(
        modifier = Modifier
            .padding(SPACE_X2)
            .clip(RoundedCornerShape(SPACE_HALF))
            .background(
                brush = Brush.horizontalGradient(
                    listOf(
                        Taro,
                        TaroLighter,
                    )
                )
            )
            .clickable(onClick = {})
            .padding(
                vertical = SPACE_X1,
                horizontal = SPACE_X2,
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        BoxWithConstraints {
            val itemWidth = this.maxWidth - (SPACE_X5)
            Row(
                modifier = Modifier.width(itemWidth),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(SPACE_X1),
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_near_me),
                    contentDescription = "View Deals Nearby",
                )
                Text(
                    text = "1 Langkah menuju deals WAH!",
                    color = Color.White,
                    style = MaterialTheme.typography.h4,
                    maxLines = 2,
                )
            }
        }
        Image(
            painter = painterResource(id = R.drawable.ic_arrow_right),
            contentDescription = "Voew Deals Nearby",
        )
    }
}

@ExperimentalPagerApi
@Composable
fun Cashbacks(
    itemWidth: Dp,
) {
    val pagerState = rememberPagerState(pageCount = cashbackImages.size)

    HorizontalPager(
        state = pagerState,
        itemSpacing = SPACE_X2,
        modifier = Modifier
            .fillMaxWidth(),
    ) { page ->
        // Our page content
        CashbackImage(
            imageUrl = cashbackImages[page],
            width = itemWidth,
        )
    }
}

@ExperimentalPagerApi
@Composable
fun CashbackSection() {
    BaseSurface(
        title = "Cashback Lagi dan Lagi",
        subtitle = "Serbu Berbagai promo terbaru OVO",
        viewAllEnable = true,
        titleTextStyle = MaterialTheme.typography.h4,
        subtitleTextStyle = MaterialTheme.typography.body2,
    ) {
        BoxWithConstraints {
            val itemWidth = this.maxWidth - SPACE_X4
            Cashbacks(
                itemWidth = itemWidth
            )
        }
    }
}

@ExperimentalPagerApi
@Composable
fun HappinessList(
    itemWidth: Dp,
) {
//    val pagerState = rememberPagerState(pageCount = happinessDeals.size)
//    HorizontalPager(
//        state = pagerState,
//        itemSpacing = SPACE_X2,
//        modifier = Modifier
//            .fillMaxWidth(),
//    ) { page ->
//        // Our page content
//        DealsCard(
//            item = happinessDeals[page],
//            width = itemWidth,
//        )
//    }
    LazyRow(
        modifier = Modifier.padding(bottom = SPACE_X1),
        horizontalArrangement = Arrangement.spacedBy(SPACE_X2),
        contentPadding = PaddingValues(horizontal = SPACE_X2),
    ) {
        items(happinessDeals) { deal ->
            DealsCard(item = deal, width = itemWidth)
        }
    }
}

@ExperimentalPagerApi
@Composable
fun HappinessSection() {
    BaseSurface(
        title = "Kolom Kebahagiaan",
        viewAllEnable = true,
        titleTextStyle = MaterialTheme.typography.h4,
    ) {
        BoxWithConstraints {
            val itemWidth = this.maxWidth * 0.75f
            HappinessList(
                itemWidth = itemWidth
            )
        }
    }
}

@ExperimentalPagerApi
@Composable
fun DealsScreen() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(PepperLighter)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(1.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(Modifier.statusBarsHeight(additional = SPACE_X14))
            ViewDealsNearby()
            CashbackSection()
            HappinessSection()
        }
        ActionBar(
            headerContent = {
                Text(
                    text = "Deals",
                    style = MaterialTheme.typography.h4,
                    modifier = Modifier
                        .padding(start = SPACE_X2),
                )
            },
            bodyContent = { SearchDeals() }
        )
    }
}