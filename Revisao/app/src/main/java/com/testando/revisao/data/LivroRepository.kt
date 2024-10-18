package com.testando.revisao.data

import androidx.lifecycle.LiveData

class LivroRepository(private val livroDao: LivroDao) {


    val readAllData: LiveData<List<Livro>> = livroDao.listarLivro()


    suspend fun addLivro(livro: Livro){
        livroDao.addLivro(livro)
    }

    suspend fun updateLivro(livro: Livro){
        livroDao.atualizarLivro(livro)
    }

    suspend fun deleteLivro(livro: Livro){
        livroDao.deletarLivro(livro)
    }

    suspend fun deleteAll(){
        livroDao.deleteAll()
    }

}