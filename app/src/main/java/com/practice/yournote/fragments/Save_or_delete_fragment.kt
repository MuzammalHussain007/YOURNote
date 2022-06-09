package com.practice.yournote.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.practice.yournote.R
import com.practice.yournote.databinding.BottomSheetCardLayoutBinding
import com.practice.yournote.databinding.FragmentSaveOrDeleteFragmentBinding

import com.practice.yournote.modal.Note
import com.practice.yournote.mvvm.ViewModal.NoteViewModal
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*


class Save_or_delete_fragment : Fragment(R.layout.fragment_save_or_delete_fragment) {
    private lateinit var binding: FragmentSaveOrDeleteFragmentBinding
    private lateinit var navController: NavController
    private lateinit var note: Note;
    private var colors: Int = -1
    private val noteViewModal: NoteViewModal by activityViewModels()
    private val date = SimpleDateFormat.getInstance().format(Date())
    private val job = CoroutineScope(Dispatchers.Main)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSaveOrDeleteFragmentBinding.bind(view)
        navController = Navigation.findNavController(view)

        innit()
    }

    private fun innit() {
        binding.backbtn.setOnClickListener {
            navController.popBackStack()
        }
        binding.savebtn.setOnClickListener {
            saveNote()
            try {
                binding.etNote.setOnFocusChangeListener { _, hasFocus ->
                    if (hasFocus) {
                        binding.bottomBar.visibility = View.VISIBLE
                        binding.etNote.setStylesBar(binding.styleBar)
                    } else {
                        binding.bottomBar.visibility = View.GONE

                    }


                }
            } catch (e: Exception) {
                Log.d("TAG", "" + e)
            }

        }
        binding.showBottomSheet.setOnClickListener {
            val bottomSheetDialog = BottomSheetDialog(
                requireContext()
            )
            val bottomSheetView :View= layoutInflater.inflate(R.layout.bottom_sheet_card_layout,null)
            val bottomSheetBinding = BottomSheetCardLayoutBinding.bind(bottomSheetView)

            bottomSheetBinding.apply {
                colorPicker.apply {
                    setSelectedColor(colors)
                    setOnColorSelectedListener {
                        value->
                        colors = value
                        binding.bottomBar.setBackgroundColor(colors)

                    }
                }
            }
            bottomSheetView.post {
                bottomSheetDialog.behavior.state = BottomSheetBehavior.STATE_EXPANDED
            }
            bottomSheetDialog.setContentView(bottomSheetView)
            bottomSheetDialog.show()
        }


    }

    private fun saveNote() {
        if (binding.etNote.text.toString().isEmpty()||binding.input.text.toString().isEmpty())
        {
            Toast.makeText(requireContext(),"Some Thing is empty",Toast.LENGTH_SHORT)
        }
        else
        {
            when(note)
            {
                null->{
                    Note(
                        0,
                        binding.input.text.toString(),
                        binding.etNote.getMD(),
                        date,
                        colors
                    )
                    navController.navigate(Save_or_delete_fragmentDirections.actionSaveOrDeleteFragmentToNoteFragment())
                }
             }
        }

    }

}