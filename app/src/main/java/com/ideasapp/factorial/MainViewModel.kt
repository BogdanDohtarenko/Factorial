package com.ideasapp.factorial

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    private val _state = MutableLiveData<ScreenState>()
    val state: LiveData<ScreenState>
        get() = _state

    fun calculateFactorial(value: String?) {
        if(value.isNullOrBlank()) {
            _state.value = ScreenState(error = true)
            return
        }
        _state.value = ScreenState(progress = true)
        val number = value.toLong()
        var result: Long = 1
        for(i in 1..number) {
            result *= i
        }
        _state.value = ScreenState(progress = false, factorial = result.toString())
    }
}