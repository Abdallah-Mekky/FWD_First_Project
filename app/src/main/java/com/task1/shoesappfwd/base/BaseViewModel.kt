package com.task1.shoesappfwd.base

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.task1.shoesappfwd.model.ItemShoe
import com.task1.shoesappfwd.ui.shoeDetails.Navigator

class BaseViewModel :ViewModel() {

    var shoeName = ObservableField<String>()
    var shoeCompany = ObservableField<String>()
    var shoeSize = ObservableField<String>()
    var shoeDescription = ObservableField<String>()

     private var toastMutableLiveData = MutableLiveData<String>()
     var toastLiveData: LiveData<String> = toastMutableLiveData


     private var shoesListMutableLiveData = MutableLiveData<MutableList<ItemShoe>>()
     var shoesListLiveData: LiveData<MutableList<ItemShoe>> = shoesListMutableLiveData


    private var shoesList = mutableListOf<ItemShoe>()

    var navigator: Navigator? = null


    fun addShoe(){

        if(checkDataExistence()){

           shoesList.add(ItemShoe(
                shoeName.get().toString(),shoeCompany.get().toString(),shoeSize.get().toString(),shoeDescription.get().toString()
            ))
            navigator?.navigateToShoesListFragment()

            shoesListMutableLiveData.value = shoesList

            clearFields()
            toastMutableLiveData.value = null

        }

    }

    fun cancel(){

        navigator?.navigateToShoesListFragment()
        clearFields()
    }




    private fun checkDataExistence(): Boolean {

        if(shoeName.get().isNullOrBlank()){

            toastMutableLiveData.value = "Enter Shoe Name"

            return false
        }

        if(shoeCompany.get().isNullOrBlank()){

            toastMutableLiveData.value = "Enter Shoe Company"

            return false
        }

        if(shoeSize.get().isNullOrBlank()){

            toastMutableLiveData.value = "Enter Shoe Size"

            return false

        }

        if(shoeDescription.get().isNullOrBlank()){

            toastMutableLiveData.value = "Enter Shoe Description"

            return false

        }

        return true
    }


    private fun clearFields(){

        shoeName.set(null)
        shoeCompany.set(null)
        shoeDescription.set(null)
        shoeSize.set(null)
    }
}