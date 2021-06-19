package com.wiryadev.ovoclone.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import com.google.accompanist.insets.statusBarsHeight
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.wiryadev.ovoclone.R
import com.wiryadev.ovoclone.ui.components.ActionBar
import com.wiryadev.ovoclone.ui.components.BaseSurface
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_X1
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_X10_HALF
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_X1_HALF
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_X2
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_X4
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_X5
import com.wiryadev.ovoclone.ui.components.PromoImage
import com.wiryadev.ovoclone.ui.theme.Gray200

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

@ExperimentalPagerApi
@Composable
fun Cashbacks(
    itemWidth: Dp,
) {
    val pagerState = rememberPagerState(pageCount = cashbackImages.size)

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        HorizontalPager(
            state = pagerState,
            itemSpacing = SPACE_X2,
            modifier = Modifier
                .fillMaxWidth(),
        ) { page ->
            // Our page content
            PromoImage(
                imageUrl = cashbackImages[page],
                width = itemWidth,
            )
        }
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

@Composable
fun SearchDeals() {
    Row(
        modifier = Modifier
            .background(Color.White)
            .fillMaxWidth()
            .padding(horizontal = SPACE_X2, vertical = SPACE_X1),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .height(SPACE_X5)
                .clip(RoundedCornerShape(SPACE_X1_HALF))
                .background(Gray200),
            contentAlignment = Alignment.Center,
            propagateMinConstraints = true,
        ) {
            Text(
                text = "Cari Merchants",
                color = Color(0xFFC3C3C3),
                style = MaterialTheme.typography.body2,
                textAlign = TextAlign.Center,
                modifier = Modifier.wrapContentHeight()
            )
        }
        Image(
            painter = painterResource(id = R.drawable.ic_my_vouchers),
            contentDescription = "My Vouchers",
        )
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
                .background(Gray200)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(SPACE_X1),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(Modifier.statusBarsHeight(additional = SPACE_X10_HALF))
            CashbackSection()
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