package com.wiryadev.ovoclone.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wiryadev.ovoclone.R
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_HALF
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_X1
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_X2
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_X5
import com.wiryadev.ovoclone.ui.theme.ShallotDarkest
import com.wiryadev.ovoclone.ui.theme.PepperLighter
import com.wiryadev.ovoclone.ui.theme.PepperDark
import com.wiryadev.ovoclone.ui.theme.OvoCloneTheme

@Composable
fun FinanceBox(
    onClick: () -> Unit,
    @DrawableRes image: Int,
    title: String,
    body: String,
    @DrawableRes sponsorImage: Int,
    sponsorName: String,
) {
    Card(
        shape = RoundedCornerShape(SPACE_HALF),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = SPACE_X2),
            verticalArrangement = Arrangement.spacedBy(SPACE_X2),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = SPACE_X2),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(SPACE_X2),
            ) {
                Image(
                    painter = painterResource(id = image),
                    contentDescription = title,
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(SPACE_X1),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = title,
                        color = ShallotDarkest,
                        style = MaterialTheme.typography.h4
                    )
                    Image(
                        painter = painterResource(id = R.drawable.ic_new_red_big),
                        contentDescription = "Baru",
                    )
                }
            }
            Divider(thickness = 1.dp, color = PepperLighter)
            Row(
                modifier = Modifier.padding(horizontal = SPACE_X2),
            ) {
                Text(
                    text = body,
                    color = ShallotDarkest,
                    style = MaterialTheme.typography.caption,
                    maxLines = 3,
                    modifier = Modifier.padding(start = SPACE_X5),
                )
            }
            Divider(thickness = 1.dp, color = PepperLighter)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = SPACE_X2),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = "Powered by",
                        color = PepperDark,
                        style = MaterialTheme.typography.body2,
                    )
                    Spacer(
                        modifier = Modifier.width(SPACE_X1)
                    )
                    Image(
                        painter = painterResource(id = sponsorImage),
                        contentDescription = sponsorName,
                    )
                }
                RavierButton(
                    onClick = onClick,
                    text = "Mulai",
                    height = Dimens.SPACE_X4,
                    modifier = Modifier.fillMaxWidth(0.8f)
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewFinanceBox() {
    OvoCloneTheme {
        FinanceBox(
            onClick = { },
            image = R.drawable.rico_system_capital,
            title = "Invest",
            body = "Beli produk investasi dengan mudah dan aman pake OVO Cash!",
            sponsorImage = R.drawable.ic_taralite_logo,
            sponsorName = "Bareksa"
        )
    }
}