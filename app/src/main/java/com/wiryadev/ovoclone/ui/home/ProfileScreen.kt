package com.wiryadev.ovoclone.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.wiryadev.ovoclone.R
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_X2
import com.wiryadev.ovoclone.ui.components.QrisOption
import com.wiryadev.ovoclone.ui.theme.PepperLighter
import com.wiryadev.ovoclone.ui.theme.ShallotDarkest

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

@Preview
@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PepperLighter)
    ) {
        OvoIdSection()
    }
}