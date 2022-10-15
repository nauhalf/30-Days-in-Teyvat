package com.nauhalf.thirtydaysinteyvat.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class TeyvatJourney(
    @DrawableRes
    val imageRes: Int,
    @StringRes
    val titleRes: Int,
    @StringRes
    val descriptionRes: Int,
)
