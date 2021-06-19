package com.wiryadev.ovoclone.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_X1
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_X1_HALF
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_X2
import com.wiryadev.ovoclone.R
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_HALF
import com.wiryadev.ovoclone.ui.theme.*

@Composable
fun ScanBottomSheet(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.Transparent)
            .clip(
                RoundedCornerShape(
                    topStart = SPACE_X1_HALF,
                    topEnd = SPACE_X1_HALF,
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(SPACE_X2),
            verticalArrangement = Arrangement.spacedBy(SPACE_X2),
        ) {
            Text(
                text = "Bisa juga pakai",
                color = BlackText,
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
                        text = "Nomor HP",
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
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Gray200)
                .padding(vertical = SPACE_X1),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            Text(
                text = "Scan tiket parkir bermasalah?",
                color = BlackText,
                style = MaterialTheme.typography.caption,
            )
            Divider(
                modifier = Modifier
                    .width(SPACE_HALF),
                color = Color.Transparent,
            )
            Text(
                text = "Input Manual",
                color = Teal500,
                style = MaterialTheme.typography.h6,
            )
        }
    }
}

@Composable
fun QrisOption(
    @DrawableRes icon: Int,
    text: String,
    width: Dp,
    onClick: () -> Unit,
) {
    Surface(
        modifier = Modifier
            .width(width)
            .clip(shape = Shapes.small),
        elevation = SPACE_X1,
    ) {
        Row(
            Modifier
                .background(
                    color = Color.Transparent
                )
                .border(
                    border = BorderStroke(
                        width = 1.dp,
                        color = Color.LightGray,
                    ),
                    shape = Shapes.small,
                )
                .clickable(
                    onClick = onClick,
                    role = Role.Button,
                    interactionSource = remember { MutableInteractionSource() },
                    indication = rememberRipple()
                )
                .padding(
                    all = SPACE_X2
                ),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = text,
            )
            Divider(
                modifier = Modifier.width(SPACE_X1_HALF),
                color = Color.Transparent,
            )
            Text(
                text = text,
                color = BlackText,
                style = MaterialTheme.typography.h4,
                maxLines = 1,
            )
        }
    }
}

@Preview
@Composable
fun PreviewQrisButton() {
    OvoCloneTheme {
        Box(
            modifier = Modifier
                .background(Color.Transparent)
                .fillMaxSize()
        ) {
            ScanBottomSheet(
                modifier = Modifier.align(Alignment.BottomCenter)
            )
        }
    }
}