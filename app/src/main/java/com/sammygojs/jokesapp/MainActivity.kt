package com.sammygojs.jokesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import com.sammygojs.jokesapp.ui.theme.JokesAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JokesAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        myapp()
                    }

                }
            }
        }
    }
}


@Composable
fun myapp(){
    var showHelloWorldScreen by remember { mutableStateOf(true) }

    val jokes = arrayListOf<JokeModel>(
        JokeModel(
            id=1,
            question = "what is the joke",
            answer="this is the joke",
            answerIsVisible = true
        ),
        JokeModel(
            id=2,
            question = "what is the joke",
            answer="this is the joke",
            answerIsVisible = false
        ),
        JokeModel(
            id=3,
            question = "what is the joke",
            answer="this is the joke",
            answerIsVisible = false
        ),
        JokeModel(
            id=4,
            question = "what is the joke",
            answer="this is the joke",
            answerIsVisible = false
        ),
        JokeModel(
            id=5,
            question = "what is the joke",
            answer="this is the joke",
            answerIsVisible = false
        ),

        )

    LazyColumn() {
        items(jokes.size){index ->
            Joke1(jokeModel = jokes[index])
        }
    }
    if (showHelloWorldScreen) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = { showHelloWorldScreen = false }) {
                Text(text = "Open Hello World View")
            }
        }
    } else {
        HelloDialog(onClose = { showHelloWorldScreen = true })
    }

}

@Composable
fun HelloDialog(onClose: () -> Unit) {
    Surface(color = Color.White) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Hello World!",
                style = MaterialTheme.typography.labelLarge,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(16.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = onClose,
                modifier = Modifier.width(120.dp)
            ) {
                Text(text = "Close")
            }
        }
    }
}

@Composable
fun Joke1(jokeModel: JokeModel) {
    Text(text=jokeModel.id.toString())
    Text(text=jokeModel.question,
        modifier = Modifier.padding(16.dp),
        color = Color.Blue,
        fontSize = 8.em,
        fontWeight = FontWeight.Bold,
        lineHeight = 1.em,
        textAlign = TextAlign.Center
    )
    if(jokeModel.answerIsVisible) {
        Text(text = jokeModel.answer)
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

data class JokeModel(val id: Int, val question: String, val answer:String,
val answerIsVisible: Boolean){

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JokesAppTheme {
        Greeting("Android")
    }
}