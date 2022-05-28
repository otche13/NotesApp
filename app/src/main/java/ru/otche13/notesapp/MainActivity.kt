package ru.otche13.notesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.otche13.notesapp.navigation.NotesNavHost
import ru.otche13.notesapp.ui.theme.NotesAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotesAppTheme {
                Scaffold(
                    topBar={
                           TopAppBar(
                               title = { Text(text="NotesApp") },
                               backgroundColor= Color.Blue,
                               contentColor=Color.White,
                               elevation = 12.dp
                           ) 
                    },
                    content={
                        Surface(
                            modifier=Modifier.fillMaxSize(),
                            color=MaterialTheme.colors.background
                        ) {
                            NotesNavHost()
                        }
                    }
                )

            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NotesAppTheme {

    }
}