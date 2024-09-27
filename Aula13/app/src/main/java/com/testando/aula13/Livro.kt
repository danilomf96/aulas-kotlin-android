package com.testando.aula13

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabela_livro")
data class Livro(
    @PrimaryKey(autoGenerate = true)
    val Id: Int,
    val Nome: String,
    val Ano: Int
)