package ru.otche13.notesapp.database

import androidx.lifecycle.LiveData
import androidx.room.Database
import ru.otche13.notesapp.model.Note

class RoomRepository(private val noteRoomDao: NoteRoomDao):DatabaseRepository {

    override val readAll: LiveData<List<Note>>
        get() = noteRoomDao.getAllNotes()

    override suspend fun create(note: Note, onSuccsess: () -> Unit) {
        noteRoomDao.addNote(note = note)
    }

    override suspend fun update(note: Note, onSuccsess: () -> Unit) {
       noteRoomDao.updateNote(note=note)
    }

    override suspend fun delete(note: Note, onSuccsess: () -> Unit) {
        noteRoomDao.deleteNote(note = note)
    }
}