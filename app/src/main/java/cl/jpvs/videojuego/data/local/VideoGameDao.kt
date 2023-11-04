package cl.jpvs.videojuego.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface VideoGameDao {
   // listado de todos los Video Game
   @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun insertALLVideoGame(videogameList: List<VideoGameEntity>)

    @Query("SELECT * FROM VideoGame_table ORDER BY id ASC")
    fun getALLVideoGame(): LiveData<List<VideoGameEntity>>

   //reservado para el detalle


}