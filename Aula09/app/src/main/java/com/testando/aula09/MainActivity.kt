package com.testando.aula09

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.testando.aula09.fragmentos.BlankFragment
import com.testando.aula09.fragmentos.OutroFragmento


class MainActivity : AppCompatActivity() {


    lateinit var btnFrag1 : Button
    lateinit var btnFrag2 : Button
    lateinit var btnFrag3 : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnFrag1 = findViewById(R.id.button1)
        btnFrag2 = findViewById(R.id.button2)
        btnFrag3 = findViewById(R.id.button3)

        val fragmentManager = supportFragmentManager.beginTransaction()
        fragmentManager.add(R.id.fragmentContainerView2, OutroFragmento())
        fragmentManager.commit()

        btnFrag1.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView2, OutroFragmento()).commit()
        }
        btnFrag2.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView2, BlankFragment()).commit()
        }
    }
}