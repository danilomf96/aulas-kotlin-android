package com.testando.revisao

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.testando.revisao.data.Livro
import com.testando.revisao.data.LivroViewModel

class MainActivity : AppCompatActivity() {

    lateinit var livroViewModel: LivroViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        livroViewModel = ViewModelProvider(this).get(LivroViewModel::class.java)

        livroViewModel.addLivro(Livro(0 ,"marvel", "2022"))

    }
}