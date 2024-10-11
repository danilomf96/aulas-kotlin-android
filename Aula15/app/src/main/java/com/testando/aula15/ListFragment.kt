package com.testando.aula15

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.testando.aula15.data.LivroViewModel

class ListFragment : Fragment() {

    lateinit var btnAdd : FloatingActionButton
    lateinit var livroViewModel: LivroViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val view = inflater.inflate(R.layout.fragment_list, container, false)
       btnAdd = view.findViewById(R.id.floatBtnAdd)
       btnAdd.setOnClickListener{
           parentFragmentManager.beginTransaction()
               .replace(R.id.fragmentConteudo, AddFragment())
               .commit()
       }

        val adapter = LivroAdapter()
        val recyclerView = view.findViewById<RecyclerView>(R.id.rvListaLivros)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        livroViewModel = ViewModelProvider(this).get(LivroViewModel::class.java)
        livroViewModel.readAllData.observe(viewLifecycleOwner){livros -> adapter.setData(livros, parentFragmentManager)}

       return view
    }
}