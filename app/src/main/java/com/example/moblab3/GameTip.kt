package com.MobLab3

import androidx.annotation.DrawableRes

data class GameTip(
    val dayNumber: Int,
    val title: String,
    val description: String,
    val fullDescription: String,
    @DrawableRes val imageResId: Int
)