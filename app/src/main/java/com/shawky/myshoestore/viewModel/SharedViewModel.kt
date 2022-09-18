package com.shawky.myshoestore.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shawky.myshoestore.model.Shoe


class SharedViewModel : ViewModel() {

    private val myShoeList = MutableLiveData<MutableList<Shoe>>(mutableListOf())
    val shoeListLiveData : LiveData<MutableList<Shoe>>
        get() = myShoeList

    private var shoeList = mutableListOf<Shoe>()

    init {
        myShoeList.value = shoeList
    }

    fun addShoe(shoe: Shoe) {
        myShoeList.value!!.add(shoe)
    }
}