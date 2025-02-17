package com.ideasapp.factorial

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    private val _error = MutableLiveData<Boolean>()
    val error: LiveData<Boolean>
        get() = _error

    private val _factorial = MutableLiveData<String>()
    val factorial: LiveData<String>
        get() = _factorial

    private val _progress = MutableLiveData<Boolean>()
    val progress: LiveData<Boolean>
        get() = _progress

    private fun calculateFactorial(value: String?) {
        if(value.isNullOrBlank()) {
            _error.value = true
            return
        }
        _progress.value = true
        val number = value.toLong()
        var result = 1
///CALCULATE
        _progress.value = false
        _factorial.value = number.toString()
    }
}