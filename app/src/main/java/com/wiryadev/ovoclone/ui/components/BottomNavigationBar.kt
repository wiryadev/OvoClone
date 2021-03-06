package com.wiryadev.ovoclone.ui.components

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.lerp
import androidx.compose.ui.layout.*
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.zIndex
import com.wiryadev.ovoclone.ui.components.Dimens.BottomNavigationHeight
import com.wiryadev.ovoclone.ui.components.Dimens.CardShadowElevation
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_X1
import com.wiryadev.ovoclone.ui.components.Dimens.SPACE_X1_HALF
import kotlin.math.max
import kotlin.math.roundToInt


@Composable
fun RavierBottomNavigation(
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color.White,
    content: @Composable RowScope.() -> Unit
) {
    // Container to make positioning of the Box and Row possible
    BoxWithConstraints(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.Transparent)
            .wrapContentHeight()
    ) {

        // Add shadow effect for [BottomNavigation]
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(BottomNavigationHeight + SPACE_X1)
                .align(Alignment.BottomCenter)
                .shadow(
                    elevation = CardShadowElevation * 5
                )
        )

        // Background for the container, height should be set to [BottomNavigationHeight]
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(BottomNavigationHeight)
                .background(backgroundColor)
                .align(Alignment.BottomCenter)
        )

        // Container for the actual content, zIndex should be higher than the Background box
        Row(
            modifier = Modifier
                .zIndex(BottomNavigationHeight.value)
                .fillMaxWidth()
                .selectableGroup(),
            horizontalArrangement = Arrangement.SpaceBetween,
            content = content
        )
    }
}

// BottomNavigation code mostly coming from default BottomNavigation
// with removal of some unnecessary stuff
@Composable
fun RowScope.RavierBottomNavigationItem(
    selected: Boolean,
    onSelected: () -> Unit,
    icon: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    label: @Composable (() -> Unit),
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    Box(
        modifier = modifier
            .selectable(
                selected = selected,
                onClick = onSelected,
                enabled = enabled,
                role = Role.Tab,
                interactionSource = interactionSource,
                indication = null
            )
            .weight(1f),
        contentAlignment = Alignment.Center
    ) {
        BottomNavigationTransition(
            selected = selected
        ) {
            val styledLabel: @Composable (() -> Unit) = @Composable {
                val style = MaterialTheme.typography.caption.copy(textAlign = TextAlign.Center)
                ProvideTextStyle(style, content = label)
            }

            BottomNavigationItemBaselineLayout(
                icon = icon,
                label = styledLabel,
            )
        }
    }
}

@Composable
private fun BottomNavigationTransition(
    selected: Boolean,
    content: @Composable (animationProgress: Float) -> Unit
) {
    val animationProgress by animateFloatAsState(
        targetValue = if (selected) 1f else 0f,
        animationSpec = BottomNavigationAnimationSpec
    )

    val activeColor: Color = LocalContentColor.current
    val inactiveColor: Color = activeColor.copy(alpha = ContentAlpha.medium)

    val color = lerp(inactiveColor, activeColor, animationProgress)

    CompositionLocalProvider(
        LocalContentColor provides color.copy(alpha = 1f),
        LocalContentAlpha provides color.alpha,
    ) {
        content(animationProgress)
    }
}

@Composable
private fun BottomNavigationItemBaselineLayout(
    icon: @Composable () -> Unit,
    label: @Composable (() -> Unit),
) {
    Layout(
        {
            Box(Modifier.layoutId("icon")) { icon() }
            Box(
                Modifier
                    .layoutId("label")
                    .alpha(IconPositionAnimationProgress)
                    .padding(horizontal = BottomNavigationItemHorizontalPadding)
            ) { label() }
        }
    ) { measurables, constraints ->
        val iconPlaceable = measurables.first { it.layoutId == "icon" }.measure(constraints)

        val labelPlaceable = measurables.first { it.layoutId == "label" }.measure(
            // Measure with loose constraints for height as we don't want the label to take up more
            // space than it needs
            constraints.copy(minHeight = 0)
        )

        // If there is no label, just place the icon.
        placeLabelAndIcon(
            labelPlaceable,
            iconPlaceable,
            constraints,
        )
    }
}

private fun MeasureScope.placeLabelAndIcon(
    labelPlaceable: Placeable,
    iconPlaceable: Placeable,
    constraints: Constraints,
): MeasureResult {
    val height = constraints.maxHeight

    // have a better strategy than overlapping the icon and label
    val baseline = labelPlaceable[LastBaseline]

    val baselineOffset = CombinedItemTextBaseline.roundToPx()

    // Label should be [baselineOffset] from the bottom
    val labelY = height - baseline - baselineOffset

    val unselectedIconY = (height - iconPlaceable.height) / 2

    // Icon should be [baselineOffset] from the text baseline, which is itself
    // [baselineOffset] from the bottom
    val selectedIconY = height - (baselineOffset * 2) - iconPlaceable.height

    val containerWidth = max(labelPlaceable.width, iconPlaceable.width)

    val labelX = (containerWidth - labelPlaceable.width) / 2
    val iconX = (containerWidth - iconPlaceable.width) / 2

    // How far the icon needs to move between unselected and selected states
    val iconDistance = unselectedIconY - selectedIconY

    // When selected the icon is above the unselected position, so we will animate moving
    // downwards from the selected state, so when progress is 1, the total distance is 0, and we
    // are at the selected state.
    val offset = (iconDistance * (1 - IconPositionAnimationProgress)).roundToInt()

    return layout(containerWidth, height) {
        labelPlaceable.placeRelative(labelX, labelY + offset)
        iconPlaceable.placeRelative(iconX, selectedIconY + offset)
    }
}

private val BottomNavigationAnimationSpec = TweenSpec<Float>(
    durationMillis = 300,
    easing = FastOutSlowInEasing
)

private const val IconPositionAnimationProgress = 1f

private val CombinedItemTextBaseline = SPACE_X1_HALF

private val BottomNavigationItemHorizontalPadding = SPACE_X1_HALF