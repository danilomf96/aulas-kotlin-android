package com.testando.aula13

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class LivroViewModel(application: Application): AndroidViewModel(application) {

    private val readAllData: LiveData<List<Livro>>
    private val repository: LivroRepository

    init{
        val livroDao = LivroDatabase.getDatabase(application).livroDao()
        repository = LivroRepository(livroDao)
        readAllData = repository.readAllData
    }

    fun addLivro(livro: Livro){
        viewModelScope.launch{
            repository.addLivro(livro)
        }
    }

}