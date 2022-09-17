package com.shawky.myshoestore.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shawky.myshoestore.model.Shoe


class SharedViewModel : ViewModel() {
    val shoe = MutableLiveData<Shoe>()
}