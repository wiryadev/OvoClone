package com.wiryadev.ovoclone.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.wiryadev.ovoclone.ui.components.Dimens.CardShadowElevation
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_HALF
import com.wiryadev.ovoclone.ui.theme.Shapes

@Composable
fun RavierCard(
    modifier: Modifier = Modifier,
    shape: Shape = Shapes.medium,
    elevation: Dp = CardShadowElevation,
    shadowPadding: PaddingValues = PaddingValues(SPACE_HALF - 1.dp),
    content: @Composable () -> Unit,
) {
    ConstraintLayout(
        modifier = modifier
    ) {
        val (shadow, contentRef) = createRefs()
        Box(
            modifier = Modifier
                .constrainAs(shadow) {
                    top.linkTo(contentRef.top)
                    bottom.linkTo(contentRef.bottom)
                    start.linkTo(contentRef.start)
                    end.linkTo(contentRef.end)

                    height = Dimension.fillToConstraints
                    width = Dimension.fillToConstraints
                }
                .padding(shadowPadding)
                .shadow(
                    elevation = elevation,
                    shape = shape,
                    clip = false,
                )
        )

        Box(
            modifier = Modifier
                .clip(shape = shape)
                .background(MaterialTheme.colors.surface)
                .constrainAs(contentRef) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        ) {
            content()
        }
    }
}