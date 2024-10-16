package com.testando.exercicioaula07

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

private lateinit var txtUsuario : TextInputEditText
private lateinit var btnLogin : Button
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btnLogin = findViewById(R.id.btnLogin)
        txtUsuario = findViewById(R.id.txtUsuario)

        btnLogin.setOnClickListener {
            val intent = Intent(this, PrimeiraPagina::class.java)
            intent.putExtra("nome_usuario" , txtUsuario.text.toString())
            startActivity(intent)
        }
    }
}