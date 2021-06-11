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
import com.google.accompanist.pager.ExperimentalPagerApi
import com.wiryadev.ovoclone.R
import com.wiryadev.ovoclone.ui.components.*
import com.wiryadev.ovoclone.ui.components.Dimens.CARD_SHADOW
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_X1
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_X2
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_X3
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_X4
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
                fontFamily = RavierFont,
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                lineHeight = 18.sp,
            ),
        )
        Row {
            Text(
                text = "Rp",
                color = Color.White,
                style = TextStyle(
                    fontFamily = RavierFont,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    lineHeight = 22.sp,
                ),
            )
            Text(
                text = "1.300",
                color = Color.White,
                style = TextStyle(
                    fontFamily = RavierFont,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
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
                    fontFamily = RavierFont,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    lineHeight = 18.sp,
                ),
            )
            Text(
                text = "219.846",
                color = Orange500,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    lineHeight = 18.sp,
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
        elevation = CARD_SHADOW,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp)
                .background(Color.White)
                .padding(bottom = 8.dp),
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
                    .fillMaxSize()
                    .padding(horizontal = SPACE_X1),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(SPACE_X1)
                ) {
                    Text(
                        text = title,
                        color = BlackText,
                        style = TextStyle(
                            fontFamily = RavierFont,
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                            lineHeight = 22.sp,
                        ),
                        modifier = Modifier.fillMaxWidth(),
                    )
                    Text(
                        text = subtitle,
                        color = BlackText,
                        style = TextStyle(
                            fontFamily = RavierFont,
                            fontWeight = FontWeight.Normal,
                            fontSize = 12.sp,
                            lineHeight = 18.sp,
                        ),
                        maxLines = 3,
                    )
                }
                RavierButton(
                    onClick = { },
                    text = actionText,
                    buttonType = ButtonType.GhostSecondary,
                    height = 32.dp,
                )
            }
        }
    }
}

private val IMAGE_HEIGHT = 84.dp

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
                painter = painterResource(
                    id = R.drawable.rima_header_top_eid
                ),
                contentDescription = "Background Image",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(IMAGE_HEIGHT),
            )
            Image(
                painter = painterResource(
                    id = R.drawable.rima_header_bottom_eid
                ),
                contentDescription = "Background Image",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(IMAGE_HEIGHT),
            )
        }
        PriceSection(
            modifier = Modifier
                .padding(horizontal = SPACE_X2)
                .constrainAs(priceSection) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }
        )
        HighlightedCategories(
            modifier = Modifier
                .padding(horizontal = SPACE_X2)
                .constrainAs(highlightedCategories) {
                    top.linkTo(priceSection.bottom, SPACE_X3)
                    bottom.linkTo(backgroundImage.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )
        GridCategories(
            modifier = Modifier
                .padding(horizontal = SPACE_X2)
                .constrainAs(gridCategories) {
                    top.linkTo(highlightedCategories.bottom, SPACE_X1)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )
    }
}


@Composable
fun ExcitingUpdateSection() {
    BaseSurface(
        title = "Yang Menarik di OVO",
        subtitle = "Jangan ngaku update kalau belum coba fitur ini",
        verticalPadding = SPACE_X3,
    ) {
        BoxWithConstraints {
            val itemWidth = (this.maxWidth - SPACE_X2) / 2

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {

                ExcitingUpdateItem(
                    image = R.drawable.help,
                    title = "Pusat Bantuan",
                    subtitle = "Punya kendala atau pertanyaan terkait OVO? Kamu bisa kirim di sini",
                    actionText = "Lihat Bantuan",
                    width = itemWidth,
                )
                ExcitingUpdateItem(
                    image = R.drawable.edukasi_investasi,
                    title = "Edukasi Investasi",
                    subtitle = "Tips Keuangan Cegah Quarter-Life Crisis",
                    actionText = "Cari tahu!",
                    width = itemWidth,
                )
            }
        }
    }
}

@ExperimentalPagerApi
@Composable
fun SpecialPromoSection() {
    BaseSurface(
        title = "Info dan Promo Spesial",
        viewAllEnable = true,
        contentHorizontalPadding = 0.dp,
    ) {
        BoxWithConstraints {
            SpecialPromos(
                itemWidth = this.maxWidth - SPACE_X4
            )
        }
    }
}

@Composable
fun YourFinancialSection() {
    BaseSurface(
        title = "Finansial Kamu",
    ) {
        Card(
            shape = Shapes.medium,
            elevation = CARD_SHADOW,
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = SPACE_X2),
                verticalArrangement = Arrangement.spacedBy(SPACE_X2),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Row(
                        modifier = Modifier
                            .wrapContentWidth()
                            .height(IntrinsicSize.Min)
                            .background(Color.White),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.logo_ovo_purple),
                            contentDescription = "Logo Ovo",
                        )
                        Divider(
                            color = Purple600,
                            modifier = Modifier
                                .padding(horizontal = SPACE_X1)
                                .fillMaxHeight()
                                .width(1.dp)

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
                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )
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
                        Spacer(
                            modifier = Modifier.width(SPACE_X1)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.ic_bareksa_logo),
                            contentDescription = "Bareksa Logo",
                        )
                    }
                }
                Divider(thickness = 1.dp, color = Gray200)
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
                        onClick = { },
                        text = "Mulai",
                        height = SPACE_X4,
                    )
                }
            }
        }
    }
}

@ExperimentalPagerApi
@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Gray200)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(Modifier.statusBarsHeight(additional = 48.dp))
            MainSection()
            SpecialPromoSection()
            YourFinancialSection()
            ExcitingUpdateSection()
        }
        ActionBar()
    }
}

@ExperimentalPagerApi
@Preview
@Composable
fun PreviewHome() {
    OvoCloneTheme {
        HomeScreen()
    }
}