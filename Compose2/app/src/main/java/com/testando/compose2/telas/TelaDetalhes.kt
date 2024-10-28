package com.testando.compose2.telas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController



@Composable
fun TelaDetalhes(navController: NavHostController, nomeLivro: String?) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column( modifier = Modifier.padding(20.dp),horizontalAlignment = Alignment.CenterHorizontally)
        {
            Text(text = "Livro: ", fontSize = 30.sp, modifier = Modifier.padding(top = 50.dp))
            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = {
                navController.popBackStack()
            }) {
            Text(text = "Voltar")
            }
        }
    }
}