package com.wiryadev.ovoclone.ui.home

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wiryadev.ovoclone.R
import com.wiryadev.ovoclone.data.Category
import com.wiryadev.ovoclone.ui.components.BaseSurface
import com.wiryadev.ovoclone.ui.components.Dimens
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_HALF
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_QUARTER
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_X1
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_X1_HALF
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_X2
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_X6
import com.wiryadev.ovoclone.ui.components.QrisOption
import com.wiryadev.ovoclone.ui.components.RavierButton
import com.wiryadev.ovoclone.ui.theme.*
import me.onebone.toolbar.CollapsingToolbarScaffold
import me.onebone.toolbar.ScrollStrategy
import me.onebone.toolbar.rememberCollapsingToolbarScaffoldState

@Composable
private fun ProfileDivider(
    modifier: Modifier = Modifier,
) {
    Divider(
        color = PepperLighter,
        modifier = modifier.padding(horizontal = SPACE_X2),
    )
}

@Composable
fun OverviewSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        Row(
            modifier = Modifier.padding(
                vertical = SPACE_X1_HALF,
                horizontal = SPACE_X2,
            ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(SPACE_X2),
        ) {
            Box(
                modifier = Modifier
                    .size(SPACE_X6)
                    .clip(CircleShape),
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
                modifier = Modifier
                    .padding(horizontal = SPACE_X2),
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
                    icon = R.drawable.rico_system_qrcode,
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
    onClick: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(
                onClick = onClick
            )
            .padding(all = SPACE_X2),
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
        Column {
            accountCategories.forEachIndexed { index, category ->
                ProfileItemRow(
                    item = category,
                    onClick = {},
                )

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
        Column {
            securityCategories.forEachIndexed { index, category ->
                ProfileItemRow(
                    item = category,
                    onClick = { }
                )

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
        Column {
            aboutCategories.forEachIndexed { index, category ->
                ProfileItemRow(
                    item = category,
                    onClick = {},
                )

                if (index != (aboutCategories.size - 1)) {
                    ProfileDivider()
                }
            }
        }
    }
}

@Composable
fun FooterRow(
    version: String,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = SPACE_X2),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = "Version $version",
            style = MaterialTheme.typography.caption,
        )
        Text(
            text = "#pakeOVOaja",
            color = PepperDarker,
            style = MaterialTheme.typography.h6,
        )
    }
}

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier
) {
    val state = rememberCollapsingToolbarScaffoldState()
    val progress = state.toolbarState.progress
    val textSize = (16 + 8 * progress).sp

    CollapsingToolbarScaffold(
        modifier = Modifier
            .fillMaxSize(),
        scrollStrategy = ScrollStrategy.ExitUntilCollapsed,
        state = state,
        toolbar = {
            Box(
                modifier = Modifier
                    .background(MaterialTheme.colors.surface)
                    .fillMaxWidth()
                    .height(104.dp)
                    .pin(),
            )

            Text(
                text = "Profile",
                modifier = Modifier
                    .padding(
                        vertical = if (progress > 0f) SPACE_X1 else Dimens.SPACE_X3,
                        horizontal = SPACE_X2,
                    )
                    .road(
                        whenCollapsed = Alignment.CenterStart,
                        whenExpanded = Alignment.BottomStart,
                    ),
                color = ShallotDarkest,
                style = MaterialTheme.typography.h4,
                fontSize = textSize,
            )
            IconButton(
                onClick = { },
                modifier = Modifier
                    .road(
                        whenCollapsed = Alignment.TopEnd,
                        whenExpanded = Alignment.TopEnd,
                    ),
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_notification_light_normal),
                    contentDescription = "Notification",
                    tint = ShallotDark,
                )
            }
        }
    ) {
        Column(
            modifier = modifier
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
            FooterRow("3.37.0 (330)")
            RavierButton(
                onClick = { },
                text = "Sign Out",
                modifier = Modifier
                    .padding(SPACE_X2)
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(SPACE_X2))
        }
    }
}

@Preview
@Composable
fun PreviewProfileScreen() {
    OvoCloneTheme {
        ProfileScreen()
    }
}