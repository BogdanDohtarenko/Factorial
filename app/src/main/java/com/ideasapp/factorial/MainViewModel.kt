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

    fun calculateFactorial(value: String?) {
        if(value.isNullOrBlank()) {
            _progress.value = false
            _error.value = true
            return
        }
        _progress.value = true
        val number = value.toLong()
        var result: Long = 1
        for(i in 1..number) {
            result *= i
        }
        _progress.value = false
        _factorial.value = result.toString()
    }
}