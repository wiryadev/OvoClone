package com.wiryadev.ovoclone.ui.components

import androidx.compose.foundation.layout.*
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
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_X1
import com.wiryadev.ovoclone.ui.theme.TaroDark

@Composable
fun ActionBar(
    headerContent: @Composable () -> Unit,
    bodyContent: @Composable (() -> Unit)? = null,
    backgroundColor: Color = TaroDark,
    contentColor: Color = Color.White
) {
    Column(
        modifier = Modifier.statusBarsPadding(),
    ) {
        TopAppBar(
            backgroundColor = backgroundColor,
            contentColor = contentColor,
            elevation = 0.dp,
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                headerContent()
                IconButton(
                    onClick = {  },
                    modifier = Modifier.align(Alignment.CenterVertically)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_notification_dark_normal),
                        contentDescription = "Notification",
                    )
                }
            }
        }
        if (bodyContent != null) {
            bodyContent()
        }
    }
}

@Preview
@Composable
fun PreviewActionBar() {
    ActionBar(
        headerContent = {
            Icon(
                painter = painterResource(id = R.drawable.ic_logo_ovo_white),
                contentDescription = "Ovo Logo",
                modifier = Modifier
                    .padding(start = SPACE_X1),
            )
        },
    )
}