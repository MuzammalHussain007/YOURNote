package com.practice.yournote.mvvm

import com.practice.yournote.database.DatabaseService
import com.practice.yournote.modal.Note

class NoteRepositry(private val dao: DatabaseService) {
    suspend fun getNote() = dao.dao().getAllNote()
    suspend fun searchNote(query: String) = dao.dao().searchNote(query)
    suspend fun addNote(note: Note) = dao.dao().insertNote(note)
    suspend fun deleteNote(note: Note) = dao.dao().DeleteNote(note)
    suspend fun updateNote(note: Note) = dao.dao().updateNote(note)

}