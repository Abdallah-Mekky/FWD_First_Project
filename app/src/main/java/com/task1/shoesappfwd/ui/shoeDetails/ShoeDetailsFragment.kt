package com.task1.shoesappfwd.ui.shoeDetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.task1.shoesappfwd.R
import com.task1.shoesappfwd.base.BaseViewModel
import com.task1.shoesappfwd.databinding.FragmentShoeDetailsBinding


class ShoeDetailsFragment : Fragment(), Navigator {


    lateinit var shoesDetailsFragmentBinding: FragmentShoeDetailsBinding
    private val shoeDetailsViewModel: BaseViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        shoesDetailsFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_details, container, false)
        return shoesDetailsFragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        subscribeToLiveData()
        shoesDetailsFragmentBinding.baseViewModel = shoeDetailsViewModel
        shoeDetailsViewModel.navigator = this


    }

    override fun navigateToShoesListFragment() {

        findNavController().navigate(R.id.action_shoeDetailsFragment_to_shoesListFragment)
    }

    private fun subscribeToLiveData() {


        shoeDetailsViewModel.toastLiveData.observe(viewLifecycleOwner) {

            if(it != null)
            Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
        }
    }


}