package com.example.natifetask.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue


@Parcelize
data class GifItem(
    val id: String = "",
    val slug: String = "",
    val url: String = "",
    val username: String = "",
    val images: @RawValue GiphyImage = GiphyImage()
) : Parcelable

