package com.practice.yournote.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.practice.yournote.database.dao.Dao
import com.practice.yournote.modal.Note

@Database(
version = 1,
    entities = [Note::class]
)
abstract class DatabaseService :RoomDatabase(){
    abstract fun dao():Dao
companion object{
    private val instance : DatabaseService? = null
    private val Lock= Any()

    operator fun invoke(context:Context) = instance ?: synchronized(Lock){
      instance?:buildDatabaseService(context)
    }

    private fun buildDatabaseService(context:Context)=
        Room.databaseBuilder(
            context.applicationContext,
            DatabaseService::class.java,"note.db"
        ).build()
}
}