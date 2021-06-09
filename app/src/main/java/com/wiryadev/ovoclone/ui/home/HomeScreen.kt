package com.wiryadev.ovoclone.ui.home

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.wiryadev.ovoclone.R
import com.wiryadev.ovoclone.ui.components.ButtonType
import com.wiryadev.ovoclone.ui.components.GridCategories
import com.wiryadev.ovoclone.ui.components.HighlightedCategories
import com.wiryadev.ovoclone.ui.components.RavierButton
import com.wiryadev.ovoclone.ui.theme.*

@Composable
fun PriceSection(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Text(
            text = "OVO Cash",
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
                text = "OVO Points",
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
fun ExcitingUpdateItem(
    @DrawableRes image: Int,
    title: String,
    subtitle: String,
    actionText: String,
    width: Dp,
) {
    Card(
        modifier = Modifier
            .width(width),
        shape = Shapes.medium,
        elevation = 6.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(260.dp)
                .background(Color.White),
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = title
            )
            Spacer(
                modifier = Modifier.height(8.dp)
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = title,
                    color = BlackText,
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        lineHeight = 24.sp,
                    ),
                )
                Text(
                    text = subtitle,
                    color = BlackText,
                    style = TextStyle(
                        fontWeight = FontWeight.Normal,
                        fontSize = 12.sp,
                        lineHeight = 18.sp,
                    ),
                    maxLines = 3,
                )
                RavierButton(
                    onClick = {  },
                    text = actionText,
                    buttonType = ButtonType.GhostSecondary
                )
            }
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

@Composable
fun ExcitingUpdateSection(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(
                vertical = 32.dp,
                horizontal = 24.dp,
            ),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "Yang Menarik di OVO",
            color = BlackText,
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                lineHeight = 24.sp,
            ),
        )
        Text(
            text = "Jangan ngaku update kalau belum coba fitur ini",
            color = BlackText,
            style = TextStyle(
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp,
                lineHeight = 18.sp,
            ),
        )

        BoxWithConstraints {
            val itemWidth = (this.maxWidth - 16.dp) / 2

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {

                ExcitingUpdateItem(
                    image = R.drawable.help,
                    title = "Pusat Bantuan",
                    subtitle = "Punya kendala atau pertanyaan terkait OVO? kamu bisa kirim di sini",
                    actionText = "Lihat Bantuan",
                    width = itemWidth,
                )
                ExcitingUpdateItem(
                    image = R.drawable.asuransi,
                    title = "Perlindungan COVID-19",
                    subtitle = "Dapatkan Perlindungan COVID-19 Bebas Biaya",
                    actionText = "Daftar Sekarang",
                    width = itemWidth,
                )
            }
        }

    }
}

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Purple150)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        MainSection()
        ExcitingUpdateSection()
    }
}

//@Preview
//@Composable
//fun PreviewPrice() {
//    OvoCloneTheme {
//        Column(
//            modifier = Modifier.fillMaxWidth(),
//            verticalArrangement = Arrangement.spacedBy(16.dp)
//        ) {
//            PriceSection()
//            BoxWithConstraints {
//                ExcitingUpdateItem(
//                    image = R.drawable.help,
//                    title = "Pusat Bantuan",
//                    subtitle = "Punya kendala atau pertanyaan terkait OVO? kamu bisa kirim di sini",
//                    actionText = "Lihat Bantuan",
//                    width = this.maxWidth / 2
//                )
//            }
//            ExcitingUpdateSection()
//        }
//    }
//}
//
//@Preview
//@Composable
//fun PreviewMainSection() {
//    OvoCloneTheme {
//        MainSection()
//    }
//}

@Preview
@Composable
fun PreviewHome() {
    HomeScreen()
}