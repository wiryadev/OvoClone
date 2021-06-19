package com.wiryadev.ovoclone.ui.home

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.google.accompanist.insets.statusBarsHeight
import com.google.accompanist.pager.ExperimentalPagerApi
import com.wiryadev.ovoclone.R
import com.wiryadev.ovoclone.ui.components.*
import com.wiryadev.ovoclone.ui.components.Dimens.CardShadowElevation
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_HALF
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_X1
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_X1_HALF
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_X1_QUARTER
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_X2
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_X2_HALF
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_X3
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_X4
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_X6
import com.wiryadev.ovoclone.ui.theme.*

@Composable
fun BalanceSection(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Text(
            text = "OVO Cash",
            color = Purple150,
            style = MaterialTheme.typography.h6,
        )
        Row {
            Text(
                text = "Rp",
                color = Color.White,
                style = MaterialTheme.typography.h5,
            )
            Text(
                text = "1.300",
                color = Color.White,
                style = MaterialTheme.typography.h2,
            )
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = "OVO Points",
                color = Purple150,
                style = MaterialTheme.typography.h6,
            )
            Text(
                text = "219.846",
                color = Orange500,
                style = MaterialTheme.typography.h6,
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
        elevation = CardShadowElevation,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp)
                .background(Color.White)
                .padding(bottom = SPACE_X1),
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
                        style = MaterialTheme.typography.h5,
                        modifier = Modifier.fillMaxWidth(),
                    )
                    Text(
                        text = subtitle,
                        color = BlackText,
                        style = MaterialTheme.typography.caption,
                        maxLines = 3,
                    )
                }
                RavierButton(
                    onClick = { },
                    text = actionText,
                    buttonType = ButtonType.LinkButton,
                    height = SPACE_X4,
                )
            }
        }
    }
}

private val IMAGE_HEIGHT = 84.dp

@Composable
fun BalanceTransactionSection() {
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
                    id = R.drawable.rima_header_top
                ),
                contentDescription = "Background Image",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(IMAGE_HEIGHT),
            )
            Image(
                painter = painterResource(
                    id = R.drawable.rima_header_bottom
                ),
                contentDescription = "Background Image",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(IMAGE_HEIGHT),
            )
        }
        BalanceSection(
            modifier = Modifier
                .padding(horizontal = SPACE_X2)
                .constrainAs(priceSection) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }
        )
        TransactionSection(
            modifier = Modifier
                .padding(horizontal = SPACE_X2)
                .constrainAs(highlightedCategories) {
                    top.linkTo(priceSection.bottom, SPACE_X3)
                    bottom.linkTo(backgroundImage.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )
        FavoriteMenuSection(
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

@ExperimentalPagerApi
@Composable
fun SpecialPromoSection() {
    BaseSurface(
        title = "Info dan Promo Spesial",
        viewAllEnable = true,
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
            elevation = CardShadowElevation,
            modifier = Modifier
                .padding(horizontal = SPACE_X2)
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
                    Image(
                        painter = painterResource(id = R.drawable.ic_ovo_invest_new),
                        contentDescription = "Logo Ovo",
                        modifier = Modifier.padding(top = SPACE_X1)
                    )
                    Spacer(
                        modifier = Modifier.height(SPACE_X1_HALF)
                    )
                    Row(
                        modifier = Modifier.wrapContentWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(
                            text = "Powered by",
                            style = MaterialTheme.typography.body2,
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
                        color = Gray600,
                        style = MaterialTheme.typography.caption,
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

@Composable
fun ExcitingUpdateSection() {
    BaseSurface(
        title = "Yang Menarik di OVO",
        subtitle = "Jangan ngaku update kalau belum coba fitur ini",
        verticalPadding = SPACE_X3,
    ) {
        BoxWithConstraints(
            modifier = Modifier
                .padding(horizontal = SPACE_X2)
                .padding(bottom = SPACE_HALF)
        ) {
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
fun HomeScreen() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Gray200)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(SPACE_X1),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(Modifier.statusBarsHeight(additional = SPACE_X6))
            BalanceTransactionSection()
            SpecialPromoSection()
            YourFinancialSection()
            ExcitingUpdateSection()
        }
        ActionBar(
            headerContent = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_logo_ovo_white),
                    contentDescription = "Ovo Logo",
                    modifier = Modifier
                        .height(SPACE_X2_HALF)
                        .padding(start = SPACE_X1_QUARTER),
                )
            }
        )
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