package com.wiryadev.ovoclone.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.wiryadev.ovoclone.R
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_X3
import com.wiryadev.ovoclone.ui.components.ScanBottomSheet

@Composable
fun ScanScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        verticalArrangement = Arrangement.Bottom,
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_qris_supported),
            contentDescription = "Qris Supported",
            modifier = Modifier.padding(SPACE_X3)
        )
        ScanBottomSheet()
    }
}