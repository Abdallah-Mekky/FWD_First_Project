package com.task1.shoesappfwd.ui.welcome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.task1.shoesappfwd.R
import com.task1.shoesappfwd.databinding.FragmentWelcomeBinding


class WelcomeFragment : Fragment() {

    lateinit var welcomeFragmentBinding: FragmentWelcomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        welcomeFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_welcome, container, false)
        return welcomeFragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        welcomeFragmentBinding.nextButton.setOnClickListener {

            findNavController().navigate(R.id.action_welcomeFragment_to_instructionFragment)
        }
    }
}