package com.wiryadev.ovoclone.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wiryadev.ovoclone.R
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_X1_5
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_X2
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_X5
import com.wiryadev.ovoclone.ui.theme.*

@Composable
fun FinanceBox(
    @DrawableRes icon: Int,
    title: String,
    body: String,
    @DrawableRes sponsorImage: Int,
    sponsorName: String,
) {
    Card {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = SPACE_X2),
            verticalArrangement = Arrangement.spacedBy(SPACE_X1_5),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = SPACE_X2),
                horizontalArrangement = Arrangement.spacedBy(SPACE_X2),
            ) {
                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = title,
                    tint = Purple700,
                )
                Text(
                    text = title,
                    style = TextStyle(
                        color = BlackText,
                        fontFamily = RavierFont,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        lineHeight = 22.sp,
                    ),
                )
            }
            Divider(thickness = 1.dp, color = Gray200)
            Row(
                modifier = Modifier.padding(horizontal = SPACE_X2),
            ) {
                Text(
                    text = body,
                    style = TextStyle(
                        color = BlackText,
                        fontFamily = RavierFont,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal,
                    ),
                    maxLines = 3,
                    modifier = Modifier.padding(start = SPACE_X5),
                )
            }
            Divider(thickness = 1.dp, color = Gray200)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = SPACE_X2),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = "Powered by",
                        style = TextStyle(
                            color = Gray600,
                            fontFamily = RavierFont,
                            fontWeight = FontWeight.Normal,
                            fontSize = 14.sp,
                        )
                    )
                    Spacer(
                        modifier = Modifier.width(Dimens.SPACE_X1)
                    )
                    Image(
                        painter = painterResource(id = sponsorImage),
                        contentDescription = sponsorName,
                    )
                }
                RavierButton(
                    onClick = { },
                    text = "Mulai",
                    height = Dimens.SPACE_X4,
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
            icon = R.drawable.ic_home,
            title = "Invest",
            body = "Beli produk investasi dengan mudah dan aman pake OVO Cash!",
            sponsorImage = R.drawable.ic_bareksa_logo,
            sponsorName = "Bareksa"
        )
    }
}