package com.testando.exercicioaula07

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.TextView

class PrimeiraPagina : AppCompatActivity() {
    private lateinit var txtUsuario: TextView
    private lateinit var btnLivro1: Button
    private lateinit var btnLivro2: Button
    private lateinit var btnLivro3: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_primeira_pagina)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Inicializar os TextViews
        txtUsuario = findViewById(R.id.bemvindo) // Corrigido para ID do layout XML
        // Recuperar o valor passado pela Intent
        val usuario = intent.getStringExtra("nome_usuario") ?: "sem usuário"
        // Atualizar o conteúdo dos TextViews
        txtUsuario.text = "Bem-vindo $usuario"

        btnLivro1 = findViewById(R.id.livro1)
        btnLivro2 = findViewById(R.id.livro2)
        btnLivro3 = findViewById(R.id.livro3)

        val novaTela=Intent(this, LivroActivity::class.java)

        btnLivro1.setOnClickListener {
            novaTela.putExtra("nome_livro", "LOTR")
            startActivity(novaTela)
        }
        btnLivro2.setOnClickListener {
            novaTela.putExtra("nome_livro", "GOT")
            startActivity(novaTela)
        }
        btnLivro3.setOnClickListener {
            novaTela.putExtra("nome_livro", "Narnia")
            startActivity(novaTela)
        }

    }
}
