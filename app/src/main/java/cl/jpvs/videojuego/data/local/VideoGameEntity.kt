package cl.jpvs.videojuego.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "VideoGame_table")
data class VideoGameEntity (
    @PrimaryKey val id: Int,
    val nombre: String,
    val origen: String,
    val link: String,
    val descripcion: String,
    val creacion: Int,
    val manual : Boolean
)
