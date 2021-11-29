package com.example.loginintento7.authentication.data.modelo

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.loginintento7.authentication.data.UsuarioDao

@Database(entities = [Usuario::class],version = 2)
abstract class BD : RoomDatabase(){

    abstract fun usuarioDao(): UsuarioDao

    companion object {

        @Volatile
        private var INSTANCE: BD? = null

        fun getDatabase(context: Context): BD {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(context.applicationContext,
                    BD::class.java,
                    "authentication_database")
                    .allowMainThreadQueries()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}