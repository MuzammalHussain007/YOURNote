package com.practice.yournote.mvvm.ViewModal

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.practice.yournote.modal.Note
import com.practice.yournote.mvvm.NoteRepositry
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModal(val repositry: NoteRepositry) :ViewModel() {

    fun saveNote(newNote: Note)=viewModelScope.launch(Dispatchers.IO) {
        repositry.addNote(newNote)
    }
    fun deleteNote(deleteNote:Note) = viewModelScope.launch(Dispatchers.IO) {
        repositry.deleteNote(deleteNote)
    }
    fun updateNote(existingNote:Note) = viewModelScope.launch(Dispatchers.IO) {
        repositry.updateNote(existingNote)
    }

    suspend fun searchNote(query:String) : LiveData<List<Note>>{
        return repositry.searchNote(query)
    }

    suspend fun getAllNote() : LiveData<List<Note>>{
        return repositry.getNote()
    }

}