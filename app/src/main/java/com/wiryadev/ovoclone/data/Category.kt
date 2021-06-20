package com.wiryadev.ovoclone.data

import androidx.annotation.DrawableRes

data class Category(
    val id: String,
    val title: String,
    @DrawableRes val icon: Int,
)