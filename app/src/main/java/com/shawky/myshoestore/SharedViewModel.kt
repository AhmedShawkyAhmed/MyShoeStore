package com.shawky.myshoestore

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shawky.myshoestore.Shoe


class SharedViewModel : ViewModel() {
    val shoe = MutableLiveData<Shoe>()
}