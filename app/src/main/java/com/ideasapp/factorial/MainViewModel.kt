package com.ideasapp.factorial

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.math.BigInteger
import kotlin.concurrent.thread
import kotlin.coroutines.suspendCoroutine

class MainViewModel: ViewModel() {

    private val _state = MutableLiveData<ScreenState>()
    val state: LiveData<ScreenState>
        get() = _state

    fun calculate(value: String?) {
        if(value.isNullOrBlank()) {
            _state.value = ScreenState.Error
            return
        }
        _state.value = ScreenState.Progress
        viewModelScope.launch {
            _state.value = ScreenState.Factorial(factorial = calculateFactorial(value))
        }
    }

    private suspend fun calculateFactorial(value: String): String {
        return withContext(Dispatchers.Default) {
            val number = value.toInt()
            var result = BigInteger.ONE
            for(i in 1..number) { result *= i.toBigInteger() }
            result.toString()
        }
    }
}