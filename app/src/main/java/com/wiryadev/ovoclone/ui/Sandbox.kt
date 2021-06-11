package com.wiryadev.ovoclone.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wiryadev.ovoclone.R
import com.wiryadev.ovoclone.ui.components.Dimens
import com.wiryadev.ovoclone.ui.theme.Gray700
import com.wiryadev.ovoclone.ui.theme.OvoCloneTheme

@Composable
fun IconButtonTest(
    onClick: () -> Unit,
    @DrawableRes image: Int,
    text: String = "Title",
    textColor: Color = Gray700,
    size: Dp = 32.dp,
) {
    Column(
        modifier = Modifier
            .wrapContentSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        IconButton(
            onClick = onClick
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = text,
                modifier = Modifier
                    .size(size),
            )
        }
        Text(
            text = text,
            color = textColor,
            style = TextStyle(
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp,
                lineHeight = 18.sp,
            ),
            textAlign = TextAlign.Center,
        )
    }
}


@Composable
fun ImageButtonTest(
    onClick: () -> Unit,
    @DrawableRes image: Int,
    text: String = "Title",
    textColor: Color = Gray700,
    size: Dp = 32.dp,
) {
    Column(
        modifier = Modifier
            .background(Color.Transparent),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = text,
            modifier = Modifier
                .size(size)
                .background(Color.Transparent)
                .clickable(
                    onClick = onClick
                ),
        )
        Text(
            text = text,
            color = textColor,
            style = TextStyle(
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp,
                lineHeight = 18.sp,
            ),
            modifier = Modifier.size(size + 16.dp),
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
fun BoxButtonTest(
    onClick: () -> Unit,
    @DrawableRes image: Int,
    text: String = "Title",
    textColor: Color = Gray700,
    size: Dp = 32.dp,
) {
    val rippleRadius = 24.dp
    Column(
        modifier = Modifier
            .wrapContentSize()
            .background(Color.Transparent),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            modifier = Modifier
                .clickable(
                    onClick = onClick,
                    enabled = true,
                    role = Role.Button,
                    interactionSource = remember { MutableInteractionSource() },
                    indication = rememberRipple(bounded = false, radius = rippleRadius)
                )
                .size(size)
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = text,
                modifier = Modifier
                    .size(size)
                    .background(Color.Transparent),
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = text,
            color = textColor,
            style = TextStyle(
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp,
                lineHeight = 18.sp,
            ),
            modifier = Modifier.width(size + 16.dp),
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
fun GridCategoriesTest(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = Dimens.SPACE_X2),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceAround,
        ) {
            BoxButtonTest(
                onClick = { },
                image = R.drawable.ic_pln,
                text = "PLN",
                
            )
            BoxButtonTest(
                onClick = { },
                image = R.drawable.ic_pulse,
                text = "Pulsa",
                
            )
            BoxButtonTest(
                onClick = { },
                image = R.drawable.ic_data_plan,
                text = "Paket Data",
                
            )
            BoxButtonTest(
                onClick = { },
                image = R.drawable.ic_invest_new,
                text = "Invest",
                
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceAround,
        ) {
            BoxButtonTest(
                onClick = { },
                image = R.drawable.bpjs_icon_svg,
                text = "BPJS",
                
            )
            BoxButtonTest(
                onClick = { },
                image = R.drawable.internet_icon_svg,
                text = "Internet & TV Kabel",
                
            )
            BoxButtonTest(
                onClick = { },
                image = R.drawable.air_icon_svg,
                text = "Air PDAM",
                
            )
            BoxButtonTest(
                onClick = { },
                image = R.drawable.lainnya_icon_svg,
                text = "Lainnya",
                
            )
        }
    }
}

@Preview
@Composable
fun PreviewSandbox() {
    OvoCloneTheme {
        Column(
            Modifier
                .fillMaxWidth()
                .background(Color.White),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            IconButtonTest(
                onClick = { },
                image = R.drawable.ic_invest,
            )
            ImageButtonTest(
                onClick = { },
                image = R.drawable.ic_invest,
            )
            BoxButtonTest(
                onClick = { /*TODO*/ },
                image = R.drawable.ic_invest,
            )
            Spacer(modifier = Modifier.height(16.dp))
            GridCategoriesTest()
        }
    }
}