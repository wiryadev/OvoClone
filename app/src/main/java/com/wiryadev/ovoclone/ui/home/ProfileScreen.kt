package com.wiryadev.ovoclone.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.wiryadev.ovoclone.R
import com.wiryadev.ovoclone.data.Category
import com.wiryadev.ovoclone.ui.components.BaseSurface
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_HALF
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_QUARTER
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_X1
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_X1_HALF
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_X2
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_X6
import com.wiryadev.ovoclone.ui.components.QrisOption
import com.wiryadev.ovoclone.ui.theme.*

@Composable
private fun ProfileDivider(
    modifier: Modifier = Modifier,
) {
    Divider(
        color = PepperLighter,
        modifier = modifier,
    )
}

@Composable
fun OverviewSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(horizontal = SPACE_X2)
    ) {
        Row(
            modifier = Modifier.padding(vertical = SPACE_X1_HALF),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(SPACE_X2),
        ) {
            Box(
                modifier = Modifier.size(SPACE_X6).clip(CircleShape),
                contentAlignment = Alignment.Center,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.rima_splash_default),
                    contentDescription = "Profile Picture",
                    contentScale = ContentScale.FillBounds,
                )
            }
            Column(
                verticalArrangement = Arrangement.spacedBy(SPACE_QUARTER)
            ) {
                Text(
                    text = "Abrar Wiryawan",
                    color = ShallotDarkest,
                    style = MaterialTheme.typography.h5,
                )
                Text(
                    text = "0812-1234-5678",
                    color = PepperDark,
                    style = MaterialTheme.typography.caption,
                )
            }
        }
        ProfileDivider()
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = SPACE_X1_HALF),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(SPACE_X2),
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_status_premier_new),
                    contentDescription = "Status Premier",
                )
                Text(
                    text = "OVO Premier",
                    color = ShallotDarkest,
                    style = MaterialTheme.typography.h5,
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(SPACE_HALF),
            ) {
                Text(
                    text = "Lihat Detail",
                    color = Pepper,
                    style = MaterialTheme.typography.h6,
                )
                Image(
                    painter = painterResource(
                        id = R.drawable.ic_chevron_right_shallot
                    ),
                    contentDescription = "Status Premier",
                )
            }
        }
    }
}

@Composable
fun OvoIdSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(SPACE_X2),
        verticalArrangement = Arrangement.spacedBy(SPACE_X2),
    ) {
        Text(
            text = "OVO ID",
            color = ShallotDarkest,
            style = MaterialTheme.typography.h4,
        )
        BoxWithConstraints {
            val itemWidth = (this.maxWidth - SPACE_X2) / 2

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                QrisOption(
                    icon = R.drawable.ic_phone,
                    text = "QR Code",
                    width = itemWidth,
                    onClick = { }
                )
                QrisOption(
                    icon = R.drawable.ic_barcode,
                    text = "Loyalty",
                    width = itemWidth,
                    onClick = { }
                )
            }
        }
    }
}

@Composable
fun ProfileItemRow(
    item: Category,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = SPACE_X2),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(SPACE_X2),
        ) {
            Image(
                painter = painterResource(id = item.icon),
                contentDescription = item.title,
            )
            Text(
                text = item.title,
                color = ShallotDarkest,
                style = MaterialTheme.typography.h5,
            )
        }
        Image(
            painter = painterResource(
                id = R.drawable.ic_chevron_right_shallot
            ),
            contentDescription = item.title,
        )
    }
}

private val accountCategories = listOf(
    Category("A1", "Ubah Profil", R.drawable.ic_settings_edit_profile_new),
    Category("A2", "My Cards", R.drawable.ic_settings_my_cards_new),
    Category("A3", "Kode Promo", R.drawable.ic_settings_kode_promo_new),
)

@Composable
fun AccountSection() {
    BaseSurface(
        title = "Akun",
        titleTextStyle = MaterialTheme.typography.h4,
        paddingValues = PaddingValues(top = SPACE_X2)
    ) {
        Column(
            modifier = Modifier.padding(horizontal = SPACE_X2),
        ) {
            accountCategories.forEachIndexed { index, category ->
                ProfileItemRow(item = category)

                if (index != (accountCategories.size - 1)) {
                    ProfileDivider()
                }
            }
        }
    }
}

val securityCategories = listOf(
    Category("S1", "Ubah Security Code", R.drawable.ic_settings_security_code_new),
)

@Composable
fun SecuritySection() {
    BaseSurface(
        title = "Keamanan",
        titleTextStyle = MaterialTheme.typography.h4,
        paddingValues = PaddingValues(top = SPACE_X2)
    ) {
        Column(
            modifier = Modifier.padding(horizontal = SPACE_X2),
        ) {
            securityCategories.forEachIndexed { index, category ->
                ProfileItemRow(item = category)

                if (index != (securityCategories.size - 1)) {
                    ProfileDivider()
                }
            }
        }
    }
}

val aboutCategories = listOf(
    Category("T1", "Keuntungan Pakai OVO", R.drawable.ic_settings_ovo_benefit_new),
    Category("T2", "Panduan OVO", R.drawable.ic_settings_panduan_ovo_new),
    Category("T3", "Syarat dan Ketentuan", R.drawable.ic_settings_ovo_terms),
    Category("T4", "Kebijakan Privasi", R.drawable.ic_settings_kebijakan_privasi_new),
    Category("T5", "Pusat Bantuan", R.drawable.ic_settings_pusat_bantuan_new),
)

@Composable
fun AboutSection() {
    BaseSurface(
        title = "Tentang",
        titleTextStyle = MaterialTheme.typography.h4,
        paddingValues = PaddingValues(top = SPACE_X2)
    ) {
        Column(
            modifier = Modifier.padding(horizontal = SPACE_X2),
        ) {
            aboutCategories.forEachIndexed { index, category ->
                ProfileItemRow(item = category)

                if (index != (aboutCategories.size - 1)) {
                    ProfileDivider()
                }
            }
        }
    }
}

@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PepperLighter)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(SPACE_X1),
    ) {
        OverviewSection()
        OvoIdSection()
        AccountSection()
        SecuritySection()
        AboutSection()
    }
}

@Preview
@Composable
fun PreviewProfileScreen() {
    OvoCloneTheme {
        ProfileScreen()
    }
}