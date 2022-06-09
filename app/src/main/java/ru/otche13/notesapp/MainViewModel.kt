package ru.otche13.notesapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.otche13.notesapp.database.AppRoomDatabase
import ru.otche13.notesapp.database.RoomRepository
import ru.otche13.notesapp.model.Note
import ru.otche13.notesapp.utils.REPOSITORY
import ru.otche13.notesapp.utils.TYPE_FIREBASE
import ru.otche13.notesapp.utils.TYPE_ROOM

class MainViewModel(application:Application) :AndroidViewModel(application){

    val context=application

    fun initDatabase(type:String,onSuccsess:()->Unit){
        when(type){
            TYPE_ROOM->{
                val dao=AppRoomDatabase.getInstance(context = context).getRoomDao()
                REPOSITORY=RoomRepository(dao)
                onSuccsess()
            }
        }
    }
}


class MainViewModelFactory(private val application: Application):ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(application = application) as T
        }
        throw IllegalAccessException("Unknown ViewModel class")
    }

}