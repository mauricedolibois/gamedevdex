package pt.iade.games.gamedevedex.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.net.URI

@Parcelize
data class ProjectAsset(
    val asset: Int,
    val description: String
) : Parcelable
