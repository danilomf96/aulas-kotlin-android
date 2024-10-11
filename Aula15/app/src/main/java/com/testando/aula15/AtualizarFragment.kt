package com.testando.aula15

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText
import com.testando.aula15.data.LivroViewModel

class AtualizarFragment : Fragment() {

    //botoes
    lateinit var btnVoltar : Button
    lateinit var btnAtt : Button
    //input de texto
    lateinit var txtNomeLivro : TextInputEditText
    //banco
    lateinit var livroViewModel: LivroViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_atualizar, container, false)

        btnVoltar = view.findViewById(R.id.btnVoltar)
        btnAtt = view.findViewById(R.id.btnAttLivro)
        txtNomeLivro = view.findViewById(R.id.InputLivro)

        val nome: String = arguments?.getString("nome") ?: "erro"
        txtNomeLivro.setText("$nome")


        btnVoltar.setOnClickListener {
            voltar()
        }

        btnAtt.setOnClickListener {
            atualizar()
        }

        return view
    }

    fun voltar() {
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragmentConteudo, ListFragment())
            .commit()
    }

    fun atualizar(){

    }
}