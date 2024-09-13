package com.testando.aula09

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.testando.aula09.fragmentos.Contato

class RecyclerViews : AppCompatActivity() {

    lateinit var rvContato : RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycler_view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        rvContato = findViewById(R.id.rvListaContato)
        //val contatos = listOf("Danilo" , "Aline" ,"José", "Jorge")

        val contatos = listOf(
            Contato("Roger", "Falaai","10:10","-"),
            Contato("Garro", "Poropopo","20:20","-"),
            Contato("Memphis", "Vai Timão","15:10","-"),
            Contato("Yuri Alberto", "Errei dnv...","14:00","-")
        )
        rvContato.adapter = ContatoAdapter(contatos)
        rvContato.layoutManager = LinearLayoutManager(this)
    }
}