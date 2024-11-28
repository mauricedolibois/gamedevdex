package pt.iade.games.gamedevedex.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.net.URI

@Parcelize
data class Student(
    val id: Int,
    val name: String,
    val avatar: Int,
    val biography: String,
    val mood: String
): Parcelable
