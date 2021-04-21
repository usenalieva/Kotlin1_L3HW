package com.makhabatusen.kotlin1_l3hw.models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FragmentViewModel : ViewModel() {

    private var _counter = 0
    private val _stringBuilder = StringBuilder()

    val counter = MutableLiveData<Int?>()
    val textResult = MutableLiveData<String?>()

    fun onIncrementClick() {
        _counter++
        counter.value = _counter
        _stringBuilder.append(" +")
        textResult.value = _stringBuilder.toString()
    }

    fun onDecrementClick() {
        _counter--
        counter.value = _counter
        _stringBuilder.append(" -")
        textResult.value = _stringBuilder.toString()
    }
}