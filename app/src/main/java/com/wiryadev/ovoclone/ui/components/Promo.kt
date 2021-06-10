package com.wiryadev.ovoclone.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.transform.RoundedCornersTransformation
import com.google.accompanist.coil.rememberCoilPainter
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.wiryadev.ovoclone.ui.theme.Teal500

val dealsImages = listOf(
    "https://images-loyalty.ovo.id/public/deal/51/79/l/28111.jpg?ver=1",
    "https://images-loyalty.ovo.id/public/deal/50/80/l/28593.jpg?ver=1",
    "https://images-loyalty.ovo.id/public/deal/70/80/l/28601.jpg?ver=1",
    "https://images-loyalty.ovo.id/public/deal/39/64/l/28042.jpg?ver=1",
    "https://images-loyalty.ovo.id/public/deal/00/80/l/28578.jpg?ver=1",
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
                transformations(RoundedCornersTransformation(24.dp.value))
            }
        ),
        contentDescription = "Promotion Image",
        modifier = Modifier
            .size(
                height = 128.dp,
                width = width,
            ),
    )
}

@ExperimentalPagerApi
@Composable
fun SpecialPromos(
    itemWidth: Dp,
) {
    val pagerState = rememberPagerState(pageCount = dealsImages.size)

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        HorizontalPager(
            state = pagerState,
            itemSpacing = 16.dp,
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
            activeColor = Teal500,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                    top = 16.dp,
                )
        )
    }
}

@ExperimentalPagerApi
@Preview
@Composable
fun PreviewPromos() {
    SpecialPromos(300.dp)
}