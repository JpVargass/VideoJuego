package cl.jpvs.videojuego.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [VideoGameEntity::class], version = 1)
abstract class VideoGameDataBase : RoomDatabase() {
    abstract fun getVideoGameDao(): VideoGameDao

    companion object {
        //@Volatile
        private var INSTANCE: VideoGameDataBase? = null

        fun getDatabase(context: Context): VideoGameDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    VideoGameDataBase::class.java,
                    "videogame_database"
                ).build()

                INSTANCE = instance
                return instance
            }
        }
    }

}