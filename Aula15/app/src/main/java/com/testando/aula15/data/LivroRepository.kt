package com.testando.aula15.data

import androidx.lifecycle.LiveData

class LivroRepository(private val livroDao: LivroDao) {

    val readAllData: LiveData<List<Livro>> = livroDao.readAllData()


    suspend fun addLivro(livro: Livro){
        livroDao.addLivro(livro)
    }

    suspend fun updateLivro(livro: Livro){
        livroDao.updateLivro(livro)
    }

    suspend fun deleteLivro(livro: Livro){
        livroDao.deleteLivro(livro)
    }

    suspend fun deleteAll(){
        livroDao.deleteAll()
    }

}