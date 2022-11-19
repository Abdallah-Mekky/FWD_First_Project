package com.task1.shoesappfwd.ui.shoesList

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.task1.shoesappfwd.R
import com.task1.shoesappfwd.base.BaseViewModel
import com.task1.shoesappfwd.databinding.FragmentShoesListBinding
import com.task1.shoesappfwd.databinding.ItemShoeBinding
import com.task1.shoesappfwd.model.ItemShoe


class ShoesListFragment : Fragment() {


    private lateinit var shoesListFragmentBinding: FragmentShoesListBinding
    private val shoesListViewModel: BaseViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        setHasOptionsMenu(true)
        shoesListFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_shoes_list, container, false)
        return shoesListFragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        shoesListFragmentBinding.floatingAction.setOnClickListener {

            findNavController().navigate(R.id.action_shoesListFragment_to_shoeDetailsFragment)
        }

        subscribeToLiveData()
    }

    private fun subscribeToLiveData() {

        shoesListViewModel.shoesListLiveData.observe(viewLifecycleOwner) { shoes ->

            shoes.forEach {

                addView(it)
            }
        }
    }


    private fun addView(shoe: ItemShoe) {

        val itemShoeBinding: ItemShoeBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.item_shoe, null, false)

        itemShoeBinding.name.text = shoe.shoeName
        itemShoeBinding.company.text = shoe.shoeCompany
        itemShoeBinding.size.text = shoe.shoeSize
        itemShoeBinding.description.text = shoe.shoeDescription

        shoesListFragmentBinding.linearShoesList.addView(itemShoeBinding.root)
    }

    @Deprecated("Deprecated in Java")
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.shoes_list_menu, menu)
    }

    @Deprecated("Deprecated in Java")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)

        if (item.itemId == R.id.loginFragment) {
            findNavController().navigate(R.id.action_shoesListFragment_to_loginFragment)
        }
        return true
    }

}