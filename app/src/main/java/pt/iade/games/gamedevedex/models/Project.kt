package pt.iade.games.gamedevedex.models

import android.os.Parcelable
import android.provider.MediaStore.Audio.Genres
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Project(
    val id: Int,
    val title: String,
    val genre: String,
    val platform: String,
    var votes: Int,
    val assets: List<ProjectAsset>,
    val description: String,
    val groupMembers: List<Student>,
    val semester: Int
) : Parcelable
