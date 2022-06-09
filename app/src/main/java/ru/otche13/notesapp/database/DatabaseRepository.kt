package ru.otche13.notesapp.database

import androidx.lifecycle.LiveData
import ru.otche13.notesapp.model.Note

interface DatabaseRepository {

    val readAll:LiveData<List<Note>>

    suspend fun create(note:Note,onSuccsess:()->Unit)

    suspend fun update(note:Note,onSuccsess:()->Unit)

    suspend fun delete(note:Note,onSuccsess:()->Unit)

}