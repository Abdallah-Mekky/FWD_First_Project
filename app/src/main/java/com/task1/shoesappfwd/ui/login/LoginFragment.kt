package com.task1.shoesappfwd.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.task1.shoesappfwd.R
import com.task1.shoesappfwd.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    lateinit var loginFragmentBinding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        loginFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        return loginFragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loginFragmentBinding.loginButton.setOnClickListener {

            findNavController().navigate(R.id.action_loginFragment_to_welcomeFragment)
        }

        loginFragmentBinding.registerButton.setOnClickListener {

            findNavController().navigate(R.id.action_loginFragment_to_welcomeFragment)
        }
    }
}