package com.wiryadev.ovoclone.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wiryadev.ovoclone.R
import com.wiryadev.ovoclone.ui.components.Dimens.CARD_SHADOW
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_HALF
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_X1
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_X1_QUARTER
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_X2
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_X4
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_X6
import com.wiryadev.ovoclone.ui.theme.*

private val CategoryGridIconSize = SPACE_X6

@Composable
fun TransactionSection(
    modifier: Modifier = Modifier
) {
    val textColor = Purple600

    Card(
        modifier = modifier
            .fillMaxWidth(),
        shape = Shapes.medium,
        elevation = CARD_SHADOW,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(
                    vertical = SPACE_X1_QUARTER
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround,
        ) {
            CategoryGridItem(
                onClick = { },
                image = R.drawable.rico_action_topup_s,
                text = stringResource(id = R.string.top_up),
                textColor = textColor,
            )
            CategoryGridItem(
                onClick = { },
                image = R.drawable.rico_action_transfer_s,
                text = stringResource(id = R.string.transfer),
                textColor = textColor,
            )
            CategoryGridItem(
                onClick = { },
                image = R.drawable.rico_action_history_s,
                text = stringResource(id = R.string.history),
                textColor = textColor,
            )
        }
    }
}

@Composable
fun CategoryGridItem(
    onClick: () -> Unit,
    @DrawableRes image: Int,
    text: String,
    textColor: Color = Gray700,
    size: Dp = SPACE_X4,
) {
    Column(
        modifier = Modifier
            .background(Color.Transparent)
            .padding(vertical = SPACE_HALF),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            modifier = Modifier
                .clickable(
                    onClick = onClick,
                    enabled = true,
                    role = Role.Button,
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null,
                )
                .size(size)
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = text,
                modifier = Modifier.size(size),
            )
        }
        Spacer(
            modifier = Modifier.height(SPACE_HALF)
        )
        Text(
            text = text,
            color = textColor,
            style = TextStyle(
                fontFamily = RavierFont,
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp,
                lineHeight = 18.sp,
            ),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .width(
                    if (size > SPACE_X4) {
                        size + SPACE_X2
                    } else {
                        Dp.Unspecified
                    }
                ),
        )
    }
}

@Composable
fun FavoriteMenuSection(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = SPACE_X2),
        verticalArrangement = Arrangement.spacedBy(SPACE_X1)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            CategoryGridItem(
                onClick = { },
                image = R.drawable.ic_pln,
                text = "PLN",
                size = CategoryGridIconSize
            )
            CategoryGridItem(
                onClick = { },
                image = R.drawable.ic_pulse,
                text = "Pulsa",
                size = CategoryGridIconSize
            )
            CategoryGridItem(
                onClick = { },
                image = R.drawable.ic_data_plan,
                text = "Paket Data",
                size = CategoryGridIconSize
            )
            CategoryGridItem(
                onClick = { },
                image = R.drawable.ic_invest_new,
                text = "Invest",
                size = CategoryGridIconSize
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            CategoryGridItem(
                onClick = { },
                image = R.drawable.bpjs_icon_svg,
                text = "BPJS",
                size = CategoryGridIconSize
            )
            CategoryGridItem(
                onClick = { },
                image = R.drawable.internet_icon_svg,
                text = "Internet & TV Kabel",
                size = CategoryGridIconSize
            )
            CategoryGridItem(
                onClick = { },
                image = R.drawable.air_icon_svg,
                text = "Air PDAM",
                size = CategoryGridIconSize
            )
            CategoryGridItem(
                onClick = { },
                image = R.drawable.lainnya_icon_svg,
                text = "Lainnya",
                size = CategoryGridIconSize
            )
        }
    }
}

@Composable
fun CategoryItemRow(
    @DrawableRes image: Int,
    text: String,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = SPACE_X1),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = text,
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = text,
                color = Gray700,
                style = TextStyle(
                    fontFamily = RavierFont,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    lineHeight = 18.sp,
                    textAlign = TextAlign.Center,
                ),
                modifier = Modifier.padding(horizontal = 16.dp),
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_arrow),
                contentDescription = stringResource(id = R.string.next)
            )
        }
    }
}

@Preview
@Composable
fun ServicePreview() {
    OvoCloneTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            Box(Modifier.background(Color.White)) {
                CategoryGridItem(
                    onClick = { },
                    image = R.drawable.ic_pln,
                    text = "PLN"
                )
            }
            Box(Modifier.background(Color.White)) {
                CategoryItemRow(image = R.drawable.ic_pln, text = "PLN")
            }
            TransactionSection()
            FavoriteMenuSection()
        }
    }
}