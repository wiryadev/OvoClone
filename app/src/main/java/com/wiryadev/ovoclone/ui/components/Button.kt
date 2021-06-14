package com.wiryadev.ovoclone.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
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
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.wiryadev.ovoclone.R
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_X1
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_X2
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_X3
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_X6
import com.wiryadev.ovoclone.ui.theme.*

@Composable
fun RavierButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    text: String,
    buttonType: ButtonType = ButtonType.Primary,
    height: Dp = SPACE_X6,
    shape: Shape = RoundedCornerShape(SPACE_X3),
    @DrawableRes icon: Int? = null,
) {
    Surface(
        modifier = modifier
            .height(height)
            .clip(shape = shape),
        elevation = SPACE_X1,
    ) {
        Row(
            Modifier
                .background(
                    color = buttonType.backgroundColor
                )
                .clickable(
                    onClick = onClick,
                    role = Role.Button,
                    interactionSource = remember { MutableInteractionSource() },
                    indication = if (buttonType == ButtonType.LinkButton) {
                        null
                    } else {
                        rememberRipple()
                    }
                )
                .padding(
                    horizontal = SPACE_X2
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
                color = buttonType.contentColor,
                paddingHorizontal = if (buttonType == ButtonType.LinkButton) SPACE_X1 else SPACE_X2
            )
        }
    }
}

@Composable
private fun TextButton(
    text: String,
    color: Color,
    paddingHorizontal: Dp,
) {
    Text(
        text = text,
        color = color,
        style = MaterialTheme.typography.button,
        modifier = Modifier.padding(horizontal = paddingHorizontal),
        maxLines = 1,
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

    object LinkButton : ButtonType(
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
                .padding(SPACE_X3),
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
            RavierButton(
                onClick = {  },
                modifier = Modifier.wrapContentWidth(),
                text = "Ghost Medium",
                buttonType = ButtonType.LinkButton,
            )
        }
    }
}