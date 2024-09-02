package com.testando.exlayout.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(modifier : Modifier){
    Text(text = "Layout", modifier = modifier)
}

@Preview
@Composable
fun ExemploLayout() {
    val colors1 = mutableListOf(Color.Red,
                               Color.Green)
    val colors2 = mutableListOf(Color.Yellow,
                                Color.Blue)
    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier.fillMaxSize()
                .background(Color.LightGray).weight(1f)
        ) {

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
                    .background(Color.Red)
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
                    .background(Color.Green)
            )

        }

        Row(
            modifier = Modifier.fillMaxSize()
                .background(Color.Gray).weight(1f)
        ) {


            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
                    .background(Color.Yellow)
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
                    .background(Color.Blue)
            )
        }
    }
}