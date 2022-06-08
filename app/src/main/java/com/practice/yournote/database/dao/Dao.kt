package com.practice.yournote.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Dao
import com.practice.yournote.modal.Note

@Dao
interface Dao {
       @Insert(onConflict = OnConflictStrategy.REPLACE)
       suspend fun insertNote(note : Note)
       @Query("SELECT * FROM Note ORDER BY id DESC")
       suspend fun getAllNote():LiveData<List<Note>>
       @Update
       suspend fun updateNote(note:Note)

       @Query("SELECT * FROM Note WHERE Title LIKE :query OR Content LIKE :query OR Data Like :query ")
       suspend fun searchNote(query:String):LiveData<List<Note>>

       suspend fun DeleteNote(note: Note)
}