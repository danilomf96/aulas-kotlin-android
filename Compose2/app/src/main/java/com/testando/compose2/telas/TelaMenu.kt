package com.testando.compose2.telas

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.testando.compose2.data.Livro
import com.testando.compose2.data.LivroDatabase
import com.testando.compose2.ui.theme.Compose2Theme
import kotlinx.coroutines.launch

//@Preview(showBackground = true)
@Composable
fun TelaMenu(navController: NavController) {
    Compose2Theme {
        Surface (
                modifier = Modifier.fillMaxSize(),
                shape = RoundedCornerShape(10.dp),
                shadowElevation = 10.dp,
                border = BorderStroke(0.1.dp, Color.LightGray),
            )
            {

                val livros = listOf(
                    Livro(0, "O Senhor dos Aneis", "1954"),
                    Livro(1, "O Senhor dos Aneis", "1954"),
                    Livro(2, "O Senhor dos Aneis", "1954")
                )

                Column {
                    InputNovoLivro()
                    Spacer(modifier = Modifier.height(10.dp))
                    ListaDeLivros(livros, navController)
                }
            }
        }
    }


    @Composable
    fun InputNovoLivro(){

        var nome by remember { mutableStateOf("") }
        var ano by remember { mutableStateOf("") }
        val coroutineScope = rememberCoroutineScope()
        val ctx = LocalContext.current
        val db = LivroDatabase.getDatabase(ctx)


        Column(
            modifier = Modifier.padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Novo Livro" , fontSize = 30.sp, modifier = Modifier.padding(top = 50.dp))
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth() ,
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                OutlinedTextField(
                    value = nome,
                    onValueChange = { nome = it },
                    label = { Text("Nome: ") },
                    modifier = Modifier.weight(1f))
                OutlinedTextField(
                    value = ano,
                    onValueChange = { ano = it },
                    label = { Text("Ano ") },
                    modifier = Modifier.weight(1f))
            }
            Button(onClick = {
                coroutineScope.launch { // Usa o escopo de corrotina aqui
                    val novoLivro = Livro(0, nome, ano)
                    db.livroDao().addLivro(novoLivro)
                }
            }) {
                Text(text = "Criar Livro")
            }
        }
    }



    @Composable
    fun ListaDeLivros(livros: List<Livro>, navController: NavController){
        LazyColumn {
            items(livros){ livro ->
                CardLivro(livro){
                    li -> navController.navigate(route="detalhes/$li")
                }
            }
        }
    }



    @Composable
    fun CardLivro(livro: Livro, escolherLivro: (String) -> Unit={}){
        Card(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth().clickable {
                    escolherLivro(livro.nome)
                },
            elevation = CardDefaults.cardElevation(4.dp)
        ) {
            Column(modifier = Modifier.padding(6.dp)) {
                Text(text = "Id: ${livro.id}", style = MaterialTheme.typography.bodySmall)
                Text(text = "Nome: ${livro.nome}", style = MaterialTheme.typography.headlineLarge)
                Text(text = "Ano: ${livro.ano}", style = MaterialTheme.typography.bodyMedium)
            }
        }
    }