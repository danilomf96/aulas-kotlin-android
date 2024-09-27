package com.testando.aula13

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Livro::class],version = 1 , exportSchema = false)
abstract class LivroDatabase: RoomDatabase() {

    abstract fun livroDao(): LivroDao

    companion object{
        private var INSTANCE: LivroDatabase? = null;
        fun getDatabase(context: Context): LivroDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    LivroDatabase::class.java,
                    "tabela-livro"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}