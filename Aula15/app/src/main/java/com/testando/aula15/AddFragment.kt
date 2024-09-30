package com.testando.aula15

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.textfield.TextInputEditText
import com.testando.aula15.data.Livro
import com.testando.aula15.data.LivroViewModel

//botoes
lateinit var btnVoltar : Button
lateinit var btnAdd : Button
//input de texto
lateinit var txtNomeLivro : TextInputEditText
//banco
lateinit var livroViewModel: LivroViewModel

class AddFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)


        btnVoltar = view.findViewById(R.id.btnVoltar)
        btnAdd = view.findViewById(R.id.btnAddLivro)
        txtNomeLivro = view.findViewById(R.id.InputLivro)

        //importante -> ViewModelProvider
        livroViewModel = ViewModelProvider(this).get(LivroViewModel::class.java)


        btnVoltar.setOnClickListener{
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentConteudo, AddFragment())
                .commit()
        }

        btnAdd.setOnClickListener {
            addLivro()
        }

        return view
    }
    fun addLivro(){
        //pegar texto
        val nome = txtNomeLivro.text.toString()
        //criar um livro
        val novoLivro = Livro(0,nome,1900)
        //add no banco
        livroViewModel.addLivro(novoLivro)
        Toast.makeText(requireContext(), "Livro Adicionado", Toast.LENGTH_LONG).show()
        //voltar para a tela
        voltar()
    }
    //função para voltar após cadastro do livro
    fun voltar() {
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragmentConteudo, ListFragment())
            .commit()
    }
}

