package com.route.islamiapp.model

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Chapter(
    val titleAr: String? = null,
    val titleEn: String? = null,
    val order: Int? = null,
    val length: String? = null
):Parcelable


// Serializable
// Parcelable