package com.testando.revisao.data

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
    suspend fun atualizarLivro(livro: Livro)

    @Delete
    fun deletarLivro(livro: Livro)

    @Query("DELETE FROM livro_table")
    suspend fun deleteAll()

    @Query("SELECT * FROM livro_table ORDER BY id ASC")
    fun listarLivro() : LiveData<List<Livro>>

}
