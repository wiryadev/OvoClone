package com.wiryadev.ovoclone.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import com.google.accompanist.insets.statusBarsHeight
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.wiryadev.ovoclone.R
import com.wiryadev.ovoclone.data.HappinessDeal
import com.wiryadev.ovoclone.ui.components.ActionBar
import com.wiryadev.ovoclone.ui.components.BaseSurface
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_X1
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_X14_HALF
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_X1_QUARTER
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_X2
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_X4
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_X5
import com.wiryadev.ovoclone.ui.components.PromoImage
import com.wiryadev.ovoclone.ui.theme.PepperLighter
import com.wiryadev.ovoclone.ui.theme.TaroLighter
import com.wiryadev.ovoclone.ui.theme.Taro

val cashbackImages = listOf(
    "https://images-loyalty.ovo.id/public/deal/62/80/l/28162.jpg?ver=1",
    "https://images-loyalty.ovo.id/public/deal/12/81/l/28349.jpg?ver=1",
    "https://images-loyalty.ovo.id/public/deal/70/80/l/28601.jpg?ver=1",
    "https://images-loyalty.ovo.id/public/deal/04/80/l/28211.jpg?ver=1",
    "https://images-loyalty.ovo.id/public/deal/51/81/l/28214.jpg?ver=1",
    "https://images-loyalty.ovo.id/public/deal/52/80/l/28364.jpg?ver=1",
    "https://images-loyalty.ovo.id/public/deal/20/81/l/28369.jpg?ver=1",
    "https://images-loyalty.ovo.id/public/deal/02/80/l/28446.jpg?ver=1",
    "https://images-loyalty.ovo.id/public/deal/84/78/l/28543.jpg?ver=1",
    "https://images-loyalty.ovo.id/public/deal/08/79/l/28555.jpg?ver=1",
)

val happinessDeals = listOf(
    HappinessDeal(
        "https://images-loyalty.ovo.id/public/deal/10/80/l/28579.jpg?ver=1",
        "Paket Rapid Antigen Nasal",
        "Siloam Hospitals",
        145,
        "224.000",
        "Buat kamu yang baru pertama kali menjalani tes rapid antigen, jangan takut sakit karena ada Rapid Antigen Nasal yang minim rasa sakit. Rapid Antigen Nasal merupakan tes tesehatan yang lebih nyaman untuk anak-anak dan lansia karena pengambilan sampel hanya 2cm kedalam hidung.  Yuk, cegah sejak dini dan lindungi orang disekitar kita dengan test Rapid Antigen Nasal di Rumah Sakit Siloam dengan harga promo hanya Rp224.000,-.",
    ),
    HappinessDeal(
        "https://images-loyalty.ovo.id/public/deal/19/76/l/27770.jpg?ver=1",
        "Paket SWAB Antigen C19",
        "Siloam Hospitals",
        73,
        "174.000",
        "Dalam upaya mendukung pemerintah untuk menekan laju penyebaran Covid-19, Siloam Hospitals Group menghadirkan paket Swab Antingen C19 dengan harga lebih hemat cukup dengan Rp 174.000 di OVO Deals (harga terbaru), paket sudah termasuk tes Swab Antigen dan surat keterangan hasil. Yuk, cek sekarang untuk bantu pemerintah dalam usaha menghentikan penyebaran Covid-19."
    ),
    HappinessDeal(
        "https://images-loyalty.ovo.id/public/deal/59/77/l/28392.jpg?ver=1",
        "Bakmi GM Paket Single",
        "Bakmi GM",
        479,
        "57.750",
        "Siapa yang rindu Bakmi Ayam Lada di Bakmi GM? \n" +
                "\n" +
                "Pas banget nih buat kamu karena lagi ada promo paket Single hanya Rp57.750,- kamu bisa dapet 1 Bakmi Special GM, 1 Pangsit Goreng isi 5 dan minuman juga. Yuk segera merapat ke Bakmi GM terdekat dan beli voucher Deals-nya di aplikasi OVO!"
    ),
    HappinessDeal(
        "https://images-loyalty.ovo.id/public/deal/02/79/l/28552.jpg?ver=1",
        "Sukiyaki Set Hanya 150rb",
        "Yoshinoya",
        497,
        "150.000",
        "Sukiyaki Set adalah produk baru #YoshinoyaDiRumah, yang merupakan menu Ready to Cook dan khusus takeaway dengan slogan \"Praktis, Sehat dan Komplit\". Menu ini siap dimasak dengan 3 langkah mudah, hanya 5 menit, dan Sukiyaki Set siap untuk disajikan untuk 2 orang. Yuk, beli Sukiyaki Set pake OVO cuma 150.000."
    ),
    HappinessDeal(
        "https://images-loyalty.ovo.id/public/deal/34/80/l/28587.jpg?ver=1",
        "Luscious, Korean Style",
        "Classified",
        199,
        "111.640",
        "Kangen makanan dari Negeri Ginseng dan mau nongkrong di tempat yang cozy? Classified punya solusinya buat kamu"
    ),
    HappinessDeal(
        "https://images-loyalty.ovo.id/public/deal/64/80/l/28598.jpg?ver=1",
        "The Fried Love",
        "The Duck King",
        200,
        "160.000",
        "Kabar gembira nih buat Duckie Friends! Jangan sampai ke-miss menu ekonomis dari The Duck King"
    ),
    HappinessDeal(
        "https://images-loyalty.ovo.id/public/deal/68/80/l/28600.jpg?ver=1",
        "Authentic Duck Taste",
        "The Duck King",
        200,
        "160.000",
        "Kabar gembira nih buat Duckie Friends! Jangan sampai ke-miss menu ekonomis dari The Duck King"
    ),
    HappinessDeal(
        "https://images-loyalty.ovo.id/public/deal/70/78/l/28537.jpg?ver=1",
        "Voucher 500rb, Only 400ribu",
        "MAGAL KOREAN BBQ",
        33,
        "400.000",
        "Nikmati Makan Korea BBQ di Magal Korean dengan Voucher 500ribu hanya dengan 400ribu, dan kamu bisa nikmatin menu-menu favorit kamu di Magal BBQ Surabaya! Yuk, penawaran ini hanya sampai akhir 31 Juli 2021 saja ya."
    ),
    HappinessDeal(
        "https://images-loyalty.ovo.id/public/deal/98/78/l/28550.jpg?ver=1",
        "Hemat Berdua Hanya 50ribuan",
        "TEXAS CHICKEN",
        497,
        "54.600",
        "Udah deh paling bener kalau lagi laper carinya Texas Chicken aja. Hanya dengan Rp54.600,- dari harga normal Rp78.000,- kamu udah bisa makan berdua dan dapat minum juga. Hemat banget kan? Yuk buruan ke Texas Chicken terdekat!"
    ),
)

