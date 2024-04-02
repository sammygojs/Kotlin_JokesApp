package com.sammygojs.jokesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
                    Greeting("Android")
                    Joke1(question = "what is the joke", answer="this is the joke")
                }
            }
        }
    }
}

@Composable
fun Joke1(question: String, answer: String) {
    Text(text=question,
    modifier = Modifier.padding(16.dp),
    color = MaterialTheme.colorScheme.primary,
        style = MaterialTheme.typography.labelLarge,
        textAlign = androidx.compose.ui.text.style.TextAlign.Center
    )
//    Text(text=answer)
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JokesAppTheme {
        Greeting("Android")
    }
}