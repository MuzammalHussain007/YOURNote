package com.practice.yournote.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.ui.AppBarConfiguration
import com.practice.yournote.R
import com.practice.yournote.database.DatabaseService
import com.practice.yournote.databinding.ActivityMainBinding
import com.practice.yournote.mvvm.NoteRepositry
import com.practice.yournote.mvvm.ViewModal.NoteViewModal
import com.practice.yournote.mvvm.ViewModal.NoteViewModalFactory
import java.lang.Exception

class ainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var noteViewModal: NoteViewModal
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        innit()
    }

    private fun innit() {
        try {
            val noteRepositry = NoteRepositry(DatabaseService.invoke(applicationContext))
            val noteViewModalFactory = NoteViewModalFactory(noteRepositry)
            noteViewModal = ViewModelProvider(this,noteViewModalFactory)[NoteViewModal::class.java]

        }catch (e:Exception)
        {
            Log.d("main____",e.toString())
        }


    }
}