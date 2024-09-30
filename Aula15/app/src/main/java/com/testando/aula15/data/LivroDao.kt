package com.testando.aula15.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update


@Dao
interface LivroDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addLivro(livro: Livro)

    @Update
    suspend fun updateLivro(livro: Livro)


    @Delete
    suspend fun deleteLivro(livro: Livro)

    @Query("DELETE FROM livro_table")
    suspend fun deleteAll()

    @Query("SELECT * FROM livro_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Livro>>



}