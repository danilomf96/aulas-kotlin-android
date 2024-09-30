package com.testando.aula15

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListFragment : Fragment() {

    lateinit var btnAdd : FloatingActionButton

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

       return view
    }


}