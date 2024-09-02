package com.testando.exlayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.testando.exlayout.ui.screen.ExemploLayout
import com.testando.exlayout.ui.screen.HomeScreen
import com.testando.exlayout.ui.screen.SegundaScreen
import com.testando.exlayout.ui.screen.TerceiraScreen
import com.testando.exlayout.ui.theme.MeuAppTema
import com.testando.exlayout.ui.theme.MeuAppTema

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MeuAppTema {
                MeuApp()
            }
        }
    }
}
@Preview
@Composable
fun MeuApp(){
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        val padding = Modifier.padding(innerPadding)
        val tela = 1;
        when(tela){
            1 -> ExemploLayout()
            2 -> SegundaScreen(padding)
            3 -> TerceiraScreen(padding)
        }
        HomeScreen(padding)
    }
}

