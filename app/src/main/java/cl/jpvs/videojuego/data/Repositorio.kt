package cl.jpvs.videojuego.data

import android.util.Log
import androidx.lifecycle.LiveData
import cl.jpvs.videojuego.data.local.VideoGameDao
import cl.jpvs.videojuego.data.local.VideoGameEntity
import cl.jpvs.videojuego.data.remote.VideoGame
import cl.jpvs.videojuego.data.remote.VideoGameApi

class Repositorio (private val videoGameApi: VideoGameApi, private val videoGameDao: VideoGameDao) {

    fun obtenerVideoGameEntity(): LiveData<List<VideoGameEntity>> = videoGameDao.getALLVideoGame()

    suspend fun CargarVideoGames() {
        try {
            val respuesta = videoGameApi.getDataVideoGame()
            if (respuesta.isSuccessful) {
                val resp = respuesta.body()
                resp?.let {
                    val videoGameEntity = it.map { it.transformarEntity() }
                    videoGameDao.insertALLVideoGame(videoGameEntity)
                }
            } else {
                Log.e("repositorio", respuesta.errorBody().toString())
            }
        } catch (exception: Exception) {
            Log.e("catch", exception.toString())
        }
    }
    private fun VideoGame.transformarEntity(): VideoGameEntity = VideoGameEntity(
        this.id,
        this.nombre,
        this.origen,
        this.link,
        this.descripcion,
        this.creacion,
        this.manual

    )
}