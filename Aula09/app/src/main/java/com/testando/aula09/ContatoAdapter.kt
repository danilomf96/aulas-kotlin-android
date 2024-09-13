package com.testando.aula09

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.testando.aula09.fragmentos.Contato

class ContatoAdapter(val lista : List<Contato>) : Adapter<ContatoAdapter.ContatoViewHolder>() {
    inner class ContatoViewHolder (val itemView: View): ViewHolder(itemView){
         val txtNome : TextView = itemView.findViewById(R.id.nomeContato)
         val txtMsg : TextView = itemView.findViewById(R.id.mensagemContato)
         val txtHora : TextView = itemView.findViewById(R.id.horaMensagem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContatoViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.item_lista, parent, false)
        return ContatoViewHolder(itemView)

    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(contatoHolder: ContatoViewHolder, position: Int) {
        val contato = lista[position]
        contatoHolder.txtNome.text = contato.nome
        contatoHolder.txtMsg.text = contato.msg
        contatoHolder.txtHora.text = contato.hora
        // contatoHolder.txtNome.text = contato.nome
    }
}