package com.wiryadev.ovoclone.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wiryadev.ovoclone.R
import com.wiryadev.ovoclone.ui.theme.*

private const val BIG_BUTTON_HEIGHT = 48

@Composable
fun RavierButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    text: String,
    buttonType: ButtonType,
    shape: Shape = RoundedCornerShape(50),
    @DrawableRes icon: Int? = null,
) {
    Surface(
        modifier = modifier
            .height(BIG_BUTTON_HEIGHT.dp)
            .clip(shape = shape),
        elevation = 8.dp,
    ) {
        Row(
            Modifier
                .indication(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = rememberRipple()
                )
                .background(
                    color = buttonType.backgroundColor
                )
                .clickable(
                    onClick = onClick,
                    role = Role.Button
                )
                .padding(
                    horizontal = 16.dp
                ),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            if (icon != null) {
                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = text,
                    tint = buttonType.contentColor
                )
            }
            TextButton(
                text = text,
                color = buttonType.contentColor
            )
        }
    }
}

@Composable
private fun TextButton(
    text: String,
    color: Color,
) {
    Text(
        text = text,
        color = color,
        style = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp,
            lineHeight = 18.sp,
        ),
        modifier = Modifier.padding(horizontal = 16.dp),
        textAlign = TextAlign.Center,
        maxLines = 1
    )
}

sealed class ButtonType(
    val backgroundColor: Color,
    val contentColor: Color,
) {
    object Primary : ButtonType(
        backgroundColor = Purple500,
        contentColor = Color.White,
    )

    object Secondary : ButtonType(
        backgroundColor = Purple150,
        contentColor = Purple500,
    )

    object Tertiary : ButtonType(
        backgroundColor = Color.White,
        contentColor = Purple500,
    )

    object Ghost : ButtonType(
        backgroundColor = Color.Transparent,
        contentColor = Gray600,
    )

    object GhostSecondary : ButtonType(
        backgroundColor = Color.Transparent,
        contentColor = Teal500,
    )
}

@Preview
@Composable
fun ButtonPreview() {
    OvoCloneTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF4F4F4))
                .padding(24.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            RavierButton(
                onClick = {  },
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(id = R.string.primary_button),
                buttonType = ButtonType.Primary,
            )
            RavierButton(
                onClick = {  },
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(R.string.primary_image),
                buttonType = ButtonType.Primary,
                icon = R.drawable.ic_24_edit,
            )
            RavierButton(
                onClick = {  },
                modifier = Modifier.wrapContentSize(),
                text = "Primary Medium",
                buttonType = ButtonType.Primary,
            )
            RavierButton(
                onClick = {  },
                modifier = Modifier.wrapContentSize(),
                text = stringResource(id = R.string.primary_image),
                buttonType = ButtonType.Primary,
                icon = R.drawable.ic_24_edit,
            )
            RavierButton(
                onClick = {  },
                modifier = Modifier.wrapContentWidth(),
                text = "Secondary Medium",
                buttonType = ButtonType.Secondary,
            )
            RavierButton(
                onClick = {  },
                modifier = Modifier.wrapContentWidth(),
                text = "Tertiary Medium",
                buttonType = ButtonType.Tertiary,
            )
            RavierButton(
                onClick = {  },
                modifier = Modifier.wrapContentWidth(),
                text = "Ghost Medium",
                buttonType = ButtonType.Ghost,
            )
        }
    }
}