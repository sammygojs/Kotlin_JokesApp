package com.sammygojs.jokesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
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
//                    Greeting("Android")
                    Column {

                        val jokes = arrayListOf<JokeModel>(
                            JokeModel(
                                id=1,
                                question = "what is the joke",
                                answer="this is the joke",
                                answerIsVisible = false
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

//                        val jokeModel = JokeModel(
//                            id=1,
//                            question = "what is the joke",
//                            answer="this is the joke",
//                            answerIsVisible = false
//                        )
//                        val jokeModel2 = JokeModel(
//                            id=1,
//                            question = "what is the joke",
//                            answer="this is the joke",
//                            answerIsVisible = false
//                        )
//                        Joke1(jokeModel)
//                        Joke1(jokeModel2)
//                        Joke1(question = "what is the joke2", answer="this is the joke2")
                        jokes.forEach() { joke ->
                            Joke1(jokeModel = joke)
                        }
                    }

                }
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