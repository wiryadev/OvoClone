package com.wiryadev.ovoclone.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.google.accompanist.coil.rememberCoilPainter
import com.wiryadev.ovoclone.data.HappinessDeal
import com.wiryadev.ovoclone.data.happinessDeals
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_HALF
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_X1
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_X12
import com.wiryadev.ovoclone.ui.theme.OvoCloneTheme
import com.wiryadev.ovoclone.ui.theme.PepperDark
import com.wiryadev.ovoclone.ui.theme.TaroLight

@Composable
private fun DealsCard(
    item: HappinessDeal,
    width: Dp,
) {
    Card(
        modifier = Modifier.width(width = width),
        shape = RoundedCornerShape(SPACE_HALF)
    ) {
        Column {
            Image(
                painter = rememberCoilPainter(
                    request = item.banner,
                ),
                contentDescription = "Deals Banner",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(SPACE_X12),
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

@Preview
@Composable
fun TestBottomNav() {
    OvoCloneTheme {
        Column(
            Modifier.fillMaxSize(),
        ) {
            BoxWithConstraints {
                DealsCard(
                    item = happinessDeals[0],
                    width = this.maxWidth * 0.6f
                )
            }
        }
    }
}