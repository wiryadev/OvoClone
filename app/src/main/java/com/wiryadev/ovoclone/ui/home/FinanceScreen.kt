package com.wiryadev.ovoclone.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.insets.statusBarsHeight
import com.wiryadev.ovoclone.R
import com.wiryadev.ovoclone.ui.components.ActionBar
import com.wiryadev.ovoclone.ui.components.Dimens
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_X7
import com.wiryadev.ovoclone.ui.components.FinanceBox
import com.wiryadev.ovoclone.ui.theme.PepperLighter
import com.wiryadev.ovoclone.ui.theme.OvoCloneTheme

@Composable
fun FinanceScreen() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(PepperLighter)
                .padding(horizontal = Dimens.SPACE_X2)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(Dimens.SPACE_X2),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(Modifier.statusBarsHeight(additional = SPACE_X7))
            FinanceBox(
                onClick = { },
                image = R.drawable.rico_system_capital,
                title = "Modal Karyawan",
                body = "Hadir untuk memberikan dana pinjaman untuk keperluan kamu",
                sponsorImage = R.drawable.ic_taralite_logo,
                sponsorName = "Taralite"
            )
            FinanceBox(
                onClick = { },
                image = R.drawable.ic_finance_invest,
                title = "Invest",
                body = "Beli produk investasi dengan mudah dan aman pake OVO Cash!",
                sponsorImage = R.drawable.ic_bareksa_logo,
                sponsorName = "Bareksa"
            )
        }
        ActionBar(
            headerContent = {
                Text(
                    text = "Finance",
                    color = Color.White,
                    style = MaterialTheme.typography.h4,
                    modifier = Modifier
                        .padding(start = Dimens.SPACE_X2),
                )
            }
        )
    }
}

@Preview
@Composable
fun PreviewFinanceScreen() {
    OvoCloneTheme {
        FinanceScreen()
    }
}