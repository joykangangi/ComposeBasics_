package com.example.composebasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composebasics.ui.theme.ComposeBasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBasicsTheme {
                // A surface container using the 'background' color from the theme
                MyApp()
            }
        }
    }
}

@Composable
private fun Greeting(name: String) {
    val expanded = remember { mutableStateOf(false) }
    val extraPadding = if (expanded.value)48.dp else 0.dp
    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        Row(Modifier.padding(24.dp)) {
            Column(modifier = Modifier
                .weight(1f)
                .padding(bottom = extraPadding)) {
            Text(text = "Hello,")
            Text(text = "$name!") 
            }
            OutlinedButton(
                onClick = { expanded.value = !expanded.value },
            ) {
                Text(text = if (expanded.value ) "Show  Less" else "Show More")
            }
        }
    }
}

@Composable
private fun MyApp(names: List<String> = listOf("Gideon", "Sharon", "Joy")) {
       Column(modifier = Modifier.padding(vertical = 4.dp)) {
           for (name in names) {
               Greeting(name = name)
           }
       }
    }

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    ComposeBasicsTheme {
       MyApp()
    }
}