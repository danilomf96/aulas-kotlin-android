package com.testando.aula13

import androidx.lifecycle.LiveData

class LivroRepository (private val livroDao: LivroDao){
    val readAllData: LiveData<List<Livro>> = livroDao.readAllData()

    suspend fun addLivro(livro: Livro){
        livroDao.addLivro(livro)
    }
}