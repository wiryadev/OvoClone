package com.wiryadev.ovoclone.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.wiryadev.ovoclone.R

// Set of Material typography styles to start with
val RavierFont = FontFamily(
    Font(R.font.roboto_regular, FontWeight.Normal),
    Font(R.font.roboto_medium, FontWeight.Medium),
    Font(R.font.eina_bold, FontWeight.Bold),
)

val RavierTypography = Typography(
    h1 = TextStyle(
        fontFamily = RavierFont,
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp,
    ),
    h2 = TextStyle(
        fontFamily = RavierFont,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        lineHeight = 36.sp,
    ),
    h3 = TextStyle(
        fontFamily = RavierFont,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        lineHeight = 26.sp,
    ),
    h4 = TextStyle(
        fontFamily = RavierFont,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        lineHeight = 24.sp,
    ),
    h5 = TextStyle(
        fontFamily = RavierFont,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        lineHeight = 22.sp,
    ),
    h6 = TextStyle(
        fontFamily = RavierFont,
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp,
        lineHeight = 18.sp,
    ),
    body1 = TextStyle(
        fontFamily = RavierFont,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 22.sp,
    ),
    body2 = TextStyle(
        fontFamily = RavierFont,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 22.sp,
    ),
    button = TextStyle(
        fontFamily = RavierFont,
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp,
        lineHeight = 18.sp,
        textAlign = TextAlign.Center,
    ),
    caption = TextStyle(
        fontFamily = RavierFont,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 18.sp,
    ),
)