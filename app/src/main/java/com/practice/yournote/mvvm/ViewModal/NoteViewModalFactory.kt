package com.practice.yournote.mvvm.ViewModal

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.practice.yournote.mvvm.NoteRepositry

class NoteViewModalFactory(val repositry: NoteRepositry):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
    if (modelClass.isAssignableFrom(NoteViewModal::class.java))
    {
        @Suppress("UNCHECKED_CAST")
        return NoteViewModal(repositry) as T
    }
        throw IllegalArgumentException("Unable to construct viewmodel")

    }
}