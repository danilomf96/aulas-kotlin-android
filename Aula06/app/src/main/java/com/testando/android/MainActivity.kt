package com.testando.android

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    // Criar variaveis dos botoes -- nome igual o id

    private lateinit var textInputReal : TextInputLayout
    private lateinit var txtReal : TextInputEditText

    private lateinit var textInputDolar : TextInputLayout
    private lateinit var txtDolar : TextInputEditText

    private lateinit var btnCalcular : Button

    private lateinit var btnCalcularDolar : Button


    override fun onStart() {
        super.onStart()
        Log.i("ciclo de vida", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("ciclo de vida", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("ciclo de vida", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("ciclo de vida", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("ciclo de vida", "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("ciclo de vida", "onRestart")
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Chamando os botoes

        textInputReal = findViewById(R.id.textInputReal)
        textInputDolar = findViewById(R.id.textInputDolar)
        btnCalcularDolar =  findViewById(R.id.btnCalcularDolar)
        txtReal = findViewById(R.id.txtReal)
        txtDolar = findViewById(R.id.txtDolar)

        btnCalcular = findViewById(R.id.btnCalcular)
        btnCalcular.setOnClickListener {

            var valorReal = txtReal.text.toString()
            var valorDolar = valorReal.toFloat() / 5.6

            txtDolar.setText("$valorDolar")
        }
        btnCalcularDolar.setOnClickListener{
            var valorDolar = txtDolar.text.toString()
            var valorReal = valorDolar.toFloat() * 5.6

            txtReal.setText("$valorReal")
        }
    }
}