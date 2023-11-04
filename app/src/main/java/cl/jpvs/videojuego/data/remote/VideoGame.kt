package cl.jpvs.videojuego.data.remote

import com.google.gson.annotations.SerializedName

/*
 {
    "id": 1,
    "nombre": "SUPER MARIO WORLD",
    "origen": "JAPÓN",
    "imagenLink": "https://static.wikia.nocookie.net/nintendo/images/6/61/Super_Mario_World.jpg/revision/latest?cb=20130705153938&path-prefix=es",
    "descripcion": "BASADO EN LOS PRIMEROS JUEGOS DE MARIO EN COMPAÑOA DE YOSHI",
    "Año_creacion": 1990,
    "manual": true
  }
   */
data class VideoGame (
    val id: Int,
    val nombre: String,
    val origen: String,
    @SerializedName("imagenLink") val link: String,
    val descripcion: String,
    @SerializedName("Año_creacion") val creacion: Int,
    val manual : Boolean

    )
