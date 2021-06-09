package com.wiryadev.ovoclone.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.wiryadev.ovoclone.R
import com.wiryadev.ovoclone.ui.components.GridCategories
import com.wiryadev.ovoclone.ui.components.HighlightedCategories
import com.wiryadev.ovoclone.ui.theme.Orange500
import com.wiryadev.ovoclone.ui.theme.OvoCloneTheme
import com.wiryadev.ovoclone.ui.theme.Purple100
import com.wiryadev.ovoclone.ui.theme.Purple150

@Composable
fun PriceSection(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Text(
            text = "Ovo Cash",
            color = Purple150,
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                lineHeight = 22.sp,
            ),
        )
        Row {
            Text(
                text = "Rp",
                color = Color.White,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    lineHeight = 22.sp,
                ),
            )
            Text(
                text = "100.000",
                color = Color.White,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 32.sp,
                    lineHeight = 22.sp,
                ),
            )
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = "Ovo Points",
                color = Purple150,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    lineHeight = 22.sp,
                ),
            )
            Text(
                text = "219.846",
                color = Orange500,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    lineHeight = 22.sp,
                ),
            )
        }
    }
}

@Composable
fun MainSection() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(Color.White)
    ) {
        val (
            backgroundImage,
            priceSection,
            highlightedCategories,
            gridCategories
        ) = createRefs()

        Image(
            painter = painterResource(id = R.drawable.bg),
            contentDescription = "Background Image",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .constrainAs(backgroundImage) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)

                    width = Dimension.fillToConstraints
                },
        )
        PriceSection(
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .constrainAs(priceSection) {
                    top.linkTo(parent.top)
                    bottom.linkTo(highlightedCategories.top)
                    start.linkTo(parent.start)
                }
        )
        HighlightedCategories(
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .constrainAs(highlightedCategories) {
                    top.linkTo(backgroundImage.bottom)
                    bottom.linkTo(backgroundImage.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )
        GridCategories(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .constrainAs(gridCategories) {
                    top.linkTo(highlightedCategories.bottom, 16.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )
    }
}

@Preview
@Composable
fun PreviewPrice() {
    OvoCloneTheme {
        PriceSection()
    }
}

@Preview
@Composable
fun PreviewMainSection() {
    OvoCloneTheme {
        MainSection()
    }
}