package cl.jpvs.videojuego.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// https://video-juegos-o6fwzuojk-mariocanedo.vercel.app/videojuegos
class VideoGameRetrofit {
    companion object{

        private const val BASE_URL = "https://video-juegos-o6fwzuojk-mariocanedo.vercel.app/"

        fun getRetroFitVideoGame(): VideoGameApi{

            val mRetrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return mRetrofit.create(VideoGameApi::class.java)

        }
    }
}