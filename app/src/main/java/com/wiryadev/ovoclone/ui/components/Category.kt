package com.wiryadev.ovoclone.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wiryadev.ovoclone.R
import com.wiryadev.ovoclone.ui.theme.Gray700
import com.wiryadev.ovoclone.ui.theme.OvoCloneTheme
import com.wiryadev.ovoclone.ui.theme.Shapes

private val CategoryGridIconSize = 48.dp

@Composable
fun HighlightedCategories(
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth(),
        shape = Shapes.medium,
        elevation = 6.dp,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(vertical = 4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround,
        ) {
            CategoryGridItem(
                onClick = { },
                image = R.drawable.ic_topup_transparent,
                text = stringResource(id = R.string.top_up)
            )
            CategoryGridItem(
                onClick = { },
                image = R.drawable.ic_transfer,
                text = stringResource(id = R.string.transfer)
            )
            CategoryGridItem(
                onClick = { },
                image = R.drawable.ic_history,
                text = stringResource(id = R.string.history)
            )
        }
    }
}

@Composable
fun CategoryGridItem(
    onClick: () -> Unit,
    @DrawableRes image: Int,
    text: String,
    size: Dp = 32.dp,
) {
    Column(
        modifier = Modifier
            .background(Color.Transparent)
            .padding(vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        IconButton(
            onClick = onClick
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = text,
                modifier = Modifier.size(size),
            )
        }
        Text(
            text = text,
            color = Gray700,
            style = TextStyle(
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp,
                lineHeight = 18.sp,
            ),
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .width(
                    if (size > 32.dp) {
                        size + 12.dp
                    } else {
                        Dp.Unspecified
                    }
                ),
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
fun GridCategories(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceAround,
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
            horizontalArrangement = Arrangement.SpaceAround,
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
            .padding(vertical = 8.dp),
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
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    lineHeight = 18.sp,
                ),
                modifier = Modifier.padding(horizontal = 16.dp),
                textAlign = TextAlign.Center,
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
                .background(MaterialTheme.colors.background)
                .padding(16.dp),
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
            HighlightedCategories()
            GridCategories()
        }
    }
}