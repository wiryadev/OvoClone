package com.wiryadev.ovoclone.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.transform.RoundedCornersTransformation
import com.google.accompanist.coil.rememberCoilPainter
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.wiryadev.ovoclone.data.HappinessDeal
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_HALF
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_X1
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_X16
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_X18
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_X2
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_X3
import com.wiryadev.ovoclone.ui.theme.PepperDark
import com.wiryadev.ovoclone.ui.theme.PepperLighter
import com.wiryadev.ovoclone.ui.theme.SeaSalt
import com.wiryadev.ovoclone.ui.theme.TaroLight

val dealsImages = listOf(
    "https://images-loyalty.ovo.id/public/deal/00/80/l/28578.jpg?ver=1",
    "https://images-loyalty.ovo.id/public/deal/57/76/l/27940.jpg?ver=1",
    "https://images-loyalty.ovo.id/public/deal/30/80/l/28585.jpg?ver=1",
    "https://images-loyalty.ovo.id/public/deal/51/79/l/28111.jpg?ver=1",
    "https://images-loyalty.ovo.id/public/deal/84/78/l/28543.jpg?ver=1",
)

@Composable
fun PromoImage(
    imageUrl: String,
    width: Dp,
) {
    Image(
        painter = rememberCoilPainter(
            request = imageUrl,
            requestBuilder = {
                transformations(RoundedCornersTransformation(SPACE_X3.value))
            }
        ),
        contentDescription = "Promotion Image",
        modifier = Modifier
            .size(
                height = SPACE_X16,
                width = width,
            ),
    )
}

@ExperimentalPagerApi
@Composable
fun SpecialPromos(
    itemWidth: Dp,
    pageCount: Int,
) {
    val pagerState = rememberPagerState(pageCount = pageCount)

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
                imageUrl = dealsImages[page],
                width = itemWidth,
            )
        }

        HorizontalPagerIndicator(
            pagerState = pagerState,
            activeColor = SeaSalt,
            inactiveColor = PepperLighter,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(
                    start = SPACE_X2,
                    end = SPACE_X2,
                    top = SPACE_X2,
                )
        )
    }
}

@Composable
fun CashbackImage(
    imageUrl: String,
    width: Dp,
) {
    Image(
        painter = rememberCoilPainter(
            request = imageUrl,
            requestBuilder = {
                transformations(RoundedCornersTransformation(SPACE_X1.value))
            }
        ),
        contentDescription = "Promotion Image",
        modifier = Modifier
            .size(
                height = SPACE_X18,
                width = width,
            ),
    )
}

@Composable
fun DealsCard(
    item: HappinessDeal,
    width: Dp,
) {
    RavierCard(
        modifier = Modifier.width(width = width),
        shape = RoundedCornerShape(SPACE_X1),
    ) {
        Column {
            Image(
                painter = rememberCoilPainter(
                    request = item.banner,
                ),
                contentDescription = "Deals Banner",
                modifier = Modifier
                    .fillMaxWidth(),
                contentScale = ContentScale.FillBounds,
            )
            Column(
                modifier = Modifier.padding(SPACE_X1),
                verticalArrangement = Arrangement.spacedBy(SPACE_HALF)
            ) {
                Text(
                    text = item.title,
                    style = MaterialTheme.typography.h4,
                )
                Text(
                    text = item.provider,
                    style = MaterialTheme.typography.body2,
                )
                Text(
                    text = "Tersedia ${item.available} vouchers",
                    color = PepperDark,
                    style = MaterialTheme.typography.caption,
                )
                Text(
                    text = "Rp${item.price}",
                    color = TaroLight,
                    style = MaterialTheme.typography.h5,
                )
            }
        }
    }
}

@ExperimentalPagerApi
@Preview
@Composable
fun PreviewPromos() {
    SpecialPromos(itemWidth = 300.dp, pageCount = dealsImages.size)
}