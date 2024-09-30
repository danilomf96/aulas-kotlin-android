package com.testando.aula15.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LivroViewModel(application: Application):AndroidViewModel(application) {

    val readAllData: LiveData<List<Livro>>
    private val repository: LivroRepository

    init {
        val livroDao = LivroDatabase.getDatabase(application).livroDao()
        repository = LivroRepository(livroDao)
        readAllData = repository.readAllData
    }

    fun addLivro(livro: Livro){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addLivro(livro)
        }
    }

    fun updateLivro(livro: Livro){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateLivro(livro)
        }
    }

    fun deleteLivro(livro: Livro){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteLivro(livro)
        }
    }

    fun deleteAll(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAll()
        }
    }

}