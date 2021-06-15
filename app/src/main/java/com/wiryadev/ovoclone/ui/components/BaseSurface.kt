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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wiryadev.ovoclone.ui.theme.BlackText

@Composable
fun BaseSurface(
    title: String,
    subtitle: String? = null,
    viewAllEnable: Boolean = false,
    verticalPadding: Dp = Dimens.SPACE_X2,
    contentHorizontalPadding: Dp? = null,
    content: @Composable () -> Unit,
) {
    val contentPaddingValues = if (contentHorizontalPadding != null) {
        PaddingValues(start = Dimens.SPACE_X2)
    } else {
        PaddingValues(all = 0.dp)
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(
                vertical = verticalPadding,
                horizontal = if (contentHorizontalPadding != null) {
                    0.dp
                } else {
                    Dimens.SPACE_X2
                },
            ),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(contentPaddingValues),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = title,
                color = BlackText,
                style = MaterialTheme.typography.h4,
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
                color = BlackText,
                style = TextStyle(
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp,
                    lineHeight = 18.sp,
                ),
            )
        }
        content()
    }
}