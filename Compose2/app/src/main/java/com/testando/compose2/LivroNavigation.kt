package com.testando.compose2

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.testando.compose2.telas.TelaDetalhes
import com.testando.compose2.telas.TelaMenu

@Composable
fun LivroNavigation(){
    val navController = rememberNavController()

    NavHost(navController, startDestination = "menu"){
        composable("menu"){
            TelaMenu(navController)
        }
        composable("detalhes/{nomeLivro}") {
            val nomeLivro = it.arguments?.getString("nomeLivro")
            TelaDetalhes(navController, nomeLivro)
        }
    }
}