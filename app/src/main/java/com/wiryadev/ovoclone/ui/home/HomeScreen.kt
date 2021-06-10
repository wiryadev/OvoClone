package com.wiryadev.ovoclone.ui.home

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.google.accompanist.insets.statusBarsHeight
import com.wiryadev.ovoclone.R
import com.wiryadev.ovoclone.ui.components.*
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
                text = "1.300",
                color = Color.White,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp,
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
                contentDescription = title,
                modifier = Modifier.height(96.dp),
                contentScale = ContentScale.FillBounds,
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
                    onClick = { },
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

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(backgroundImage) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)

                    width = Dimension.fillToConstraints
                }
        ) {
            Image(
                painter = painterResource(id = R.drawable.rima_header_top_eid),
                contentDescription = "Background Image",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier.fillMaxWidth(),
            )
            Image(
                painter = painterResource(id = R.drawable.rima_header_bottom_eid),
                contentDescription = "Background Image",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier.fillMaxWidth(),
            )
        }
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
fun BaseHomeSurface(
    title: String,
    subtitle: String? = null,
    viewAllEnable: Boolean = false,
    verticalPadding: Dp = 24.dp,
    content: @Composable () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(
                vertical = verticalPadding,
                horizontal = 24.dp,
            ),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
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
            if (viewAllEnable) {
                RavierButton(
                    onClick = { },
                    text = "View All",
                    buttonType = ButtonType.GhostSecondary
                )
            }
        }
        if (subtitle != null) {
            Text(
                text = subtitle,
                color = BlackText,
                style = TextStyle(
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp,
                    lineHeight = 18.sp,
                ),
            )
        }
        content()
    }
}

@Composable
fun ExcitingUpdateSection() {
    BaseHomeSurface(
        title = "Yang Menarik di OVO",
        subtitle = "Jangan ngaku update kalau belum coba fitur ini",
        verticalPadding = 32.dp,
    ) {
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
fun YourFinancial() {
    BaseHomeSurface(
        title = "Finansial Kamu",
    ) {
        Card(
            elevation = 6.dp
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Row(
                        modifier = Modifier.wrapContentWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.logo_ovo_purple),
                            contentDescription = "Logo Ovo",
                        )
                        Text(
                            text = "|",
                            style = TextStyle(
                                color = Purple600,
                                fontFamily = RavierFont,
                                fontWeight = FontWeight.Normal,
                                fontSize = 30.sp,
                            ),
                            modifier = Modifier.padding(horizontal = 8.dp)
                        )
                        Text(
                            text = "Invest",
                            style = TextStyle(
                                color = Purple600,
                                fontFamily = RavierFont,
                                fontWeight = FontWeight.Bold,
                                fontSize = 24.sp,
                            )
                        )
                    }
                    Row(
                        modifier = Modifier.wrapContentWidth(),
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
                        Spacer(modifier = Modifier.width(8.dp))
                        Image(
                            painter = painterResource(id = R.drawable.ic_bareksa_logo),
                            contentDescription = "Bareksa Logo",
                        )
                    }
                }
                Divider(thickness = 1.dp, color = Gray600)
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(
                        text = "Saatnya kamu mulai investasi dengan yang aman dan pasti",
                        style = TextStyle(
                            color = Gray600,
                            fontFamily = RavierFont,
                            fontWeight = FontWeight.Normal,
                            fontSize = 12.sp,
                        ),
                        modifier = Modifier.fillMaxWidth(0.6f),
                    )
                    RavierButton(
                        onClick = {  },
                        text = "Mulai",
                        height = 32.dp,
                    )
                }
            }
        }
    }
}

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Purple100)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(Modifier.statusBarsHeight(additional = 42.dp))
            MainSection()
            YourFinancial()
            ExcitingUpdateSection()
        }
        ActionBar()
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
//    val systemUiController = rememberSystemUiController()
//    SideEffect {
//        systemUiController.setStatusBarColor(Purple600)
//    }

    OvoCloneTheme {
//        ProvideWindowInsets {
        HomeScreen()
//        }
    }
}