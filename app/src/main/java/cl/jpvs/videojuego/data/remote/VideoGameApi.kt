package cl.jpvs.videojuego.data.remote

import retrofit2.Response
import retrofit2.http.GET

// https://video-juegos-o6fwzuojk-mariocanedo.vercel.app/videojuegos
interface VideoGameApi {
    @GET("videojuegos")
    suspend fun getDataVideoGame(): Response<List<VideoGame>>
}