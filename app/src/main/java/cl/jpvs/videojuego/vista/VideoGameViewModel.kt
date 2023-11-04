package cl.jpvs.videojuego.vista

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import cl.jpvs.videojuego.data.Repositorio
import cl.jpvs.videojuego.data.local.VideoGameDataBase
import cl.jpvs.videojuego.data.remote.VideoGameRetrofit
import kotlinx.coroutines.launch

class VideoGameViewModel(application: Application): AndroidViewModel(application) {
    private lateinit var repositorio: Repositorio


    init {
        val api = VideoGameRetrofit.getRetroFitVideoGame()
        val videoGameDataBase = VideoGameDataBase.getDatabase(application).getVideoGameDao()
        repositorio = Repositorio(api,videoGameDataBase)
    }

    fun videoGameLiveData() = repositorio.obtenerVideoGameEntity()
    fun getAllVideoGame() = viewModelScope.launch {
        repositorio.CargarVideoGames()
    }
}