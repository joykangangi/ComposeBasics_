package com.example.composebasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composebasics.ui.theme.ComposeBasicsTheme
import com.google.android.material.color.MaterialColors

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
    var expanded by rememberSaveable { mutableStateOf(false) }
    val extraPadding by animateDpAsState(
        if (expanded)48.dp else 0.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        )
    )
    val changeColor = if (expanded) Color.Yellow else Color.White

    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        Row(Modifier.padding(24.dp)) {
            Column(modifier = Modifier
                .weight(1f)
                .padding(bottom = extraPadding)
                .background(changeColor)) {
                Text(text = "Hello,")
                Text(text = "$name!")
            }
            OutlinedButton(
                onClick = { expanded = !expanded }
            ) {
                Text(text = if (expanded ) "Show  Less" else "Show More")
            }
        }
    }
}

@Composable
private fun MyApp() {
    var shouldShowOnBoarding by rememberSaveable {
        mutableStateOf(true)
    }
    if (shouldShowOnBoarding) {
        OnBoardingScreen(onContinueClicked = {shouldShowOnBoarding = false})
    } else {
        Greetings()
    }
}
@Composable
private fun Greetings(names: List<String> = List(1000){"$it"}) {
    //here $it represents the list index
    LazyColumn(modifier = Modifier.padding(vertical = 4.dp)) {
        items(items = names) { name ->
            Greeting(name = name)
        }
    }
}


@Composable
private fun OnBoardingScreen(onContinueClicked:() -> Unit) {

    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,//align column contents at the centre
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Welcome to the basics Codelab")
        Button(
            onClick = {  },
            modifier = Modifier.padding(vertical = 24.dp)
        ) {
            Text("Continue")
        }
    }
}
/**
By passing a function and not a state to OnboardingScreen we are making
this composable more reusable and protecting the state from being
mutated by other composables.
 */

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    ComposeBasicsTheme {
        OnBoardingScreen(onContinueClicked = {})
        MyApp()
    }
}