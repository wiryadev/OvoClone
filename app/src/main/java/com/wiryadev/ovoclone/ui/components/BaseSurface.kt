package com.wiryadev.ovoclone.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_X1
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_X2
import com.wiryadev.ovoclone.ui.theme.ShallotDarkest
import com.wiryadev.ovoclone.ui.theme.PepperDark

@Composable
fun BaseSurface(
    title: String,
    subtitle: String? = null,
    viewAllEnable: Boolean = false,
    paddingValues: PaddingValues = PaddingValues(vertical = SPACE_X2),
    titleTextStyle: TextStyle = MaterialTheme.typography.h3,
    subtitleTextStyle: TextStyle = MaterialTheme.typography.caption,
    content: @Composable () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(paddingValues),
        verticalArrangement = Arrangement.spacedBy(SPACE_X2),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = SPACE_X2,
                ),
            verticalArrangement = Arrangement.spacedBy(SPACE_X1),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = title,
                    color = ShallotDarkest,
                    style = titleTextStyle,
                    maxLines = 1,
                )
                if (viewAllEnable) {
                    RavierButton(
                        onClick = { },
                        text = "Lihat Semua",
                        buttonType = ButtonType.LinkButton,
                        height = Dimens.SPACE_X4,
                    )
                }
            }
            if (subtitle != null) {
                Text(
                    text = subtitle,
                    color = PepperDark,
                    style = subtitleTextStyle,
                )
            }
        }
        content()
    }
}