@Composable
fun SearchDeals() {
    Row(
        modifier = Modifier
            .background(Color.White)
            .fillMaxWidth()
            .padding(
                horizontal = SPACE_X2,
                vertical = SPACE_X1,
            ),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        BoxWithConstraints {
            val textFieldWidth = this.maxWidth - (SPACE_X5 + SPACE_X2)
            Box(
                modifier = Modifier
                    .width(textFieldWidth)
                    .height(SPACE_X5)
                    .clip(RoundedCornerShape(SPACE_X1_QUARTER))
                    .background(PepperLighter),
                contentAlignment = Alignment.Center,
                propagateMinConstraints = true,
            ) {
                Text(
                    text = "Cari Merchants",
                    color = Color(0xFFC3C3C3),
                    style = MaterialTheme.typography.body2,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .wrapContentHeight()
                )
            }
        }
        Spacer(modifier = Modifier.width(SPACE_X2))
        Image(
            painter = painterResource(id = R.drawable.ic_my_vouchers),
            contentDescription = "My Vouchers",
            modifier = Modifier.size(SPACE_X5),
        )
    }
}

@Composable
fun ViewDealsNearby() {
    Row(
        modifier = Modifier
            .padding(SPACE_X2)
            .clip(RoundedCornerShape(SPACE_X1))
            .background(
                brush = Brush.horizontalGradient(
                    listOf(
                        Taro,
                        TaroLighter,
                    )
                )
            )
            .padding(SPACE_X1),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        BoxWithConstraints {
            val itemWidth = this.maxWidth - (SPACE_X5)
            Row(
                modifier = Modifier.width(itemWidth),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(SPACE_X1),
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_near_me),
                    contentDescription = "View Deals Nearby",
                )
                Text(
                    text = "1 Langkah menuju deals WAH!",
                    color = Color.White,
                    style = MaterialTheme.typography.h4,
                    maxLines = 2,
                )
            }
        }
        Image(
            painter = painterResource(id = R.drawable.ic_arrow_right),
            contentDescription = "Voew Deals Nearby",
        )
    }
}

@ExperimentalPagerApi
@Composable
fun Cashbacks(
    itemWidth: Dp,
) {
    val pagerState = rememberPagerState(pageCount = cashbackImages.size)

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        HorizontalPager(
            state = pagerState,
            itemSpacing = SPACE_X2,
            modifier = Modifier
                .fillMaxWidth(),
        ) { page ->
            // Our page content
            PromoImage(
                imageUrl = cashbackImages[page],
                width = itemWidth,
            )
        }
    }
}

@ExperimentalPagerApi
@Composable
fun CashbackSection() {
    BaseSurface(
        title = "Cashback Lagi dan Lagi",
        subtitle = "Serbu Berbagai promo terbaru OVO",
        viewAllEnable = true,
        titleTextStyle = MaterialTheme.typography.h4,
        subtitleTextStyle = MaterialTheme.typography.body2,
    ) {
        BoxWithConstraints {
            val itemWidth = this.maxWidth - SPACE_X4
            Cashbacks(
                itemWidth = itemWidth
            )
        }
    }
}

@ExperimentalPagerApi
@Composable
fun DealsScreen() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(PepperLighter)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(SPACE_X1),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(Modifier.statusBarsHeight(additional = SPACE_X14_HALF))
            ViewDealsNearby()
            CashbackSection()
        }
        ActionBar(
            headerContent = {
                Text(
                    text = "Deals",
                    style = MaterialTheme.typography.h4,
                    modifier = Modifier
                        .padding(start = SPACE_X2),
                )
            },
            bodyContent = { SearchDeals() }
        )
    }
}