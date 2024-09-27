package com.testando.aula13

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface LivroDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addLivro(livro: Livro)

    @Query("SELECT * FROM tabela_livro ORDER BY id ASC")
    fun readAllData(): LiveData<List<Livro>>
}