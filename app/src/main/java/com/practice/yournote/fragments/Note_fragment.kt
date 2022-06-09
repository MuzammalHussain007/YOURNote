package com.practice.yournote.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import com.practice.yournote.R
import com.practice.yournote.databinding.FragmentNoteFragmentBinding
import com.practice.yournote.utils.hideKeyboard
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class Note_fragment : Fragment(R.layout.fragment_note_fragment) {
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: FragmentNoteFragmentBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNoteFragmentBinding.bind(view)
        innit()

    }

    private fun innit() {

        val navHostFragment =
            activity?.supportFragmentManager?.findFragmentById(R.id.master_container) as NavHostFragment
        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.note_fragment)
        )
        navController = navHostFragment.findNavController()
        requireView().hideKeyboard()
        binding.noteToolBar.setOnClickListener {
            val action = Note_fragmentDirections.actionNoteFragmentToSaveOrDeleteFragment()
            findNavController().navigate(action)
        }
        binding.innerFab.setOnClickListener {
            findNavController().navigate(Note_fragmentDirections.actionNoteFragmentToSaveOrDeleteFragment())
        }




    }

}