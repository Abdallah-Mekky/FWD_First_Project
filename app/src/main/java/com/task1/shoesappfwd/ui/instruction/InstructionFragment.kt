package com.task1.shoesappfwd.ui.instruction

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.task1.shoesappfwd.R
import com.task1.shoesappfwd.databinding.FragmentInstructionBinding


class InstructionFragment : Fragment() {

    lateinit var instructionFragmentBinding: FragmentInstructionBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        instructionFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_instruction, container, false)
        return instructionFragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        instructionFragmentBinding.nextButton.setOnClickListener {

            findNavController().navigate(R.id.action_instructionFragment_to_shoesListFragment)
        }
    }
}