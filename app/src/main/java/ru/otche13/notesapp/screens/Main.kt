package ru.otche13.notesapp.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ru.otche13.notesapp.navigation.NavRoute
import ru.otche13.notesapp.ui.theme.NotesAppTheme

@Composable
fun MainScreen(navController: NavHostController) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
               navController.navigate(NavRoute.Add.route)
                }) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription ="Add icons",
                    tint= Color.White
                )
            }
        }
    ) {
        Column() {
            NoteItem(title ="Note 1" , subtitle ="For note 1" , navController =navController)
            NoteItem(title ="Note 2" , subtitle ="For note 2" , navController =navController)
            NoteItem(title ="Note 3" , subtitle ="For note 3" , navController =navController)
            NoteItem(title ="Note 4" , subtitle ="For note 4" , navController =navController)
        }

    }
    }
@Composable
    fun NoteItem(title:String,subtitle:String,navController: NavHostController){
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .padding(horizontal = 24.dp)
                .clickable {
                    navController.navigate(NavRoute.Note.route)
                },
            elevation = 6.dp
        ) {
            Column(
                modifier = Modifier.padding(vertical = 8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {


                Text(
                    text = title,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = subtitle,
                    fontSize = 16.sp
                )
            }
        }
    }


@Composable
@Preview(showBackground = true)
fun prevMainScreen(){
    NotesAppTheme {
        MainScreen(navController = rememberNavController())
    }
}