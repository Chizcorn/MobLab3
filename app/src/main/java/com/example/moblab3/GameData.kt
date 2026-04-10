package com.MobLab3

import android.content.Context

object GameData {
    fun getTips(context: Context): List<GameTip> {
        val tips = mutableListOf<GameTip>()
        for (i in 1..30) {
            val titleResId = context.resources.getIdentifier("tip_title_$i", "string", context.packageName)
            val descResId = context.resources.getIdentifier("tip_desc_$i", "string", context.packageName)
            val fullDescResId = context.resources.getIdentifier("tip_full_$i", "string", context.packageName)
            val imageResId = context.resources.getIdentifier("game_$i", "drawable", context.packageName)

            tips.add(
                GameTip(
                    dayNumber = i,
                    title = context.getString(titleResId),
                    description = context.getString(descResId),
                    fullDescription = context.getString(fullDescResId),
                    imageResId = if (imageResId != 0) imageResId else android.R.drawable.ic_menu_gallery
                )
            )
        }
        return tips
    }
}