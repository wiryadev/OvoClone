package com.wiryadev.ovoclone.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorPalette = darkColors(
    primary = TaroLighter,
    primaryVariant = TaroDarker,
    secondary = SeaSaltLighter
)

private val LightColorPalette = lightColors(
    primary = Taro,
    primaryVariant = TaroDarker,
    secondary = SeaSaltLighter

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun OvoCloneTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        LightColorPalette
    } else {
        LightColorPalette
    }

    val sysUiController = rememberSystemUiController()

    SideEffect {
        sysUiController.setStatusBarColor(
            color = TaroDark
        )
        sysUiController.setNavigationBarColor(
            color = Color.White,
            darkIcons = true,
        )
    }

    MaterialTheme(
        colors = colors,
        typography = RavierTypography,
        shapes = Shapes,
        content = {
            ProvideWindowInsets {
                content()
            }
        }
    )
}