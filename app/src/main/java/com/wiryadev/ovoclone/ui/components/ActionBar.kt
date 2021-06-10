package com.wiryadev.ovoclone.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.statusBarsPadding
import com.wiryadev.ovoclone.R
import com.wiryadev.ovoclone.ui.theme.Purple600

@Composable
fun ActionBar() {
    TopAppBar(
        modifier = Modifier.statusBarsPadding(),
        backgroundColor = Purple600,
        contentColor = Color.White,
        elevation = 0.dp,
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Icon(
                painter = painterResource(id = R.drawable.logo_ovo),
                contentDescription = "Ovo Logo",
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(start = 16.dp),
            )
            IconButton(
                onClick = { /* todo */ },
                modifier = Modifier.align(Alignment.CenterVertically)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_bell),
                    contentDescription = "Notification",
                    tint = Color.White,
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewActionBar() {
    ActionBar()
}